<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Регистрация пользователя</title>
</head>

<body>
    <h1 align="center">Регистрация пользователя</h1>

    <form action="${basePath}/api/user" method="post">
        <label for="names">Имя:</label>
        <input type="text" id="names" name="names"><br><br>

        <label for="birth">Дата рождения:</label>
        <input type="date" id="birth" name="birth"><br><br>

        <label for="login">Login:</label>
        <input type="text" id="login" name="login"><br><br>

        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password"><br><br>

        <input type="submit" value="Зарегистрироваться">
    </form>
</body>

</html>