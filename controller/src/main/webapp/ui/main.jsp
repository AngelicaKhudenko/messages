<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>

<body>
    <h1 align="center">Меню приложения</h1>

    <form action="${basePath}/ui/signUp" method="get">
        <button type="submit">Зарегистрироваться</button>
    </form>
    <br>

    <form action="${basePath}/ui/signIn" method="get">
        <button type="submit">Войти в приложение</button>
    </form>
    <br>

    <form action="${basePath}/ui/user/message" method="get">
        <button type="submit">Написать сообщение</button>
    </form>
    <br>

    <form action="${basePath}/ui/user/chats" method="get">
        <button type="submit">Мои сообщения</button>
    </form>
    <br>

    <form action="${basePath}/ui/admin/statistics" method="get">
    <button type="submit">Статистика</button>
    </form>
</body>

</html>