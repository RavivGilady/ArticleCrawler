import Articles.PublishingSite;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class examination {
    public static void main(String[] args) {

        PublishingSite globes;
        globes =new PublishingSite("https://www.globes.co.il/","Globes","https://www.globes.co.il/news/article.aspx?did=","");
        globes.createArticle("100002320");

        List<String> tree=new LinkedList<>();
        tree.add("div");
    }
}
