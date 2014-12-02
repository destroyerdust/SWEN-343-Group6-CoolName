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
	<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
	<h1 class="text-center">Create vehicle</h1>
	<c:if test="${not s}">
		<div>INCORRECT INFORMATION</div>
	</c:if>
	<form class="form-horizontal" action="create" method="POST">
		<div class="form-group">
			<label for="model" class="col-sm-2 control-label">Model</label>
			<div class="col-sm-8">
				<input type="text" id="model" class="form-control" name="model">
			</div>
		</div>
		<div class="form-group">
			<label for="license" class="col-sm-2 control-label">License Plate</label>
			<div class="col-sm-8">
				<input type="text" id="license" class="form-control" name="license">
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name</label>
			<div class="col-sm-8">
				<input type="text" id="name" class="form-control" name="name">
			</div>
		</div>
		<div class="form-group">
			<label for="seats" class="col-sm-2 control-label">Number of Seats</label>
			<div class="col-sm-8">
				<input type="number" id="seats" class="form-control" name="seats" min="0" max="10" step="1" value="4">
			</div>
		</div>
		<div class="form-group">
			<label for="desc" class="col-sm-2 control-label">Description</label>
			<div class="col-sm-8">
				<textarea class="form-control" rows="4" id="desc" name="desc"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</form>
	</div>
	<div class="col-md-2"></div>
	</div><!-- Row End -->
	</div><!-- Container End -->
</body>
</html>