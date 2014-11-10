<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<head>
<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
	
</script>

<script>
	function initialize() {
		var mapProp = {
			center : new google.maps.LatLng(43.0758, -77.6647),
			zoom : 10,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map"), mapProp);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>

<style>
	div.inline{float:left;}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ride</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>
<body>
	<button class="btn btn-default" onclick="location.href='/coolname/ride/${rideEntryID}/join'">Join Ride</button>
	<div class="inline">
	<table class="table">
		<thead>
			<tr>
				<th>Driver Name:</th>
				<td>${driver.getFirstName()}${driver.getLastName()}</td>
			</tr>
			<tr>
				<th>Destination:</th>
				<td>${rideEntry.getDestination()}</td>
			</tr>
			<tr>
				<th>Origin:</th>
				<td>${rideEntry.getSource()}</td>
			</tr>
			<tr>
				<th>Departure time:</th>
				<td></td>
			</tr>
			<tr>
				<th>Available Seats:</th>
				<td>${rideEntry.getNumSeats()}</td>
			</tr>
			<tr>
				<th>Car Model:</th>
				<td>${vehicleModel}</td>
			</tr>
		</thead>
	</table>
	<div id="map" style="height: 325px; width: 450px;"></div>
	</div>
</body>
</html>