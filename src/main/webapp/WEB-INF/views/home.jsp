<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
	<%@ include file="/WEB-INF/views/includes.jsp" %>

	<!-- Begin Header -->
	<div id="head" >
		<!-- Includes all of the content within header.jsp-->
		<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
	<!-- End Header -->
	
	<body>
	
		<div class="container">
			<h1>
				Home page! Delicious.  
			</h1>
			
			<div class="row">
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			</div>
			<P>  The time on the server is ${serverTime}. </P>
		</div>
	</body>
</html>
=======
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
</div>
</body>
</html>
>>>>>>> 014a2d73d0440d6b36a870f8b6d1dee2fdbcca6e
