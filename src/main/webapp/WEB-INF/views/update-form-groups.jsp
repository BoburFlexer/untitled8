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
<form action="/update/groups/${updateGroups.id}" method="post">
    <label>dateOfStart</label>
    <input type="text" name="dateOfStart" value="${updateGroups.dateOfStart}">
    <label>dateOfFinish</label>
    <input type="text" name="dateOfFinish" value="${updateGroups.dateOfFinish}">
    <label>groupsName</label>
    <input type="text" name="groupName" value="${updateGroups.groupName}">
    <input type="submit" value="Update">
</form>
</body>
</html>