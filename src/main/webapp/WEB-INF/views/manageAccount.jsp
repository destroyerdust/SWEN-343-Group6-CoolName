<%@page import="java.util.List"%>
<%@page import="com.thumbsup.coolname.entity.Vehicle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<!-- Begin Header -->
<div id="head">
	<!-- Includes all of the content within header.jsp-->
	<%@ include file="/WEB-INF/views/header.jsp"%>
</div>
<p>${serverTime}</p>
<!-- End Header -->
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h1 class="text-center">My Account</h1>
				<div>
					<div class="col-sm-offset-2 col-sm-10">
						<h3>Profile</h3>
					
					<button type="button" class="btn btn-primary"
						onclick="location.href='/coolname/account/profile/edit'">Edit
						Profile</button>
					</div>
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">Username:</label>
							<div class="col-sm-8">
								<p class="form-control-static">${user.userName}</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">First name:</label>
							<div class="col-sm-8">
								<p class="form-control-static">${user.firstName}</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Last name:</label>
							<div class="col-sm-8">
								<p class="form-control-static">${user.lastName}</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Cell phone:</label>
							<div class="col-sm-8">
								<p class="form-control-static">${user.phoneNumber}</p>
							</div>
						</div>
					</form>
				</div>
				<div class="col-sm-offset-2 col-sm-10">
					<h3>Vehicles</h3>
					<button type="button" class="btn btn-primary"
						onclick="location.href='/coolname/account/vehicle/edit'">Vehicle
						Management</button>
					<c:forEach items="${user.vehicles}" var="vehicle">
						<div>
							<span>${vehicle.model}</span><span>${vehicle.name}</span>
						</div>
					</c:forEach>
				</div>
				<div class="col-sm-offset-2 col-sm-10">
					<h3>My Rides</h3>
					<button type="button" class="btn btn-primary"
						onclick="location.href='/coolname/rides/edit'">Ride
						Management</button>
					<c:forEach items="${user.vehicles}" var="vehicle">
						<c:forEach items="${vehicle.rideEntries}" var="ride">
							<c:if test="${ride.status == 'In Progress' || ride.status == 'Seating'}">
								<div><span>${ride.name}</span><span>${ride.status}</span></div>
							</c:if>
						</c:forEach>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!-- Row End -->
	</div>
	<!-- Container End -->
</body>
</html>