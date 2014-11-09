<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<c:if test="${not s}">
	<div>INCORRECT INFORMATION</div>
</c:if>
	<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
	<h1>Sign Up</h1>
	<form action="signup" method="POST">
		<div class="form-group">
			<input type="text" id="usr" class="form-control" name="usr" placeholder="User Name">
		</div>
		<div class="form-group">
			<input type="password" id="psw" class="form-control" name="psw" placeholder="Password">
		</div>
		<div class="form-group">
			<input type="text" id="name" class="form-control" name="name" placeholder="First Name">
		</div>
		<div class="form-group">
			<input type="text" id="lstn" class="form-control" name="lstn" placeholder="Last Name">
		</div>
		<div class="form-group">
			<input type="text" id="cell" class="form-control" name="cell" placeholder="Cell Phone Number">
		</div>
		<div>
			<p>Have a car?</p>
			<input type="radio" value="Yes" id="caryes" name="caraswr">
			<input type="radio" value="No" id="carno" name="caraswr">
			<label>Model</label>
			<input type="text" id="model" name="model">
			<label>Seats</label>
			<input type="number" id="seats" name="seats" min="0" max="10" step="1" value="4">
			<label>Vehicle description</label>
			<textarea rows="4" cols="5" id="desc" name="desc"></textarea>
			<input type="submit" value="Submit">
		</div>
	</form>
	</div>
	<div class="col-md-3"></div>
	</div><!-- Row End -->
	</div><!-- Container End -->
</body>
</html>