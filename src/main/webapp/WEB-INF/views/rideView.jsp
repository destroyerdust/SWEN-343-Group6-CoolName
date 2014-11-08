<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ride</title>
<%@ include file="/WEB-INF/views/header.jsp" %>
</head>
<body>
	<div></div>
	<div>
		Driver Name: <bdi id="driver-name">${rideEntry.getVehicle().getUser().getName()}</bdi><br>
		Destination: <bdi id="destination">${rideEntry.getDestination()}</bdi><br>
		Origin: <bdi id="origin">${rideEntry.getSource()}</bdi><br>
		Departure time: <time id="departure-time"><br>
		Available Seats: <bdi id="avail-seats">${rideEntry.getVehicle().getNumSeats()}</bdi><br>
		Car Model: <bdi id="car-model">${rideEntry.getVehicle().getModel()}<br>
	</div>
</body>
</html>