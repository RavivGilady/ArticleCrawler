import LogicLayer.ArticleBuilder;
import LogicLayer.Rules;
import java.util.LinkedList;
import java.util.List;

public class examination {
    public static void main(String[] args) {

        String ID="1001303826";

        Rules debugRules=new Rules("https://www.globes.co.il/news/article.aspx?did=","");
        List<String> titlesRule=new LinkedList<>();
        titlesRule.add(".mainPartContent #F_Title");
        titlesRule.add(".mainPartContent #coteret_SubCoteretText");
        debugRules.setTitlePath(titlesRule);

        List<String> authorRules=new LinkedList<>();
        authorRules.add(".mainPartContent .articleInfo > a");
        debugRules.setAuthorPath(authorRules);

        List<String> datesRules=new LinkedList<>();
        datesRules.add(".mainPartContent .articleInfo .timestamp");
        debugRules.setPublishingDatePath(datesRules);

        List<String> badElements=new LinkedList<>();
        badElements.add(".compReadMore");
        badElements.add(".compBanner");
        badElements.add("compNewsletter");
        badElements.add("connected");
        debugRules.setContentCleanPath(badElements);

        List<String> contentRules=new LinkedList<>();
        contentRules.add(".mainPartContent .artBigImage");
        contentRules.add(".mainPartContent .articleInner p, .mainPartContent .articleInner img");
        debugRules.setContentPath(contentRules);

        List<String> tagsRules=new LinkedList<>();
        tagsRules.add("article .tags #Tagiut_Tohen a");
        debugRules.setTagsPath(tagsRules);

        List<String> categoriesRules=new LinkedList<>();
        categoriesRules.add(".G_BradCrams a +a");
        debugRules.setCategoryPath(categoriesRules);

        ArticleBuilder articleBuilder=new ArticleBuilder();
        articleBuilder.downloadArticle("Globes",debugRules,ID);


    }
}
