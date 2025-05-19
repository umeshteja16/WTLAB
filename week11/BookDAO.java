import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static void addBook(Book book) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();
    }

    public static Book getBook(int id) {
        Session session = factory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    public static void updateBook(Book book) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();
        session.close();
    }

    public static void deleteBook(Book book) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(book);
        tx.commit();
        session.close();
    }
}
