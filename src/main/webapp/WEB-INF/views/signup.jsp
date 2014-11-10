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
<c:if test="${not s}">
	<div>INCORRECT INFORMATION</div>
</c:if>
<h1>SIGNUP PAGE</h1>
	<form action="signup" method="POST">
		<label>Username</label>
		<input type="text" id="usr" name="usr">
		<label>Password</label>
		<input type="password" id="psw" name="psw">
		<label>Name</label>
		<input type="text" id="name" name="name">
		<label>Last name</label>
		<input type="text" id="lstn" name="lstn">
		<label>Cellphone number</label>
		<input type="text" id="cell" name="cell">
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
</body>
</html>