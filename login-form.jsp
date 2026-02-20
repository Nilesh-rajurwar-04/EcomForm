<%@ page import="javax.servlet.http.*, java.util.*" %>
<%
    String regUsername = request.getParameter("username");
    String regPassword = request.getParameter("password");


    if(regUsername != null && regPassword != null){
        Cookie userCookie = new Cookie("username", regUsername);
        Cookie passCookie = new Cookie("password", regPassword);
        userCookie.setMaxAge(60*30);
        passCookie.setMaxAge(60*30);
        response.addCookie(userCookie);
        response.addCookie(passCookie);
    }

    String message = "";
    if(request.getParameter("error") != null){
        message = "Invalid username or password!";
    }
%>

<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Login</h2>
<p style="color:red;"><%= message %></p>
<form action="login-success.jsp" method="post">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>
</body>
</html>