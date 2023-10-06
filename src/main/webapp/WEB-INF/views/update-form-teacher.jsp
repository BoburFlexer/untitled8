<%--
  Created by IntelliJ IDEA.
  User: Фарход
  Date: 06.10.2023
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update/teacher/${teacher.id}" method="post">
    <label>firstName</label>
    <input type="text" name="firstName" value="${teacher.firstName}">
    <label>lastName</label>
    <input type="text" name="lastName" value="${teacher.lastName}">
    <label>email</label>
    <input type="text" name="email" value="${teacher.email}">
    <input type="submit" value="Update">
</form>
</body>
</html>