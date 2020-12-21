<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/personalStyle.css">
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
        <a href="${pageContext.request.contextPath}/tickets">Купить билеты</a>
        <a href="">Купить абонемент</a>
        <a href="">О нас</a>
        <div class="name clickable" id="showExitModal">${user.email}</div>
        <div class="name">${user.name}</div>
    </div>

    <div class="exitModal" id="exitModal">
        <div class="exit">
            <div class="modalAction clickable" id="edit">Изменить данные</div>
            <div class="modalAction clickable" id="exit">Выйти из аккаунта</div>
        </div>
    </div>

    <div class="editModal" id="editModal">
        <div class="edit">
            <form method="post" action="personal/edit">
                <p class="general">Имя</p>
                <div class="in">
                    <input name="name" value="${user.name}">
                </div>
                <p class="general">E-MAIL</p>
                <div class="in">
                    <input name="email" type="email" value="${user.email}">
                </div>
                <p class="general">Пароль</p>
                <div class="in">
                    <input name="password" type="password">
                </div>
                <div class="okButton">
                    <button type="submit" class="ok">OK</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        let button = document.getElementById("showExitModal");
        let exitModal = document.getElementById("exitModal");
        let enabled = false
        button.onclick = function() {
            if (!enabled) {
                exitModal.style.visibility = "visible";
                exitModal.style.opacity = "1";
            } else {
                exitModal.style.visibility = "hidden";
                exitModal.style.opacity = "0";
            }
            enabled = !enabled;
        }

        let exit = document.getElementById("exit");
        exit.onclick = function() {
            window.location.href = "/tickets";
        }

        button = document.getElementById("edit");
        let editModal = document.getElementById("editModal");
        button.onclick = function() {
            editModal.style.display = "flex";
            exitModal.style.visibility = "hidden";
            exitModal.style.opacity = "0";
        }
    </script>

    <div class="main">
        <div class="tickets">
            <p class="general" style="padding-left: 18px;">Билеты</p>
            <div class="handler">
                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                            <tr>
                                <th>Матч</th>
                                <th>Время</th>
                                <th>Цена</th>
                                <th></th>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <c:forEach items="${userTickets}" var="userTicket">
                                <jsp:useBean id="userTicket" type="org.v_cognitio.tickets.model.UserTicket"/>
                                <tr>
                                    <td><%=userTicket.getTicket().getDescription()%></td>
                                    <td><%=userTicket.getTicket().getDateTime()%></td>
                                    <td><%=userTicket.getCost()%></td>
                                    <td class="link">
                                        <a href="personal/return?ticketId=<%=userTicket.getId()%>">Вернуть</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="person">
            <p class="general">Имя</p>
            <p class="sub">${user.name}</p>
            <p class="general">E-MAIL</p>
            <p class="sub">${user.email}</p>
            <p class="general">Абонемент</p>
            <p class="sub">${user.subscription.description}, скидка ${user.subscription.discount}%</p>
            <p class="general">Истекает</p>
            <p class="sub">${user.subscriptionExpire}</p>
        </div>
    </div>
</body>
</html>
