<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/views/includes.jsp"%>

<!-- Begin Header -->
<div id="head">
	<!-- Includes all of the content within header.jsp-->
	<%@ include file="/WEB-INF/views/header.jsp"%>
</div>
<!-- End Header -->

<body>
	<div class="container">
		<p>Ride Entry History</p>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>

					<th>Source</th>

					<th>Destination</th>

				</tr>
			</thead>
		</table>
	</div>
</body>
</html>