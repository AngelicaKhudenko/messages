<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<head>
    <meta charset="UTF-8">
    <title>Sign In</title>
</head>

<body>
    <h2>Sign In</h2>
    <form action="../api/login" method="post">
        <label for="login">Login:</label>
        <input type="text" id="login" name="login"><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>

        <input type="submit" value="Log In">
    </form>
</body>

</html