package LogicLayer;

import Containers.Article;

import java.util.List;

public interface LogicControllerInterface {


    public void createSite(String mainURL, String name,String prefix,String suffix, List<String> contentPath, List<String> authorPath, List<String> titlePath, List<String> publishingDatePath, List<String> categoryPath, List<String> tagsPath);
    public void downloadArticles(List<String> IDs,String siteName);
}
