<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page session="false" %>

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
			<h1>ThumbsUp - Find your <bdi id="perfect" onclick="delicious()">perfect</bdi> ride.</h1>
			<script>
			function delicious()
			{
				document.getElementById("perfect").innerHTML = "delicious";
			}
			</script>
	<c:if test="${!empty listRideEntrys}">
		<table id="rideListTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Start Time</th>
                <th>End Time</th>
            </tr>
        	<tr id="filterrow">
        		<th>Name</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Start Time</th>
                <th>End Time</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${listRideEntrys}" var="entry">
        		<tr>
        			<td><a href="/coolname/ride/${entry.getRideEntryID()}/view">${entry.getName()}</a></td>
        			<td>${entry.getSource()}</td>
        			<td>${entry.getDestination()}</td>
        			<td>${entry.getStartTime()}</td>
        			<td>${entry.getEndTime()}</td>
        		</tr>
        	</c:forEach>
        </tbody>
    </table>
        <script>
        // Setup - add a text input to each footer cell
        $('#rideListTable thead tr#filterrow th').each( function () {
            var title = $('#rideListTable thead th').eq( $(this).index() ).text();
            $(this).html( '<input type="text" onclick="stopPropagation(event);" placeholder="Search '+title+'" />' );
        } );
     
        // DataTable
        var table = $('#rideListTable').DataTable();
         
        // Apply the filter
        $("#rideListTable thead input").on( 'keyup change', function () {
            table
                .column( $(this).parent().index()+':visible' )
                .search( this.value )
                .draw();
        } );

      function stopPropagation(evt) {
    		if (evt.stopPropagation !== undefined) {
    			evt.stopPropagation();
    		} else {
    			evt.cancelBubble = true;
    		}
    	}

        </script>
		</c:if>
    </div>

	</body>
</html>
