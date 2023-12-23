package org.example.homework4.task2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName("Book" + i);
            book.setAuthor("Author" + i);
            session.save(book);
        }
        tx.commit();

        Query query = session.createQuery("FROM book WHERE author =:authorName");
        query.setParameter("authorName", "Author 5");
        List<Book> books = query.getResultList();
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Name: " + book.getName() + ", Author: " + book.getAuthor());
        }

        session.close();
        sessionFactory.close();
    }
}
