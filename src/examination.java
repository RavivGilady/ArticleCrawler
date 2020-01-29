import LogicLayer.ArticleBuilder;
import LogicLayer.Rules;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class examination {
    public static void main(String[] args) {

        test();
        Rules debugRules=new Rules("https://www.globes.co.il/news/article.aspx?did=","");
        List<String> titlesRule=new LinkedList<>();
        titlesRule.add(".mainPartContent #F_Title");
        titlesRule.add(".mainPartContent #coteret_SubCoteretText");
        debugRules.setTitlePath(titlesRule);

        List<String> authorRules=new LinkedList<>();
        authorRules.add(".mainPartContent .articleInfo > a");
        authorRules.add(".mainPartContent .author");

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


        String ID="";
        for (int i = 81766; i < 1101303845; i++) {

            ID = "" + i;
            articleBuilder.downloadArticle("Globes", debugRules, ID);

        }
    }

    private static void test() {}
}
