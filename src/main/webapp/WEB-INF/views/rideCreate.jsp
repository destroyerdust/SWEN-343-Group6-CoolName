<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<head>
<%@ include file="/WEB-INF/views/includes.jsp" %>

	<!-- Begin Header -->
	<div id="head" >
		<!-- Includes all of the content within header.jsp-->
		<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
<title>
	Create a Ride
</title>
<body>

<div class="container">
	<div class="row">
		<div class="col-md-3"></div>	
		<div class="col-md-6">
			<form role="form" method="POST">
				<div class="form-group">
					<h3 class="text-center">Create your ride request</h3>
				</div>
				<div class="form-group">
					<input name="name" type="text" class="form-control" placeholder="Name of ride">
				</div>
				<div class="form-group">
					<input name="destination" type="text" class="form-control" placeholder="Destination">
				</div>
				<div class="form-group">
					<input name="orgin" type="text" class="form-control" placeholder="Orgin">
				</div>
				<div class="form-group">
					<label for="departureTime" class="control-label">Departure Time</label>
					<input name="departureTime" type="datetime-local" class="form-control" placeholder="Departure Time">
				</div>
				
				<!-- This section for creating recurring Rides -->
				<div class="form-group text-center">
					<h4 class="text-center">Is this a recurring ride?</h4>
					<div id="WantsRecurringRide" class="btn-group" data-toggle="buttons">
						<label class="btn btn-primary">
							<input type="radio" value="Yes" name="RecurringRideChoice">Yes
						</label>
						<label class="btn btn-primary">
							<input type="radio" value="No" name="RecurringRideChoice">No
						</label>
					</div>
				</div>
				
				<div id="RecurringRide" class="form-group text-center">
					<label class="btn btn-primary">
						<input type="radio" value="Sunday" name="Day">Sun
					</label>
					<label class="btn btn-primary">
						<input type="radio" value="Monday" name="Day">Mon
					</label>
					<label class="btn btn-primary">
						<input type="radio" value="Tuesday" name="Day">Tue
					</label>
					<label class="btn btn-primary">
						<input type="radio" value="Wednesday" name="Day">Wed
					</label>
					<label class="btn btn-primary">
						<input type="radio" value="Thursday" name="Day">Thu
					</label>
					<label class="btn btn-primary">
						<input type="radio" value="Friday" name="Day">Fri
					</label>
					<label class="btn btn-primary">
						<input type="radio" value="Saturday" name="Day">Sat
					</label>
				</div>
															
				<!-- Note that the fieldset should only be viewable if a user has a car -->
				<c:if test="${isDriver}">
					<!-- Note that the fieldset should only be viewable if a driver wants to drive -->
					<div class="form-group text-center">
						<h4 class="text-center">Would you like to drive?</h4>
						<div id="WantsToDrive" class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary">
								<input type="radio" value="Yes" name="DriveCar">Yes
							</label>
							<label class="btn btn-primary">
								<input type="radio" value="No" name="DriveCar">No
							</label>
						</div>
					</div>
					
					<div id="Driving">								
						<fieldset>				
							<h3 class="text-center">Which car would you like to use?</h3>
							<div class="form-group">
								<label for="selectCar" class="control-label">Vehicle</label>
							    <select id="Car" name="selectCar" class="form-control">
							      <option value="" selected disabled>Select your Vehicle</option>
								  ${carChoice}				 
								</select>
							</div>
							<div class="form-group">
								<label for="numSeats" class="control-label">Available seats</label>
								<select id="numSeats" name="numSeats" class="form-control">
								  <option value="" selected disabled>Select # of Available seats</option>
								  <option>1</option>
								  <option>2</option>
								  <option>3</option>
								  <option>99</option>
								</select>
							</div>
						</fieldset>					
					</div>
				</c:if>
				<button type="submit" class="btn btn-primary btn-lg">Submit</button>
			</form>
		</div>
	
		<div class="col-md-3"></div>
	</div>
</div>

</body>

<script>
	$(document).ready(function(){
		$("#RecurringRide").hide();
		$("#Driving").hide();		
	});


	$("#WantsRecurringRide").change(function(){
		if($('input[name=RecurringRideChoice]:checked').val() == "Yes"){
			$("#RecurringRide").show();
		}else{
			$("#RecurringRide").hide();
		}
	});

	$("#WantsToDrive").change(function(){
		if($('input[name=DriveCar]:checked').val() == "Yes"){
			$("#Driving").show();
		}else{
			$("#Driving").hide('fast');
		}
	});
	
	$("#Car").change(function() {		
		$.ajax({
			type: "GET",
			url:  "coolname/ride/create/seats",
			data:{
				selectCar: $("#Car").val()		
			},
			dataType: "text",
			success:	
				function(data){				
					alert(data);
					$("#numSeats").empty().append( data);
				},
			error: function(jqxhr,textStatus,errorThrown)
            {
                console.log(jqxhr);
                console.log(textStatus);
                console.log(errorThrown);
            }
		});		
 	});

</script>

</html>
