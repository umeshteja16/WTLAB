//javaresources->sr/main/java->create a servelt like click on it then create Book.java file using class created the write the code
// insert in lb mysql connector plus jar file.
//jakarta.servlet-api-5.0.0.jar
//mysql-connector-j-9.3.0.jar

package manasa;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class Bookservlet
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC connection variables
    String jdbcURL = "jdbc:mysql://localhost:3306/book1";
    String jdbcUsername = "root";
    String jdbcPassword = "";

    public Book() {
        super();
    }

    /**
     * Handles HTTP GET requests
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(jdbcURL, "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");

            // HTML output
            out.println("<html><body>");
            out.println("<h2>Book List</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th></tr>");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                        rs.getString("title") + "</td><td>" +
                        rs.getString("author") + "</td><td>" +
                        rs.getDouble("price") + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
            e.printStackTrace(out);
        }
    }

    /**
     * Handles HTTP POST requests
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

