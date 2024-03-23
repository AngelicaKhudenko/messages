<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Ваши сообщения</title>
</head>

<body>
    <h1 align="center">Ваши сообщения</h1>

    <c:choose>
        <c:when test="${empty messages}">
            <h2 align="center">Сообщений нет</h2>
        </c:when>

        <c:otherwise>
            <table border="1" align="center">
                <tr>
                    <td>Дата и время отправки:</td>
                    <td>Отправитель:</td>
                    <td>Текст сообщения:</td>
                </tr>
                <c:forEach var="message" items="${messages}">
                    <tr>
                        <td>${message.post}</td>
                        <td>${message.sender}</td>
                        <td>${message.text}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>

</html>