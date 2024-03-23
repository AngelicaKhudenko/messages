<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Отправка сообщения</title>
</head>

<body>
    <h1 align="center">Отправка сообщения</h1>

    <form action="${basePath}/api/message" method="post">
        <label for="login">Логин получателя:</label>
        <input type="text" id="login" name="login"><br><br>

        <label for="text">Текст сообщения:</label>
        <input type="text" id="text" name="text"><br><br>

        <input type="submit" value="Отправить сообщение">
    </form>
</body>

</html