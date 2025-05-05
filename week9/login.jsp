<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Login Page</title>
  </head>
  <body>
    <h2>Login</h2>
    <form action="loginServlet" method="post">
      <label for="username">Username:</label>
      <input type="text" name="username" id="username" required />
      <br /><br />

      <label for="password">Password:</label>
      <input type="password" name="password" id="password" required />
      <br /><br />

      <input type="submit" value="login" />
    </form>

    <p style="color: red">${errorMessage}</p>
  </body>
</html>
