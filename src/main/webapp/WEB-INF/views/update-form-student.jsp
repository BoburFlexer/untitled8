<%--
  Created by IntelliJ IDEA.
  User: Фарход
  Date: 05.10.2023
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update/student/${updateCourse.id}" method="post">
    <label>firstName</label>
    <input type="text" name="firstName" value="${updateCourse.firstName}">
    <label>lastName</label>
    <input type="text" name="lastName" value="${updateCourse.lastName}">
    <label>email</label>
    <input type="text" name="email" value="${updateCourse.email}">
    <input type="submit" value="Update">
</form>
</body>
</html>
