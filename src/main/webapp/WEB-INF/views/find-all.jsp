<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Фарход
  Date: 01.10.2023
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">

    <th>id</th>
    <th>companyName</th>
    <th>locatedCountry</th>
    <th>update</th>
    <th>delete</th>
    <c:forEach items="${c}" var="com">
        <tr>
            <td>
                <a href="/find/by/${com.id}">
                        ${com.id}
                </a>
            </td>
            <td>${com.companyName}</td>
            <td>${com.locatedCountry}</td>
            <td>
                <a href="/update/form/${com.id}">
                    UPDATE
                </a>
            </td>
            <td>
                <a href="/delete/${com.id}">
                    DELETE
                </a>
            </td>
        </tr>
    </c:forEach>

</table>
<a href="/save/form">register</a>
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