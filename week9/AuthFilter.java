package week9;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
@WebFilter("/home.jsp") // Protect home.jsp with this filter
public class AuthFilter implements Filter {
 public void init(FilterConfig fConfig) throws ServletException {
 }
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
 throws IOException, ServletException {
 HttpServletRequest req = (HttpServletRequest) request;
 HttpServletResponse resp = (HttpServletResponse) response;
 // Check if the user is logged in
 HttpSession session = req.getSession(false);
 if (session == null || session.getAttribute("username") == null) {
 // Redirect to login page if not logged in
 resp.sendRedirect("Login.jsp");
 } else {
 // Allow the request to proceed to home.jsp
 chain.doFilter(request, response);
 }
 }
 public void destroy() {
 }
}
