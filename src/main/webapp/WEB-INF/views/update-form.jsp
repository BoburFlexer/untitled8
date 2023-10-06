<%--
  Created by IntelliJ IDEA.
  User: Фарход
  Date: 03.10.2023
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update/${up.id}" method="post">
    <label>locatedCountry</label>
    <input type="text" name="locatedCountry" value="${up.locatedCountry}">
    <label>companyName</label>
    <input type="text" name="companyName" value="${up.companyName}">
    <input type="submit" value="Update">
</form>
</body>
</html>
