<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<head>
    <meta charset="UTF-8">
    <title>Sign In</title>
</head>

<body>
    <h2>Отправка сообщения</h2>
    <form action="../../api/message" method="post">
        <label for="login">Логин получателя:</label>
        <input type="text" id="login" name="login"><br><br>

        <label for="text">Текст сообщения:</label>
        <input type="text" id="text" name="text"><br><br>

        <input type="submit" value="Отправить сообщение">
    </form>
</body>

</html