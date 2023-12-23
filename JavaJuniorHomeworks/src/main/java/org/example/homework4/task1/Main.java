package org.example.homework4.task1;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Book book0 = new Book("Увгений Онегин", "А.С. Пушкин");
        Book book1 = new Book("Война и мир", "Л.Н.Толстой");
        Book book2 = new Book("Преступление и наказание", "Ф.М.Достоевский");
        Book book3 = new Book("Идиот", "Ф.М.Достоевский");
        Book book4 = new Book("Гроза", "Н.А.Островский");
        Book book5 = new Book("Доходное место", "Н.А.Островский");
        Book book6 = new Book("Горе от ума", "А.С.Грибоедов");
        Book book7 = new Book("ОНО", "Стивен Кинг");
        Book book8 = new Book("Лангольеры", "Стивен Кинг");
        Book book9 = new Book("Кладбище домашних животных", "Стивен Кинг");
//        try {
//            dbHandler.createTable();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

//        dbHandler.addBook(book0);
//        dbHandler.addBook(book1);
//        dbHandler.addBook(book2);
//        dbHandler.addBook(book3);
//        dbHandler.addBook(book4);
//        dbHandler.addBook(book5);
//        dbHandler.addBook(book6);
//        dbHandler.addBook(book7);
//        dbHandler.addBook(book8);
//        dbHandler.addBook(book9);
        ResultSet result = dbHandler.getBook("Стивен Кинг");


    }
}
