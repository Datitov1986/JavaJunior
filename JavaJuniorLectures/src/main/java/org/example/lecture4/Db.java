package org.example.lecture4;

import com.mysql.cj.jdbc.CallableStatement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db extends Configs {
    Connection connection;

    public static void con() throws SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort;
        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP SCHEMA test");
            statement.execute("CREATE SCHEMA test");
            statement.execute("CREATE TABLE test.testTable(id INT NOT NULL AUTO_INCREMENT, " +
                    "firstname VARCHAR(45) NULL, " +
                    "lastname VARCHAR(45) NULL, " +
                    "PRIMARY KEY(id))");
            statement.execute("INSERT INTO test.testTable (firstname, lastname)" + "VALUES ('Иванов', 'Иван')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void con2() throws SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort;
        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass)) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE test.magic(id INT NOT NULL AUTO_INCREMENT, " +
                    "название VARCHAR(45) NULL, " +
                    "повреждение INT NULL, " +
                    "атака INT NULL, " +
                    "броня INT NULL, " +
                    "PRIMARY KEY(id))");
            //statement.execute("INSERT INTO test.testTable (firstname, lastname)" + "VALUES ('Иванов', 'Иван')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void conHib() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Magic magic = new Magic("Волшебная стрела", "250", 15);
        session.beginTransaction();
        session.save(magic);
        session.getTransaction().commit();
        session.close();
    }
}
