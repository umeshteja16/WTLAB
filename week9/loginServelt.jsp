package week9;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Get the username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded credentials (replace with DB logic in real applications)
        String correctUsername = "admin";
        String correctPassword = "password123";

        // Validate user credentials
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("home.jsp");
        } else {
            // Invalid login: set error message and forward back to login.jsp
            request.setAttribute("errorMessage", "Invalid credentials");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
