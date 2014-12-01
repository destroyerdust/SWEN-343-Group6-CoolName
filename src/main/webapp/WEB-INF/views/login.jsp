<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Home - Ride Entries</title>
		<%@ include file="/WEB-INF/views/includes.jsp" %>
	</head>
	
	<!-- Begin Header -->
	<div id="head" >
		<!-- Includes all of the content within header.jsp-->
		<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
	<!-- End Header -->
<body>
	<div class="container">
			<div class="row">
				<div class="col-md-2"></div>	
				<div class="col-md-8">
					<div>
						<h1>Login</h1>
						<c:if test="${not l}">
							<div>USERNAME OR PASSWORD INCORRECT</div>
						</c:if>
					</div>
					<form class="form-horizontal" action="login" method="POST">
						<div class="form-group">
							<label for="usr" class="col-sm-2 control-label">User Name</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="usr" placeholder="User Name" autofocus>
							</div>
						</div>
						
						<div class="form-group">
							<label for="psw" class="col-sm-2 control-label">Password</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" name="psw" placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button class="btn btn-primary" type="submit" >Login</button>
							</div>
						</div>
					</form>
			    </div>
			    <div class="col-md-2"></div>
			</div>
		</div>
</body>
</html>