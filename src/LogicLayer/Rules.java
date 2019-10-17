package LogicLayer;

import java.util.LinkedList;
import java.util.List;

public class Rules {
    private String prefix;
    private String suffix;

    private List<String> titlePath;
    private List<String>authorPath;
    private List<String> publishingDatePath;
    private List<String> categoryPath;
    private List<String> contentPath;
    private List<String> contentCleanPath;
    private List<String> tagsPath;
    private List<String> notFoundArticleTitles;


    public Rules(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
        titlePath=new LinkedList<>();
        authorPath=new LinkedList<>();
        publishingDatePath=new LinkedList<>();
        categoryPath=new LinkedList<>();
        contentCleanPath=new LinkedList<>();
        contentPath=new LinkedList<>();
        tagsPath=new LinkedList<>();
        notFoundArticleTitles=new LinkedList<>();
    }

    public String getFullURL(String ID)
    {
        return (prefix + ID + suffix);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public List<String> getTitlePath() {
        return titlePath;
    }

    public void setTitlePath(List<String> titlePath) {
        this.titlePath = titlePath;
    }

    public List<String> getAuthorPath() {
        return authorPath;
    }

    public void setAuthorPath(List<String> authorPath) {
        this.authorPath = authorPath;
    }

    public List<String> getPublishingDatePath() {
        return publishingDatePath;
    }

    public void setPublishingDatePath(List<String> publishingDatePath) {
        this.publishingDatePath = publishingDatePath;
    }

    public List<String> getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(List<String> categoryPath) {
        this.categoryPath = categoryPath;
    }

    public List<String> getContentPath() {
        return contentPath;
    }

    public void setContentPath(List<String> contentPath) {
        this.contentPath = contentPath;
    }

    public List<String> getContentCleanPath() {
        return contentCleanPath;
    }

    public void setContentCleanPath(List<String> contentCleanPath) {
        this.contentCleanPath = contentCleanPath;
    }

    public List<String> getTagsPath() {
        return tagsPath;
    }

    public void setTagsPath(List<String> tagsPath) {
        this.tagsPath = tagsPath;
    }

    public void setNotFoundArticleTitles(List<String> notFoundArticleTitles) {
        this.notFoundArticleTitles = notFoundArticleTitles;
    }

    public List<String> getNotFoundArticleTitles() {
        return notFoundArticleTitles;
    }
}
