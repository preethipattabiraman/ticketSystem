<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Movie</title>
</head>
<body>
    <div align="center">
    	<h2>Edit Movie</h2>
    	<form:form action="/TicketSystem/saveMovie" method="post" modelAttribute="movie">
    		<table>
    			<tr>
    				<td>ID</td>
    				<td>${movie.id}
    					<form:hidden path="id"/>
    				</td>
    			</tr>
    			<tr>
    				<td>Movie Name</td>
    				<td>
    					<form:input path="movieName"/>
    				</td>
    			</tr>
    			<tr>
    				<td>Language</td>
    				<td>
    					<form:input path="language"/>
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