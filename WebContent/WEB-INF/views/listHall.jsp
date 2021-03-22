<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Halls</title>
</head>
<body>
<div align="center">
    <h2>All Halls</h2>
    <h3><a href="/TicketSystem/newHall">New Hall</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Total Seats</th>
        </tr>
        <c:forEach items="${halls}" var="hall">
        <tr>
            <td>${hall.id}</td>
            <td>${hall.hallName}</td>
            <td>${hall.numberOfSeats}</td>
            <td>
                <a href="/TicketSystem/editHall?id=${hall.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/TicketSystem/deleteHall?id=${hall.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>   
</body>
</html>