<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Вход в приложение</title>
</head>

<body>
    <h1 align="center">Вход в приложение</h1>

    <form action="${basePath}/api/login" method="post">
        <label for="login">Login:</label>
        <input type="text" id="login" name="login"><br><br>

        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password"><br><br>

        <input type="submit" value="Войти в приложение">
    </form>
</body>

</html>