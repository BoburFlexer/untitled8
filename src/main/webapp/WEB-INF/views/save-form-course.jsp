<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Фарход
  Date: 05.10.2023
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save/course" method="post">
    <label>courseName</label>
    <input type="text" name="courseName">
    <label>duration</label>
    <input type="text" name="duration">
    <input type="submit" value="Register">
    <c:forEach items="${all}" var="company">
        <div>
            <input type="radio" id="${company.id}" name="id" value="${company.id}">
            <label for="${company.id}">${company.companyName}</label><br>
        </div>
    </c:forEach>
</form>
</body>
</html>
