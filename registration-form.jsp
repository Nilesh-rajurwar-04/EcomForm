<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h2>Registration Form</h2>

    <%
        String error = "";
        if(request.getMethod().equalsIgnoreCase("POST")) {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");

            if(name == null || name.trim().equals("")) {
                error = "Name is required!";
            } else if(email == null || email.trim().equals("")) {
                error = "Email is required!";
            } else if(password == null || password.length() < 6) {
                error = "Password must be at least 6 characters!";
            } else if(phone == null || phone.length() < 10 || phone.length() > 10) {
              error = "Phone number must be 10 digits!";
              try {
                Integer.parseInt(phone);
              } catch (Exception e) {
                error = "Phone number cannot have alphabets!";
              }
            } else {
              session.setAttribute("email", email);
              session.setAttribute("password", password);

                response.sendRedirect("login-form.jsp");
            }
        }
    %>

    <p class="error"><%= error %></p>

    <form method="post" action="registration-form.jsp">
        <label>Name:</label>
        <input type="text" name="name">

        <label>Email:</label>
        <input type="email" name="email">

        <label>Phone:</label>
        <input type="text" name="phone">

        <label>Password:</label>
        <input type="password" name="password">

        <button type="submit">Register</button>
    </form>
</div>

</body>
</html>
