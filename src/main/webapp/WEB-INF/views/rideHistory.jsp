<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Ride History</title>
		<%@ include file="/WEB-INF/views/includes.jsp"%>
	</head>

<!-- Begin Header -->
<div id="head">
	<!-- Includes all of the content within header.jsp-->
	<%@ include file="/WEB-INF/views/header.jsp"%>
</div>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- End Header -->

<body>
	<div class="container">
		<p>Ride Entry History</p>
		<c:if test="${not empty myRides}">
			<table class="table">
				<tr>
					<th>Name</th>
					<th>Source</th>
					<th>Destination</th>
				</tr>
				<c:forEach items="${myRides}" var="entry">
					<tr>
						<td>${entry.getName()}</td>
						<td>${entry.getSource()}</td>
						<td>${entry.getDestination()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>