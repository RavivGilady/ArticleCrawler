package Articles;

import java.util.List;

public class Rules {
    private String prefix;
    private String suffix;
    private List<String> contentPath;
    private  List<String> authorPath;
    private List<String> titlePath;
    private  List<String> publishingDatePath;
    private List<String> categoryPath;
    private  List<String> tagsPath;

    public Rules(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }


    public void setRules(List<String> contentPath, List<String> authorPath, List<String> titlePath, List<String> publishingDatePath, List<String> categoryPath, List<String> tagsPath) {
        this.contentPath=contentPath;
        this.authorPath=authorPath;
        this.titlePath=titlePath;
        this.publishingDatePath=publishingDatePath;
        this.categoryPath=categoryPath;
        this.tagsPath=tagsPath;
    }
}
