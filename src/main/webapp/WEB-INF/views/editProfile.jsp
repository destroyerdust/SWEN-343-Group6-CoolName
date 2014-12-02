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
	<div class="col-md-2"></div>
	<div class="col-md-8">
	<h1 class="text-center">Edit User</h1>
	<c:if test="${not s}">
		<div>INCORRECT INFORMATION</div>
	</c:if>
	<form:form class="form-horizontal" action="edit" method="POST" modelAttribute="user">
		<div class="form-group">
			<label class="col-sm-2 control-label">Username: </label>
			<div class="col-sm-8">
				<p class="form-control-static" name="userName">${user.userName}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">First name:</label>
			<div class="col-sm-8">
				<input type="text" id="name" class="form-control" name="firstName" value="${user.firstName}">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Last name:</label>
			<div class="col-sm-8">
				<input type="text" id="lstn" class="form-control" name="lastName" value="${user.lastName}">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Cell phone:</label>
			<div class="col-sm-8">
				<input type="text" id="cell" class="form-control" name="phoneNumber" value="${user.phoneNumber}">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">	
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</form:form>
	</div>
	<div class="col-md-2"></div>
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