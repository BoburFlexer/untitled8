<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Фарход
  Date: 05.10.2023
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save/groups" method="post">
    <label>groupName</label>
    <input type="text" name="groupName">
    <label>dateOfStart</label>
    <input type="text" name="dateOfStart">
    <label>dateOfFinish</label>
    <input type="text" name="dateOfFinish">
    <input type="submit" value="Register">
    <c:forEach items="${allCompany}" var="company">
        <div>
            <input type="radio" id="${company.id}" name="id" value="${company.id}">
            <label for="${company.id}">${company.companyName}</label><br>
        </div>
    </c:forEach>
    <c:forEach items="${allCourse}" var="company">
        <div>
            <input type="radio" id="${company.id}" name="course_id" value="${company.id}">
            <label for="${company.id}">${company.courseName}</label><br>
        </div>
    </c:forEach>
</form>
</body>
</html>
