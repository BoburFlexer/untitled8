<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/save/teacher" method="post">
    <label>email</label>
    <input type="text" name="email">
    <label>firstName</label>
    <input type="text" name="firstName">
    <label>lastName</label>
    <input type="text" name="lastName">
    <input type="submit" value="Register">

    <c:forEach items="${all}" var="course">
        <div>
            <input type="radio" id="${course.id}" name="id" value="${course.id}">
            <label for="${course.id}">${course.courseName}</label><br>
        </div>
    </c:forEach>
</form>
</body>
</html>
