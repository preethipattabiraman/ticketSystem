<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Hall</title>
</head>
<body>
    <div align="center">
    	<h2>Edit Hall</h2>
    	<form:form action="/TicketSystem/saveHall" method="post" modelAttribute="hall">
    		<table>
    			<tr>
    				<td>ID</td>
    				<td>${hall.id}
    					<form:hidden path="id"/>
    				</td>
    			</tr>
    			<tr>
    				<td>Hall Name</td>
    				<td>
    					<form:input path="hallName"/>
    				</td>
    			</tr>
    			<tr>
    				<td>Number Of Seats</td>
    				<td>
    					<form:input path="numberOfSeats"/>
    				</td>
    			</tr>
    			<tr>
    				<td><input type="submit" value="Save"/></td>
    				<td><input type="submit" name="cancel" value="Cancel"/></td>
    			</tr>
    		</table>
    	</form:form>
    </div>
</body>
</html>