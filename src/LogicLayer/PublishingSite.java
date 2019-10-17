package LogicLayer;

import Containers.Article;

import java.util.LinkedList;
import java.util.List;


public class PublishingSite {
    private String mainURL;
    private String name;
    private Rules siteRules;
    private List<Article> articlesCache;
    private boolean createdRules;

    public PublishingSite(String mainURL, String name,String prefix,String suffix) {
        this.mainURL = mainURL;
        this.name = name;
        articlesCache =new LinkedList<>();
        this.siteRules=new Rules(prefix,suffix);
        createdRules=false;
    }


    public void createRules(List<String> contentPath,List<String> authorPath,List<String> titlePath, List<String> publishingDatePath, List<String> categoryPath, List <String> tagsPath)
    {

        //siteRules.setRules(contentPath,authorPath,titlePath,publishingDatePath,categoryPath,tagsPath);
        createdRules=true;
    }

    public String getMainURL() {
        return mainURL;
    }

    public String getName() {
        return name;
    }

    public Rules getSiteRules() {
        return siteRules;
    }

    public boolean isCreatedRules() {
        return createdRules;
    }
}
