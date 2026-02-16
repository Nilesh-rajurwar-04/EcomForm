<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h2>Login Form</h2>

    <%
        String error = "";
        if(request.getMethod().equalsIgnoreCase("POST")) {

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String loginTime = request.getParameter("login-time");

            if(email == null || email.trim().equals("")) {
                error = "Email is required!";
            } else if(password == null || password.length() < 6) {
                error = "Password must be at least 6 characters!";
            } else {
              String sessionEmail = (String) session.getAttribute("email");
              String sessionPassword = (String) session.getAttribute("password");

              if(!sessionEmail.equals(email)) error = "Invalid username!";
              if(!sessionPassword.equals(password)) error = "Invalid password!";

              else {
                  session.setAttribute("loginTime", loginTime);
                  response.sendRedirect("login-success.jsp");
              }
            }
        }
    %>

    <p class="error"><%= error %></p>

    <form method="post" action="login-success.jsp">
        <label>Email:</label>
        <input type="email" name="email">

        <label>Password:</label>
        <input type="password" name="password">

        <input type="hidden" name="login-time" value=<% java.time.LocalDateTime.now();%> >

        <button type="submit">Login</button>
    </form>
</div>

</body>
</html>
