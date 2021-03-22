<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Hall</title>
</head>
<body>
    <div align="center">
        <h2>New Hall</h2>
        <form:form action="/TicketSystem/saveHall" method="post" modelAttribute="hall">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Hall Name: </td>
                    <td><form:input path="hallName" /></td>
                </tr>
                <tr>
                    <td>Number of Seats: </td>
                    <td><form:input path="numberOfSeats" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save"></td>
                    <td><input type="submit" name="cancel" value="Cancel"/></td>
                </tr>                    
            </table>
        </form:form>
    </div>
</body>
</html>