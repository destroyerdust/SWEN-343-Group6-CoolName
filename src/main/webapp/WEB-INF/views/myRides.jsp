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
	<h1 class="text-center">My Rides</h1>
	<c:if test="${not s}">
		<div>INCORRECT INFORMATION</div>
	</c:if>
	<c:if test="${p}">
		<div>THE RIDE(S) COULD NOT BE DELETED, IT IS ALREADY RELATED TO AN USER</div>
	</c:if>
	<form:form action="edit" method="POST" modelAttribute="user">
		<div class="form-group">
			<div >
				<button style="margin-bottom: 10px;" class="btn btn-primary" type="button" onclick="location.href='/coolname/ride/create'">Create new ride</button>
				<c:forEach items="${user.vehicles}" var="v">
					<c:forEach items="${v.rideEntries}" var="ride">
						<c:if test="${ride.status == 'In Progress' || ride.status == 'Seating'}">
							<div class="${ride.rideEntryID}" style="margin-bottom: 10px">
								<div style="float: left;width: 300px;">${ride.name}</div>
								<div style="margin-left: 50px;">
									<span class="rideEntryID" style="display:none">${ride.rideEntryID}</span>
									<button type="button" class="editbtn btn btn-primary" style="margin-right: 25px;">Edit</button>
									<button type="button" class="deletebtn btn btn-primary" >Delete</button>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</c:forEach>
				<c:forEach items="${user.vehicles}" var="vehicle" varStatus="i">
					<c:forEach items="${vehicle.rideEntries}" var="ride" varStatus="j">
						<c:if test="${ride.status == 'In Progress' || ride.status == 'Seating'}">
							<div class="${ride.rideEntryID}" class="form-group" style="display: none">
								<form:hidden path="vehicles[${i.index}].rideEntries[${j.index}].rideEntryID" name="rideEntryID" value="${ride.rideEntryID}"/>
								<label>Name: </label>
								<div class="form-group">
									<form:input class="form-control" path="vehicles[${i.index}].rideEntries[${j.index}].name" name="name" value="${ride.name}" />
								</div>
								<label>Destination:</label>
								<div class="form-group">
									<form:input class="form-control" path="vehicles[${i.index}].rideEntries[${j.index}].destination" name="destination" value="${ride.destination}" />
								</div>
								<label>Origin: </label>
								<div class="form-group">
									<form:input class="form-control" path="vehicles[${i.index}].rideEntries[${j.index}].source" name="source" value="${ride.source}" />
								</div>
								<label>Seats:</label>
								<div class="form-group">
									<form:input class="form-control" path="vehicles[${i.index}].rideEntries[${j.index}].numSeats" name="numSeats" value="${ride.numSeats}" />
								</div>
								<label>Departure Time:</label>
								<div class="form-group">
									<form:input class="form-control" path="vehicles[${i.index}].rideEntries[${j.index}].startTime" name="startTime" value="${ride.startTime}" />
								</div>
								<button type="button" class="rideSavebtn btn btn-primary">Save</button>
							</div>
						</c:if>
					</c:forEach>
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
		    $(".rideSavebtn").click(function(){
		    	$(this).parent().hide("slow");
		  	});
	    });
	    
	    $(document).ready(function(){
		    $(".editbtn").click(function(){
		    	var vehicleId = $(this).parent().children(".rideEntryID").text();
		  	 	$( "."+ vehicleId ).show( "slow" );
		  	});
	    });
	    
	    $(document).ready(function(){
	    	$(".deletebtn").click(function(){
	    		var vehicleID = $(this).parent().children(".rideEntryID").text();
	    		$("."+vehicleID).hide("slow", function(){
	    			$("."+vehicleID).remove();
	    		});
	    	});
	    });
    </script>
</body>
</html>