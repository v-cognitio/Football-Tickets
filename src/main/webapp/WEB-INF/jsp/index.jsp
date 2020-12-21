<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tickets</title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:100" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/indexStyle.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commons/input.css">
        <style>
            body {
                background: url("${pageContext.request.contextPath}/resources/img/main.jpg") no-repeat;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <h1 class="title">Купите билеты на матч своей любимой команды прямо сейчас</h1>
        <div class="auth">
            <h2 class="sign">Sign In</h2>
            <div class="box">
                <form method="post" action="personal" class="basic">
                    <div class="in">
                        <input name="email" type="email">
                    </div>
                    <div class="in">
                        <input name="password" type="password">
                    </div>
                    <div class="okButton">
                        <button type="submit" class="ok">OK</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
