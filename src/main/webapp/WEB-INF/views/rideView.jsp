<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/views/includes.jsp"%>

<script>
	(function() {
		'use strict';

		var center_lat = 43.0758, center_long = -77.6647, src_lat = '<c:out value="${sourceLocation.getLatitude()}"/>', src_long = '<c:out value="${sourceLocation.getLongitude()}"/>', dest_lat = '<c:out value="${destinationLocation.getLatitude()}"/>', dest_long = '<c:out value="${destinationLocation.getLongitude()}"/>';

		function showImmutableMap(center_lat, center_long) {
			var mapOptions = {
				center : new google.maps.LatLng(center_lat, center_long),
				zoom : 10,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			}, map = new google.maps.Map(document.getElementById("map"),
					mapOptions);

			var srcPosition = new google.maps.LatLng(src_lat, src_long);
			var srcMarker = new google.maps.Marker({
				position : srcPosition,
				map : map,
				title : "Origin"
			});

			var destPosition = new google.maps.LatLng(dest_lat, dest_long);
			var destMarker = new google.maps.Marker({
				position : destPosition,
				map : map,
				title : "Destination"
			});
		}

		google.maps.event.addDomListener(window, 'load', function() {
			showImmutableMap(center_lat, center_long);
		});
	}());
</script>

<style>
div.inline {
	float: left;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ride</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>
<body>
	<div class="container">
		<h1>${rideEntry.getName()}
			<span style="float: right;"> <c:if test="${rideRelation == 0}">
					<c:choose>
						<c:when test="${userType != 3}">
							<button class="btn btn-primary"
								onclick="location.href='/coolname/ride/${rideEntryID}/join'">Join
								Ride</button>
						</c:when>
						<c:otherwise>
							<c:if test="${driverName == 'No driver'}">
								<div class="btn-group">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										Join as Driver <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">${vehicles}
									</ul>
								</div>
							</c:if>
							<button class="btn btn-primary"
								onclick="location.href='/coolname/ride/${rideEntryID}/join'">Join
								as Passenger</button>
						</c:otherwise>
					</c:choose>
				</c:if> <c:if test="${rideRelation == 1}">
					<span>
						<button class="btn btn-primary"
							onclick="location.href='/coolname/ride/${rideEntryID}/edit'">Edit
							Ride</button>
						<button class="btn btn-primary"
							onclick="location.href='/coolname/ride/${rideEntryID}/delete'">Delete
							Ride</button>
					</span>
				</c:if> <c:if test="${rideRelation == 2}">
					<button class="btn btn-primary"
						onclick="location.href='/coolname/ride/${rideEntryID}/leave'">Leave
						Ride</button>
				</c:if>
			</span>
		</h1>
		<h2>
			<c:if test="${roundTripEnd > 0}">
					Round Trip - Start
					<span style="float: right;">
					<button class="btn btn-primary"
						onclick="location.href='/coolname/ride/${roundTripEnd}/view'">End</button>
				</span>
			</c:if>
			<c:if test="${roundTripStart > 0}">
					Round Trip - End
					<span style="float: right;">
					<button class="btn btn-primary"
						onclick="location.href='/coolname/ride/${roundTripStart}/view'">Start</button>
				</span>
			</c:if>
		</h2>
		<div>
			<div id="map" style="height: 310px; width: 100%; float: center;"></div>
			<span>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Driver Name:</th>
							<td>${driverName}</td>
						</tr>
						<tr>
							<th>Status</th>
							<td>${rideEntry.getStatus()}</td>
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
	</div>
</body>
</html>