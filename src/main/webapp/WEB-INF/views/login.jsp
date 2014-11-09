<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN PAGE</h1>
<c:if test="${cookie.containsKey('auth')}">
	<div>USERNAME OR PASSWORD INCORRECT</div>
</c:if>
<div></div>
<form action="login" method="POST">
	
	<label>Username</label>
	<input type="text" name="usr">
	
	<label>Password</label>
	<input type="password" name="psw">
	
	<input type="submit" value="Login">
</form>
</body>
</html>