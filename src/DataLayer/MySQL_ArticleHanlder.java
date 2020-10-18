package DataLayer;

import Containers.Article;
import java.sql.*;
import java.util.List;
import java.util.UUID;

public class MySQL_ArticleHanlder implements ArticleHandler {
    private String articleTable="article";
    private String url="jdbc:mysql://127.0.0.1:3306/library?serverTimezone=UTC";
    private String userName="root";
    private String password="Qpf7hcDY5#Ec"; /* TODO: change it and hide it in config file
                                                https://stackoverflow.com/questions/2397822/what-is-the-best-practice-for-dealing-with-passwords-in-git-repositories
    */



    @Override
    public void saveArticle(String author, String categories, String onSiteID, String ID, String titles, String publishingDate,
                            String siteID, String content) {

        //  TODO: pull siteID
        String insertQuery="INSERT INTO " +articleTable +" (author,category,onSiteID, ID,publishingDate,siteID,title,content) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, userName, password);


            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, author);
            preparedStatement.setString(2, categories);
            preparedStatement.setString(3, onSiteID);
            preparedStatement.setString(4, ID);
            preparedStatement.setString(5, publishingDate);
            preparedStatement.setString(6, siteID);
            preparedStatement.setString(7,titles) ;
            preparedStatement.setString(8, content);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Article> loadArticles(List<String> Author, List<String> category, List<String> onSiteID, List<String> ID,
                                      List<String> title, List<String> publishingDate, List<String> siteName, List<String> content) {
        return null;
    }
}
