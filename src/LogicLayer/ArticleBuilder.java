package LogicLayer;

import Containers.Article;
import DataLayer.ArticleHandler;
import DataLayer.MySQL_ArticleHanlder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

public class ArticleBuilder {
    private Document fullArticlePage;
    private Rules siteRules;
    private ArticleHandler articleHandler;

    public ArticleBuilder() {

        articleHandler=new MySQL_ArticleHanlder();
    }

    public void downloadArticle(String siteName, Rules siteRules,String ID) {
        Article article;
        this.siteRules=siteRules;
        fullArticlePage=null;
        downloadArticle(ID);
        if(fullArticlePage!=null) {
            article = buildArticle(siteName, ID);
            if(article!=null) {
                saveArticle(article);
            }
        }
    }

    private void saveArticle(Article article) {
        String author= toStringWithNoBrackets(article.getAuthor());
        String categories=toStringWithNoBrackets(article.getCategory());
        String titles=toStringWithNoBrackets(article.getTitle());
        String publishingDates=toStringWithNoBrackets(article.getPublishingDate());
        articleHandler.saveArticle(author,categories,article.getOnSiteID(),article.getOnDataBaseID().toString()
                ,titles,publishingDates,article.getSiteName(),article.getContent());
    }

    private String toStringWithNoBrackets(List<String> list) {
    String output=list.toString();
    return (output.substring(1,output.length()-1));

    }

    private Article buildArticle(String siteName, String ID) {
        try {
            Article newArticle=new Article(ID, siteName);
            newArticle.setTitle(getTitles());
            newArticle.setCategory(getCategories());
            newArticle.setAuthor(getAuthors());
            newArticle.setPublishingDate(getPublishingDate());
            newArticle.setContent(getContent());
            newArticle.setTags(getTags());
            return newArticle;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        }   

    private String extractDataFromTags (String query){
        String data="";
        Elements elements= fullArticlePage.select(query);
        if (elements==null ||elements.isEmpty())
            return null;
        for (Element element : elements)
            data+=element.text()+", ";
        if(data.length()>2)
            data=data.substring(0,data.length()-2);
        return data;

    }

    private List<String> getTitles () {
    List<String> titles=new LinkedList<>();
    for (String titlePath :siteRules.getTitlePath()) {
        String title = extractDataFromTags(titlePath);
        if (title != null && !title.equals(""))
            titles.add(title);
    }
    return titles;
}

    private List<String> getCategories () {
        List<String> categories=new LinkedList<>();
        for (String categoryPath :siteRules.getCategoryPath()) {
            String Category = extractDataFromTags(categoryPath);
            if (Category != null && !Category.equals(""))
                categories.add(Category);
        }
        return categories;
    }

    private List<String> getPublishingDate () {
        List<String> dates=new LinkedList<>();
        for (String datePath :siteRules.getPublishingDatePath()) {
            String date = extractDataFromTags(datePath);
            if (date != null && !date.equals(""))
                dates.add(date);
        }
        return dates;
    }

    private List<String> getTags () {
        List<String> tags=new LinkedList<>();
        for (String tagsPath :siteRules.getTagsPath()) {
            String tag = extractDataFromTags(tagsPath);
            if (tag != null && !tag.equals(""))
                tags.add(tag);
        }
        return tags;
    }

    private String getContent () {
        String content="";
        for (String query : siteRules.getContentPath()) {
            Elements contentElements = fullArticlePage.select(query);
            Elements badElements= getBadElements(siteRules.getContentCleanPath());
            contentElements.remove(badElements);
            for (Element contentElement :contentElements) {
                content += contentElement.toString() + "\n";
            }
        }


        return content;
    }

    private Elements getBadElements(List<String> badElementsPaths) {
            Elements badElements=new Elements();
            for(String badElementQuery : badElementsPaths)
                badElements.addAll(fullArticlePage.select(badElementQuery));

            return badElements;
        }

    private List<String> getAuthors () {
        List<String> authors = new LinkedList<>();
        for (String authorPath : siteRules.getAuthorPath()) {
            String author=extractDataFromTags(authorPath);
            if (author!=null && !author.equals(""))
                authors.add(author);
        }
        return authors;
    }

    private  void downloadArticle(String ID){

        String fullURL=siteRules.getFullURL(ID);
        Connection con = Jsoup.connect(fullURL);
        try {
            if (con.execute().statusCode() == 200)
            {
                fullArticlePage=con.get();
                if(!isValidArticlePage())
                    fullArticlePage=null;
            }
        }
        catch (Exception e){
            System.out.println("problem with " + ID);
        }   // TODO logger

    }

    private boolean isValidArticlePage() {
        List<String> badPageTitles=siteRules.getNotFoundArticleTitles();
        for (String badTitle : badPageTitles)
        {
            if(fullArticlePage.title().equals(badTitle))
                return false;
        }
        return true;
    }


}
