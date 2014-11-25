<%@page import="java.util.List"%>
<%@page import="com.thumbsup.coolname.entity.Vehicle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ include file="/WEB-INF/views/includes.jsp" %>
	<!-- Begin Header -->
	<div id="head" >
		<!-- Includes all of the content within header.jsp-->
		<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
	<p>${serverTime}</p>
	<!-- End Header -->
<body>
<div class="container">
	<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<h1>My Account</h1>
		<div>
			<h3>Profile</h3>
			<button type="button" onclick="location.href='/coolname/account/profile/edit'">Edit Profile</button>
			<div class="form-group">
				<label>Username:</label>
				<span>${user.userName}</span>
			</div>
			<div class="form-group">
				<label>First name:</label>
				<span>${user.firstName}</span>
			</div>
			<div class="form-group">
				<label>Last name:</label>
				<span>${user.lastName}</span>
			</div>
			<div class="form-group">
				<label>Cell phone:</label>
				<span>${user.phoneNumber}</span>
			</div>
		</div>
		<div>
			<h3>Vehicles</h3>
			<button type="button" onclick="location.href='/coolname/account/vehicle/edit'">Vehicle Management</button>
			<c:forEach items="${user.vehicles}" var="vehicle">
				<div><span>${vehicle.model}</span><span>${vehicle.name}</span></div>
			</c:forEach>
		</div>
		<div>
			<h3>Rides in progress</h3>
			<div>
			</div>
		</div>
	</div>
	<div class="col-md-3"></div>
	</div><!-- Row End -->
	</div><!-- Container End -->
</body>
</html>