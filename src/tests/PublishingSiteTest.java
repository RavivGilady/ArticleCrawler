package tests;

import Articles.PublishingSite;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

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