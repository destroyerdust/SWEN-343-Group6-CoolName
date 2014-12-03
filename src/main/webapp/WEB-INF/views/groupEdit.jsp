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
	Edit a Group
</title>
<body>

<div class="container">
	<div class="row">
		<div class="col-md-3"></div>		
		<div class="col-md-6">
			
			
			<form role="form" method="POST">
				<h3 class="text-center">${group.getName()}</h3>
				<div class="form-group">
					<label for="name" class="control-label">Group Name</label>
					<input name="name" type="text" value="${group.getName()}" class="form-control">	
				</div>
				<div class="form-group">
					
				</div>
				<div class="form-group">
					<label for="name" class="control-label">Group Description</label>					
					<textarea name="description" type="text" class="form-control">${group.getDescription()}</textarea>							
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-lg">Submit</button>
					</div>
				</div>
			</form>
		</div>
	
		<div class="col-md-3"></div>
	</div>
</div>

</body>
</html>
