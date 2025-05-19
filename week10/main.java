package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Book book = new Book("Java Basics", "John Doe", 599.0);
        User user = new User("Hansini", "hansini@example.com");

        session.save(book);
        session.save(user);

        tx.commit();
        session.close();

        System.out.println("Inserted!");
    }
}

