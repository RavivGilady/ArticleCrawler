package DataLayer;

import Containers.Article;

import java.util.List;

public interface ArticleHandler {

    void saveArticle(String Author, String category,String onSiteID,
                     String ID,String title,String publishingDate,
                     String siteName,String content);
    List<Article> loadArticles(List<String> Author, List<String> category,List<String> onSiteID,
                               List<String> ID,List<String> title,List<String> publishingDate,
                               List<String> siteName,List<String> content);
}
