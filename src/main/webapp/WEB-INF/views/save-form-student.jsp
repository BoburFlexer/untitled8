<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/save/student" method="post">
    <label>firstName</label>
    <input type="text" name="firstName">
    <label>lastName</label>
    <input type="text" name="lastName">
    <label>email</label>
    <input type="text" name="email">
    <input type="submit" value="Register">
    <c:forEach items="${allStudent}" var="company">
    <div>
        <input type="radio" id="${company.id}" name="id" value="${company.id}">
        <label for="${company.id}">${company.groupName}</label><br>
    </div>
    </c:forEach>
</form>

</body>
</html>
