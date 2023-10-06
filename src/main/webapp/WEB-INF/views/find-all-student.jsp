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
<table>
<th>id</th>
<th>firstName</th>
<th>lastName</th>
<th>email</th>
<th>update</th>
<th>delete</th>
<c:forEach items="${findAllGroups}" var="course">
    <tr>
        <td>
            <a href="/find/student/by/${course.id}">
                    ${course.id}
            </a>
        </td>
        <td>${course.firstName}</td>
        <td>${course.lastName}</td>
        <td>${course.email}</td>
        <td>
            <a href="/update/student/form/${course.id}">
                UPDATE
            </a>
        </td>
        <td>
            <a href="/delete/student/${course.id}">
                DELETE
            </a>
        </td>
    </tr>
</c:forEach>

</table>
<a href="/save/student/form">register</a>
<style>
    /* Стиль для всей таблицы */
    table {
        width: 100%;
        border-collapse: collapse; /* Объединение границ ячеек */
        margin-bottom: 20px;
    }

    /* Стиль для заголовка таблицы (шапки) */
    th {
        background-color: #333;
        color: #fff;
        text-align: left;
        padding: 10px;
    }

    /* Стиль для ячеек с данными */
    td {
        border: 1px solid #ddd;
        padding: 8px;
    }

    /* Стиль для четных строк в таблице */
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    /* Стиль для наведения курсора на строку таблицы */
    tr:hover {
        background-color: #ddd;
    }

    tr {

        font-family: "XO Caliburn";
    }
</style>
</body>
</html>
