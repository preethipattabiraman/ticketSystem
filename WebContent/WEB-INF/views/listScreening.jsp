<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Listings</title>
</head>
<body>
<div align="center">
    <h2>All Movies</h2>
    <h3><a href="/TicketSystem/newScreening">New Screening</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Movie Name</th>
            <th>Hall Name</th>
            <th>Timings</th>
        </tr>
        <c:forEach items="${screenings}" var="screening">
        <tr>
            <td>${screening.id}</td>
            <td>${screening.movieName}</td>
            <td>${screening.hallName}</td>
            <td>${screening.startingTime }</td>
            <td>
                <a href="/TicketSystem/editScreening?id=${screening.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/TicketSystem/deleteScreening?id=${screening.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>   
</body>
</html>