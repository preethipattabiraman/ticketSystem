<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Screening</title>
</head>
<body>
    <div align="center">
        <h2>New Screening</h2>
        <form:form action="/TicketSystem/saveScreening" method="post" modelAttribute="screening">
        <c:set var = "now" value="<%=new java.util.Date()%>" />
            <table border="0" cellpadding="5">
                <tr>
                    <td>Movie name : </td>
                    <td>
	                    <form:select path = "movieId">
	                   	 	<form:options items = "${movies}" itemValue="id" itemLabel="movieName"></form:options>
	                    </form:select>
                    </td>
                </tr>
                <tr>
                    <td>Hall name : </td>
                    <td>
                    	<form:select path = "hallId">
	                    	<form:options items = "${halls}" itemValue="id" itemLabel="hallName"></form:options>
	                    </form:select>
                    </td>
                </tr>
                <tr>
                	<td>Screening Time : </td>
                	<td>
                		<fmt:formatDate value="${now}" pattern="dd/MMM/yyyy hh:mm a" var="theFormattedDate" />
	                	<form:input type="text" path="startingTime" value="${theFormattedDate}"/>
                	</td>
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