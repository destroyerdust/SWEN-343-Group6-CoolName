<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
	<%@ include file="/WEB-INF/views/includes.jsp" %>

	<!-- Begin Header -->
	<div id="head" >
		<!-- Includes all of the content within header.jsp-->
		<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
	<!-- End Header -->
	
	<body>
	
		<div class="container">
			<h1>
				Home page! Delicious.  
			</h1>
			
			<div class="row">
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			  <div class="col-md-1">.col-md-1</div>
			</div>
			<P>  The time on the server is ${serverTime}. </P>
		</div>
	</body>
</html>
