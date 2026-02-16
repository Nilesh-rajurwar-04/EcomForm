<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h2>Login Successful</h2>

    <%
        String email = (String) session.getAttribute("email");
        String loginTime = (String) session.getAttribute("loginTime");
    %>

    <p>Welcome, <strong><%= email %></strong></p>
    <p>You logged in at: <strong><%= loginTime %></strong></p>

</div>

</body>
</html>
