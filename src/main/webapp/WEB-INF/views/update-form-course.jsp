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
<form action="/update/course/${updateCourse.id}" method="post">
    <label>courseName</label>
    <input type="text" name="courseName" value="${updateCourse.courseName}">
    <label>duration</label>
    <input type="text" name="duration" value="${updateCourse.duration}">
    <input type="submit" value="Update">
</form>
</body>
</html>
