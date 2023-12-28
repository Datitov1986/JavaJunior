package org.example.lesson4.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:database");
        prepareTables(connection);
        connection.close();


    }

    private static void prepareTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("""         
                create table users (
                    id bigint,
                    name varchar(255)
                )
                """);
        }
    }
}
