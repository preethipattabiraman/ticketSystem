<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Movies</title>
</head>
<body>
<div align="center">
    <h2>All Movies</h2>
    <h3><a href="/TicketSystem/newMovie">New Movie</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Language</th>
        </tr>
        <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.movieName}</td>
            <td>${movie.language}</td>
            <td>
                <a href="/TicketSystem/editMovie?id=${movie.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/TicketSystem/deleteMovie?id=${movie.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>   
</body>
</html>