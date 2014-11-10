<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>LOGIN PAGE</h1>
<c:if test="${not l}">
	<div>USERNAME OR PASSWORD INCORRECT</div>
</c:if>

<form action="login" method="POST">
	
	<label>Username</label>
	<input type="text" name="usr">
	
	<label>Password</label>
	<input type="password" name="psw">
	
	<input type="submit" value="Login">
</form>
</body>
</html>