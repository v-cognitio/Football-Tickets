<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Магазин</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commons/navbar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commons/table.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/shopStyle.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background: url("${pageContext.request.contextPath}/resources/img/personal.jpg") no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body onload="selectActive()">
    <script src="${pageContext.request.contextPath}/resources/js/shopTabController.js"></script>

    <div class="navbar">
        <a href="${pageContext.request.contextPath}/personal">Личный кабинет</a>
        <a href="">О нас</a>
        <span class="name">${user.email}</span>
        <span class="name">${user.name}</span>
    </div>

    <div class="main">
        <div class="tab">
            <button id="ticketsTab" class="tab" onclick="changeTab(event, 'tickets')">Билеты</button>
            <button id="subsTab" class="tab" onclick="changeTab(event, 'subs')">Абонементы</button>
        </div>
        <div class="tabContent" id="tickets">
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                        <tr>
                            <th>Матч</th>
                            <th>Дата и время</th>
                            <th>Цена, руб.</th>
                            <th></th>
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                    <c:forEach items="${tickets}" var="ticket">
                        <jsp:useBean id="ticket" type="org.v_cognitio.tickets.model.Ticket"/>
                        <tr>
                            <td><%=ticket.getDescription()%></td>
                            <td>${ticket.dateTime.toLocalDate()} ${ticket.dateTime.toLocalTime()}</td>
                            <td><%=ticket.getPrice()%></td>
                            <td class="link">
                                <a onclick="goToBuy('/buyTicket?ticketId=<%=ticket.getId()%>')">Купить</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="tabContent" id="subs">
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                    <tr>
                        <th>Наименование</th>
                        <th>Скидка</th>
                        <th></th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                    <c:forEach items="${subs}" var="sub">
                        <jsp:useBean id="sub" type="org.v_cognitio.tickets.model.Subscription"/>
                        <tr>
                            <td><%=sub.getDescription()%></td>
                            <td><%=sub.getDiscount()%>%</td>
                            <td class="link">
                                <a onclick="goToBuy('/buySub?subId=<%=sub.getId()%>')">Купить</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
