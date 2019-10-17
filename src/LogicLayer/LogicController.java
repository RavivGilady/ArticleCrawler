package LogicLayer;

import Containers.Article;

import java.util.LinkedList;
import java.util.List;

public class LogicController implements LogicControllerInterface {
    private List<PublishingSite> publishingSites;
    private ArticleBuilder articleBuilder;


    public LogicController() {
        this.publishingSites = new LinkedList<>();
        articleBuilder=new ArticleBuilder();
    }

    @Override
    public void createSite(String mainURL, String name,String prefix,String suffix, List<String> contentPath, List<String> authorPath, List<String> titlePath, List<String> publishingDatePath, List<String> categoryPath, List<String> tagsPath) {

        PublishingSite newSite=new PublishingSite(mainURL,name,prefix,suffix);
        newSite.createRules(contentPath,authorPath,titlePath,publishingDatePath,categoryPath,tagsPath);
    }

    @Override
    public void downloadArticles(List<String> IDs,String siteName) {
        for(PublishingSite ps: publishingSites)
        {
            if ((ps.getName().equals(siteName)) &&ps.isCreatedRules())
            {
                Rules siteRules=ps.getSiteRules();
                //articleBuilder.downloadArticles(siteName,siteRules,ps.getMainURL(),IDs);
            }
            else {
                System.out.println(ps.getName() + " is not equal to the wanted site name: " +siteName);
            }
        }

    }
}
