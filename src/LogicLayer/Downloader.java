package LogicLayer;

import Containers.Article;

public class Downloader extends Thread {
private String siteName;
private Rules siteRules;
private int startingIndex;
private int jump;
    public Downloader(String siteName, Rules siteRules,int startingIndex,int jump) {
        this.siteName = siteName;
        this.siteRules = siteRules;
        this.startingIndex=startingIndex;
        this.jump=jump;
    }


    @Override
    public void run() {
        ArticleBuilder articleBuilder=new ArticleBuilder();
        String ID="";
        for (int i = startingIndex; i < 1101303845; i+=jump) {

            ID = "" + i;
            articleBuilder.downloadArticle("Globes", siteRules, ID);

        }
    }
}
