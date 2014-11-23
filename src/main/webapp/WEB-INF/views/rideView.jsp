<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ include file="/WEB-INF/views/includes.jsp"%>
	<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/RideViewMap.js" />"> </script>

<script>
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
	<h1>${rideEntry.getName()}
		<span style="float:right;"><button class="btn btn-primary" onclick="location.href='/coolname/ride/${rideEntryID}/join'">Join Ride</button></span>
	</h1>
	<div>
		<div  id="map" style="height: 310px; width: 100%;float:center;"></div>
		<span>
		<table class="table table-bordered">
		<thead>
			<tr>
				<th>Driver Name:</th>
				<td>${driverName}</td>
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
			<span>
		</table>
	</div>
</body>
</html>