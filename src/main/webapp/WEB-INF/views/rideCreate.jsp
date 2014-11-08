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
	<title>Ride Create</title>
</head>
<body>

<div class="container">
	
	<div>
		<form>
			<div class="row">
			  <div class="col-md-3"><center>.col-md-3</center></div>  
			  <div class="col-md-6"><center>Create your ride request</center></div>  
			  <div class="col-md-3"><center>.col-md-3</center></div>
			</div>
			
			<div class="row">
			  <div class="col-md-3"><center>.col-md-3</center></div>  
			  <div class="col-md-2"><center>.col-md-2</center></div>
			  <div class="col-md-2"><center>Destination TextBox</center></div>
			  <div class="col-md-2"><center>.col-md-1</center></div>  
			  <div class="col-md-3"><center>.col-md-3</center></div>
			</div>
			
			<div class="row">
			  <div class="col-md-3"><center>.col-md-3</center></div>  
			  <div class="col-md-2"><center>.col-md-2</center></div>
			  <div class="col-md-2"><center>Orgin TextBox</center></div>
			  <div class="col-md-2"><center>.col-md-1</center></div>  
			  <div class="col-md-3"><center>.col-md-3</center></div>
			</div>
			
			<div class="row">
			  <div class="col-md-3"><center>.col-md-3</center></div>  
			  <div class="col-md-2"><center>.col-md-2</center></div>
			  <div class="col-md-2"><center>Depature Time</center></div>
			  <div class="col-md-2"><center>.col-md-1</center></div>  
			  <div class="col-md-3"><center>.col-md-3</center></div>
			</div>
			<div class="row">
			  <div class="col-md-3"><center>.col-md-3</center></div>  
			  <div class="col-md-2"><center>.col-md-2</center></div>
			  <div class="col-md-2"><center>submit</center></div>
			  <div class="col-md-2"><center>.col-md-1</center></div>  
			  <div class="col-md-3"><center>.col-md-3</center></div>
			</div>
		</form>
	</div>
<P>  The time on the server is ${serverTime}. </P>
</div>
</body>
</html>
