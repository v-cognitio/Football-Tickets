<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Купить билеты</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ticketsStyle.css">
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
        <a href="">Купить абонемент</a>
        <a href="">О нас</a>
        <span class="name">${user.email}</span>
        <span class="name">${user.name}</span>
    </div>

    <div class="main">
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
                <c:forEach items="${tickets}" var="ticket">
                    <jsp:useBean id="ticket" type="org.v_cognitio.tickets.model.Ticket"/>
                    <tr>
                        <td><%=ticket.getDescription()%></td>
                        <td><%=ticket.getDateTime()%></td>
                        <td><%=ticket.getPrice()%></td>
                        <td class="link"><a href="tickets/buy?ticketId=<%=ticket.getId()%>">Купить</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
