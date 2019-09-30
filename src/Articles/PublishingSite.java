package Articles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.net.URL;


public class PublishingSite {
    private String mainURL;
    private String name;
    private Rules siteRules;
    private List<Article> articles;
    private boolean createdRules;

    public PublishingSite(String mainURL, String name,String prefix,String suffix) {
        this.mainURL = mainURL;
        this.name = name;
        articles=new LinkedList<Article>();
        this.siteRules=new Rules(prefix,suffix);
        createdRules=false;
    }

    public void createArticle(String articleID)
    {
        if (!createdRules)
        {
            System.out.println("Cannot create article " +articleID + ". No Rules Given!!");
            return;
        }

        try {
            String fullURL = createArticleFullURL(articleID);
            System.out.println(downloadArticle(fullURL));
        }
        catch (Exception ex)
        {

        }

    }


    public void createRules(List<String> contentPath,List<String> authorPath,List<String> titlePath, List<String> publishingDatePath, List<String> categoryPath, List <String> tagsPath)
    {

        siteRules.setRules(contentPath,authorPath,titlePath,publishingDatePath,categoryPath,tagsPath);
        createdRules=true;
    }
    private String downloadArticle(String articleURL)
    {
        String articleWebPage="";
        try {
            URL url = new URL(articleURL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line=reader.readLine();
            while (line!=null)
            {
                articleWebPage= articleWebPage + "\n" + line;
                line=reader.readLine();
            }
            return articleWebPage;

        }
        catch (Exception ex)
        {
            System.out.println("id not found"); //TODO : logger
            return "";

        }
    }
    private String createArticleFullURL(String articleID){
        return (siteRules.getPrefix() + articleID + siteRules.getSuffix());
    }
}
