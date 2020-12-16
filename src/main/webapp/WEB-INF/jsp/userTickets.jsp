<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>User Tickets</title>
    </head>
    <body>
        <h1>Купленые билеты:</h1>
        <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Описание</th>
                <th>Дата</th>
                <th>Цена</th>
            </tr>
        </thead>
            <c:forEach items="${userTickets}" var="userTicket">
                <jsp:useBean id="userTicket" type="org.v_cognitio.tickets.model.UserTicket"/>
                <tr>
                    <td><%=userTicket.getTicket().getDescription()%></td>
                    <td><%=userTicket.getTicket().getDateTime()%></td>
                    <td><%=userTicket.getCost()%></td>
                </tr>
            </c:forEach>
        </table>

        <h1>Доступные билеты:</h1>
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
            <tr>
                <th>Описание</th>
                <th>Дата</th>
                <th>Цена</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${tickets}" var="ticket">
                <jsp:useBean id="ticket" type="org.v_cognitio.tickets.model.Ticket"/>
                <tr>
                    <td><%=ticket.getDescription()%></td>
                    <td><%=ticket.getDateTime()%></td>
                    <td><%=ticket.getPrice()%></td>
                    <td><a href="userTickets/buy?ticketId=<%=ticket.getId()%>">Купить</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
