<%--
  Created by IntelliJ IDEA.
  User: Jhanvi K
  Date: 05-Jul-22
  Time: 2:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
    <h3>Hi <%= request.getAttribute("user")%>, Login Successful.</h3>
    <a href="login.html">Login Page</a>
</body>
</html>
