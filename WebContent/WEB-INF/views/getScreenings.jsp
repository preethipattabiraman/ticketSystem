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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	var screeningIds = ${screeningIds};
	var selectedSeats = ${selectedSeats};
	function displaySeating(select) {
		let screeningId = $(select).find(":selected").val();
		let ss = selectedSeats[screeningId].substring(1, selectedSeats[screeningId].length -1).replaceAll(' ','').split(',');
		for(let i = 0; ss < length ; i++) {
			ss[i] = ss[i].trim();
		}
		$("#checkbox").html("");
		for(let i = 0; i < 5 ; i++) {
			for(let j = 1; j <= 10 ; j++) {
				let row = "'" + String.fromCharCode(65 + i) + j + "'";
				let checkbox = $("<input type = 'checkbox' id = " + row + "/>");
				if(ss.includes(row)) {
					$(checkbox).get(0).setAttribute("disabled", "disabled");
					$(checkbox).get(0).setAttribute("style", "border: red");
				}
				$("#checkbox").append($(checkbox));
			}
		$("#checkbox").append($("<br/>"));
		}
	}
	
	function checkSeats() {
		let checkedBoxes = $('input:checkbox:checked');
		let checkboxes = $(checkedBoxes).length;
		let selectedSeats = "";
		if(checkboxes <= 6) { 
			console.log(checkedBoxes);
			for(let i = 0 ; i < checkboxes ; i++) {
				selectedSeats += $(checkedBoxes).get(i).id + ",";
			}
			selectedSeats = selectedSeats.substring(0, selectedSeats.length - 1);
			$("input[name='seatNumbers']").val(selectedSeats);
			return true;
		}
		else {
			alert("Select at most 6 seats");
			return false;
		}
	}
	
</script>
</head>
<body>
<div align="center">
    <h2>Book Ticket</h2>
    <form:form  modelAttribute="ticket" id="bookTicket" method="post" action='/TicketSystem/saveTicket' onsubmit="return checkSeats();">
    	<br/><br/>
    	<input type="hidden" name="customerId" value="${customerId}"/>
    	<label>Choose a movie</label>
	    <input type="text" value="${movie}" readonly = "readonly"/>
 		<input type="hidden" name="movieId" value="${movieId}"/>
		<br/><br/>
		<label>Choose a Screening</label>
		<form:select path="screeningId" onchange="displaySeating(this)">
			<form:option value="Choose">--Choose time--</form:option>
			<form:options id="screening" items="${screenings}" itemValue = "id" itemLabel = "startingTime"/>
		</form:select>
		<br/><br/>
		<div id="checkbox"></div>
		<input type="hidden" name="seatNumbers"/>
		<br/><br/>
		<button name="Save" id="saveTicket">Save</button>
		<input type="submit" name="cancel" value="Cancel"/>
    </form:form>
</div>   
</body>
</html>