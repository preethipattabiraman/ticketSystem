<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Ticket</title>
</head>
<body>
<div align="center">
    <h2>Book Ticket</h2>
    <form:form action="/TicketSystem/getScreenings" modelAttribute="ticket" id="bookTicket" method="post">
    	<br/><br/>
    	<label>Choose a movie</label>
	    <select name="movieId">
	    	<option value="Choose">--Choose a movie--</option>
		    <c:forEach items="${movies}" var="movie">
		        <option value="${movie.id}">${movie.movieName}</option>
		    </c:forEach>
		</select>
		<input type="submit" value="Get Screenings"/>
    </form:form>
</div>   
</body>
</html>