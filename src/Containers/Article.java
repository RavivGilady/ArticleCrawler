package Containers;

import LogicLayer.Rules;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Article {

    private List<String> author;
    private List<String> category;
    private String OnSiteID;
    private UUID OnDataBaseID;
    private List<String> title;
    private List<String> publishingDate;
    private String siteName;
    private String content;

    public Article(String onSiteID,String siteName) {
        author = new LinkedList<>();
        category = new LinkedList<>();
        this.OnSiteID=onSiteID;
        OnDataBaseID=UUID.randomUUID();
        title = new LinkedList<>();
        publishingDate = new LinkedList<>();
        this.siteName = siteName;
        tags = new LinkedList<>();

    }


    @Override
    public String toString() {
        return "Article{" +
                "author=" + author +
                ", category=" + category +
                ", OnSiteID='" + OnSiteID + '\'' +
                ", OnDataBaseID=" + OnDataBaseID +
                ", title=" + title +
                ", publishingDate=" + publishingDate +
                ", siteName='" + siteName + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                '}';
    }

    private List<String> tags;



    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        if(tags!=null)
            this.tags = tags;
    }

    public void setAuthor(List<String> author) {
        if (author!=null)
            this.author = author;
    }

    public void setCategory(List<String> category) {
        if(category!=null)
        this.category = category;
    }

    public void setOnSiteID(String onSiteID) {
        OnSiteID = onSiteID;
    }

    public void setOnDataBaseID(UUID onDataBaseID) {
        OnDataBaseID = onDataBaseID;
    }

    public void setTitle(List<String> title) {
        if(title!=null)
            this.title = title;
    }

    public void setPublishingDate(List<String> publishingDate) {
        if(publishingDate!=null)
            this.publishingDate = publishingDate;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public List<String> getAuthor() {
        return author;
    }

    public List<String> getCategory() {
        return category;
    }

    public String getOnSiteID() {
        return OnSiteID;
    }

    public UUID getOnDataBaseID() {
        return OnDataBaseID;
    }

    public List<String> getTitle() {
        return title;
    }

    public List<String> getPublishingDate() {
        return publishingDate;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
