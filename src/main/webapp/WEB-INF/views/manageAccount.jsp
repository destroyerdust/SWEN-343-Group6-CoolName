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
	<h1>Sign Up</h1>
	<form:form action="manage" method="POST" modelAttribute="user">
		<div class="form-group">
			<label>Username: </label><span name="userName">${user.userName}</span>
		</div>
<!-- 		<div class="form-group">
			<input type="password" id="psw" class="form-control" name="psw" placeholder="Password">
		</div> -->
		<div class="form-group">
			<label>First name:</label>
			<input type="text" id="name" class="form-control" name="firstName" value="${user.firstName}">
		</div>
		<div class="form-group">
			<label>Last name:</label>
			<input type="text" id="lstn" class="form-control" name="lastName" value="${user.lastName}">
		</div>
		<div class="form-group">
			<label>Cell phone:</label>
			<input type="text" id="cell" class="form-control" name="phoneNumber" value="${user.phoneNumber}">
		</div>
		<div class="form-group">
			<label>Vehicles:</label>
			<div >
				<c:forEach items="${user.vehicles}" var="v">
					<div>
						<span>${v.model}</span>
						<span style="float: right">
							<span class="vehicleID" style="display:none">${v.vehicleID}</span>
							<button type="button" class="editbtn" style="margin-right: 25px;">Edit</button>
							<button type="button" class="deletebtn" >Delete</button>
						</span>
					</div>
				</c:forEach>
				<c:forEach items="${user.vehicles}" var="vehicle" varStatus="status">
					<div class="${vehicle.vehicleID}" class="form-group" style="display: none">
						<form:hidden path="vehicles[${status.index}].vehicleID" name="vehicleID" value="${vehicle.vehicleID}"/>
						<label>Model: </label>
						<div class="form-group">
							<form:input class="form-control" path="vehicles[${status.index}].model" name="model" value="${vehicle.model}" />
						</div>
						<label>Name: </label>
						<div class="form-group">
							<form:input class="form-control" path="vehicles[${status.index}].name" name="name" value="${vehicle.name}" />
						</div>
						<label>Seats:</label>
						<div class="form-group">
							<form:input class="form-control" path="vehicles[${status.index}].numSeats" name="numSeats" value="${vehicle.numSeats}" />
						</div>
						<label>Description:</label>
						<div class="form-group">
							<form:textarea class="form-control" path="vehicles[${status.index}].description" name="description" value="${vehicle.description}" />
						</div>
						<button type="button" class="vehicleSavebtn btn btn-primary">Save</button>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
	</div>
	<div class="col-md-3"></div>
	</div><!-- Row End -->
	</div><!-- Container End -->
	<script>
	var phoneInput = document.getElementById('cell');
    if (phoneInput) {
      new Formatter(phoneInput, {
          'pattern': '({{999}}) {{999}}-{{9999}}'
      });
    }
    </script>
    <script>
	    $(document).ready(function(){
		    $(".vehicleSavebtn").click(function(){
		    	$(this).parent().hide("slow");
		  	});
	    });
	    
	    $(document).ready(function(){
		    $(".editbtn").click(function(){
		    	var vehicleId = $(this).parent().children(".vehicleID").text();
		  	 	$( "."+ vehicleId ).show( "slow" );
		  	});
	    });
	    
	    $(document).ready(function(){
	    	$(".deletebtn").click(function(){
	    		
	    	});
	    });
    </script>
</body>
</html>