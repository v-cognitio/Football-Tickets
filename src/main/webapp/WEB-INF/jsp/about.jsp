<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>О нас</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commons/navbar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/aboutStyle.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commons/table.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background: url("${pageContext.request.contextPath}/resources/img/personal.jpg") no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="${pageContext.request.contextPath}/personal">Личный кабинет</a>
        <a href="${pageContext.request.contextPath}/shop?active=tickets">Купить билеты</a>
        <a href="${pageContext.request.contextPath}/shop?active=subs">Купить абонемент</a>
        <div class="name" id="showExitModal">${user.email}</div>
        <div class="name">${user.name}</div>
    </div>

    <div class="main">
        <div class="rubric">
            <h1>О проекте</h1>
            <p>
                Этот небольшой проект представляет собой симуляцию системы покупки билетов и абонементов
                на футбольные матчи. Хоть это и симуляция и данные тут вымышлены, операции с ними вполне реальны.
                Тут задействованы технологии, применяемые в разработке реальных Java приложений, хотя многие
                не столь значительные аспекты были так или иначе упрощены.
            </p>
        </div>

        <div class="rubric">
            <h1>Стек технологий</h1>
            <h2>Работа с данными</h2>
            <p>
                Данные хранятся в базе данных PostgreSQL.
                В качестве реализации репозиториев используется Spring Data JPA (Hibernate).
            </p>
            <h2>Работа с пользователем</h2>
            <p>
                Frontend обменивается данными с нижними слоями с помощью Spring MVC.
                Никакие JS-фреймворки не используются.
            </p>
        </div>

        <div class="rubric">
            <h1 style="text-align: center">Место, где я этому научился</h1>
            <div class="map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2258.375327009355!2d30.30836370025264!3d59.95688296333037!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x630ff799025ac60a!2z0KPQvdC40LLQtdGA0YHQuNGC0LXRgiDQmNCi0JzQng!5e0!3m2!1sru!2sru!4v1608661016517!5m2!1sru!2sru"
                    height="450" width="100%" frameborder="0"
                    style=" border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
            </div>
        </div>
    </div>

</body>
</html>
