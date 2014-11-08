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
<title>Thumbsup - Delicious</title>
<%@ include file="/WEB-INF/views/header.jsp" %>
</head>
<body>
<div class="container">
	<div>Find Your Perfect Ride</div>
	<form class="form-inline" role="form">
		<input id="start-location" class="form-control">
		<input id="end-location" class="form-control">
		<input id="departure-time" type="datetime-local" class="form-control">
		<input id="arrival-time" type="datetime-local" class="form-control">
		<button id="find-button" type="button" class="btn btn-primary btn-md">Find a ride</button>
	</form>
	<div>
		<br><button id="create-button" type="button" class="btn btn-primary btn-md">Create a New Ride</button>
	</div>
	<div>${serverTime}</div>
</div>
</body>
</html>