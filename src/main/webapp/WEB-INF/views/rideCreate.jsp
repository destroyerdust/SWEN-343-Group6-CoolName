<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<head>
	<%@ include file="/WEB-INF/views/header.jsp" %>
</head>
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
					<input id="destination" type="text" class="form-control" placeholder="Destination">
				</div>
				<div class="form-group">
					<input id="orgin" type="text" class="form-control" placeholder="Orgin">
				</div>
				<div class="form-group">
					<input id="depatureTime" type="datetime-local" class="form-control" placeholder="Depature Time">
				</div>
				
				<!-- Note that the fieldset should only be viewable if a user has a car -->
				<fieldset>				
					<h3 class="text-center">Which car would you like to use?</h3>
					<div class="form-group">
						<label for="selectCar" class="control-label">Vehicle</label>
					    <select id="selectCar" class="form-control">
					      <option value="" selected disabled>Select your Vehicle</option>
						  <option>car 1</option>
						  <option>car 2</option>				 
						</select>
					</div>
					<div class="form-group">
						<label for="numSeats" class="control-label">Available seats</label>
						<select id="numSeats" class="form-control">
						  <option value="" selected disabled>Select # of Available seats</option>
						  <option>1</option>
						  <option>2</option>
						  <option>3</option>
						  <option>4</option>
						  <option>5</option>
						</select>
					</div>
				</fieldset>
				<button type="submit" class="btn btn-default btn-lg">Submit</button>
			</form>
		</div>
	
		<div class="col-md-3"></div>
	</div>
</div>

</body>

</html>
