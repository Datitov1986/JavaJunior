package org.example.lecture3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306/java_junior";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public static void con() {
        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)) {
            Statement statement = con.createStatement();
//            statement.execute("DROP SCHEMA 'test'");
//            statement.execute("CREATE SCHEMA 'test'");
            statement.execute("CREATE TABLE 'table' ('id' INT NOT NULL AUTOINCREMENT, " +
                    "'firstname' VARCHAR(45) NULL, " +
                    "'lastname' VARCHAR(45) NULL, " +
                    "PRIMARY KEY('id'));");
        }catch (SQLException e) {
            throw new RuntimeException();
        }

    }

}
