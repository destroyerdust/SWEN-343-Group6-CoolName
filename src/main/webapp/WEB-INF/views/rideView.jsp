<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false"></script>
<!-- <script type="text/javascript" src="<c:url value="/resources/js/RideViewMap.js" />"></script> -->
	

<script>
(function () {
    'use strict';

    var center_lat = 43.0758,
        center_long = -77.6647,
        markers_json = [ {
            "title": "Marker Source",
            "latitude" : 43.0758,
            "longitude" : -77.6647
        }, {
            "title": "Marker Destination",
            "latitude" : 44.0758,
            "longitude" : -78.6647
        }];

    function showImmutableMap(center_lat, center_long) {
        var mapOptions = {
            center : new google.maps.LatLng(center_lat, center_long),
            zoom : 10,
            mapTypeId : google.maps.MapTypeId.ROADMAP
        },
            map = new google.maps.Map(document.getElementById("map"), mapOptions);
        var posA = new google.maps.LatLng(center_lat, center_long);
		var markerA = new google.maps.Marker({
			position : posA,
			map : map,
			title : "MarkerA"
		});
        
        var posB = new google.maps.LatLng(43.0858, center_long);
		var markerB = new google.maps.Marker({
			position : posB,
			map : map,
			title : "MarkerB"
		});
    }

    google.maps.event.addDomListener(window, 'load', function () {
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
	<h1>${rideEntry.getName()}
		<span style="float: right;">
			<c:if test="${rideRelation == 0}">
				<c:choose>
					<c:when test="${userType != 3}">
						<button class="btn btn-primary" onclick="location.href='/coolname/ride/${rideEntryID}/join'">Join Ride</button>
					</c:when>
					<c:otherwise>
						<c:if test="${driverName == 'No driver'}">
							<div class="btn-group">
  								<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    								Join as Driver <span class="caret"></span>
  								</button>
  								<ul class="dropdown-menu" role="menu">
    								${vehicles}
  								</ul>
							</div>
						</c:if>
						<button class="btn btn-primary" onclick="location.href='/coolname/ride/${rideEntryID}/join'">Join as Passenger</button>
					</c:otherwise>
				</c:choose>
			</c:if>
			<c:if test="${rideRelation == 1}">
				<span>
					<button class="btn btn-primary" onclick="location.href='/coolname/ride/${rideEntryID}/edit'">Edit Ride</button>
					<button class="btn btn-primary" onclick="location.href='/coolname/ride/${rideEntryID}/delete'">Delete Ride</button>
				</span>
			</c:if>
			<c:if test="${rideRelation == 2}">
				<button class="btn btn-primary" onclick="location.href='/coolname/ride/${rideEntryID}/leave'">Leave Ride</button>
			</c:if>
		</span>
	</h1>
	<h2>
				<c:if test="${roundTripEnd > 0}">
					Round Trip - Start
					<span style="float: right;">
					<button class="btn btn-primary" onclick="location.href='/coolname/ride/${roundTripEnd}/view'">End</button>
					</span>
				</c:if>
				<c:if test="${roundTripStart > 0}">
					Round Trip - End
					<span style="float: right;">
					<button class="btn btn-primary" onclick="location.href='/coolname/ride/${roundTripStart}/view'">Start</button>
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
</body>
</html>