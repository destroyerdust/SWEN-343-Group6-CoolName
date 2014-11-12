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
	<div class="col-md-3"></div>
	<div class="col-md-6">
	<h1>Sign Up</h1>
	<c:if test="${not s}">
		<div>INCORRECT INFORMATION</div>
	</c:if>
	<form action="signup" method="POST">
		<div class="form-group">
			<input type="text" id="usr" class="form-control" name="usr" placeholder="User Name">
		</div>
		<div class="form-group">
			<input type="password" id="psw" class="form-control" name="psw" placeholder="Password">
		</div>
		<div class="form-group">
			<input type="text" id="name" class="form-control" name="name" placeholder="First Name">
		</div>
		<div class="form-group">
			<input type="text" id="lstn" class="form-control" name="lstn" placeholder="Last Name">
		</div>
		<div class="form-group">
			<input type="text" id="cell" class="form-control" name="cell" placeholder="Cell Phone Number">
		</div>
		<div class="form-group">
			<p>Have a car?</p>
			<div class="btn-group" data-toggle="buttons">
				<label class="btn btn-primary">
					<input type="radio" value="Yes" id="caryes" name="caraswr"> Yes
				</label>
				<label class="btn btn-primary">
					<input type="radio" value="No" id="carno" name="caraswr"> No
				</label>
			</div>
		</div>
		<div class="form-group">
			<input type="text" id="model" class="form-control" name="model" placeholder="Model">
		</div>
		<div class="form-group">
			<input type="number" id="seats" class="form-control" name="seats" min="0" max="10" step="1" value="4" placeholder="Number Seats">
		</div>
		<div class="form-group">
			<textarea class="form-control" rows="4" id="desc" name="desc" placeholder="Vehicle Description"></textarea>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
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
</body>
</html>