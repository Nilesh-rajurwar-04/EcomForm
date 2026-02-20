<%@ page import="javax.servlet.http.*, java.util.*" %>
<%
    String inputUsername = request.getParameter("username");
    String inputPassword = request.getParameter("password");

    String savedUsername = null;
    String savedPassword = null;

    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie c : cookies){
            if("username".equals(c.getName())) savedUsername = c.getValue();
            if("password".equals(c.getName())) savedPassword = c.getValue();
        }
    }

    if(savedUsername == null || savedPassword == null 
       || !savedUsername.equals(inputUsername) || !savedPassword.equals(inputPassword)) {
        response.sendRedirect("login-form.jsp?error=1");
        return;
    }

    String loginTime = new Date().toString();
%>

<html>
<head>
    <title>Login Success</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Welcome, <%= savedUsername %></h2>

<p>Username from cookie: <%= savedUsername %></p>
<p>Login Time: <%= loginTime %></p>

<a href="login-form.jsp">Logout</a>
</body>
</html>