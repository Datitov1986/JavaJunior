package org.example.homework4.task1;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        //Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void createTable() throws SQLException {

        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        String sql = "CREATE TABLE book" +
                "(id BIGINT AUTO_INCREMENT," +
                "name VARCHAR(255)," +
                "author VARCHAR(255)," +
                "PRIMARY KEY (id))";

        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPass)) {
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Table 'book' created successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBook(Book book) {
        String insert = "INSERT INTO " + Constants.BOOK_TABLE + "(" +
                Constants.BOOK_NAME + "," + Constants.AUTHOR_NAME + ")" +
                "VALUES(?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,book.getName());
            prSt.setString(2,book.getAuthor());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getBook(String authorName) {
        ResultSet resSet = null;


        String select = "SELECT * FROM " + Constants.BOOK_TABLE + " WHERE " +
                Constants.AUTHOR_NAME + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
//            prSt.setString(1, book.getName());
            prSt.setString(1, authorName);

            resSet = prSt.executeQuery();
            while (resSet.next()) {
                int id = resSet.getInt("id");
                String name = resSet.getString("name");
                String author = resSet.getString("author");
                System.out.println("ID: " + id + ", Name: " + name + ", Author: " + author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
