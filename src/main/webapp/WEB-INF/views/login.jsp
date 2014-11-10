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
				<div class="col-md-3"></div>	
				<div class="col-md-offset-5">
					<div>
						<h1>LOGIN PAGE</h1>
							<c:if test="${not l}">
								<div>USERNAME OR PASSWORD INCORRECT</div>
							</c:if>
					</div>
					<form action="login" method="POST">
						<div class="form-group">
							<label>Username</label>
							<input type="text" name="usr">
						</div>
						
						<div class="form-group">
							<label>Password</label>
							<input type="password" name="psw">
						</div>
						
						<input class="btn btn-primary" type="submit" value="Login">
					</form>
			    </div>
			    <div class="col-md-3"></div>
			</div>
		</div>
</body>
</html>