package tests;

import LogicLayer.PublishingSite;

import java.util.LinkedList;
import java.util.List;

public class PublishingSiteTest {
    private PublishingSite globes;
    @org.junit.Before
    public void setUp() throws Exception {
        List<String> tree=new LinkedList<>();
        tree.add("div");
        globes =new PublishingSite("https://www.globes.co.il/","Globes","https://www.globes.co.il/news/article.aspx?did=","");
    }

    @org.junit.Test
        public void createArticle() {
    }
}