public class Main {
    public static void main(String[] args) {
        Book book = new Book(1, "Java Basics", "John Doe", 499.99);

        BookDAO.addBook(book);

        Book fetched = BookDAO.getBook(1);
        System.out.println("Fetched Book: " + fetched.getTitle());

        fetched.setPrice(599.99);
        BookDAO.updateBook(fetched);

        BookDAO.deleteBook(fetched);
    }
}
