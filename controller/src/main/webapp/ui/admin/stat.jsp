<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Статистика страницы</title>
</head>

<body>
    <h1 align="center">Статистика страницы</h1>

    <c:choose>
        <c:when test="${empty statistics}">
            <h2 align="center">Статистика пуста</h2>
        </c:when>

        <c:otherwise>
            <table border="1" align="center">
                <tr>
                    <td>Количество активных пользователей:</td>
                    <td>${statistics.activeUsers}</td>
                </tr>
                <tr>
                     <td>Количество зарегистрированных пользователей:</td>
                     <td>${statistics.users}</td>
                </tr>
                <tr>
                     <td>Количество отправленных сообщений:</td>
                     <td>${statistics.messages}</td>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
</body>

</html>