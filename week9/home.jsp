<!DOCTYPE html>
<html>
  <head>
    <title>Home Page</title>
  </head>
  <body>
    <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
    <p>This is a restricted page only accessible to authenticated users.</p>
    <a href="logout.jsp">Logout</a>
  </body>
</html>
