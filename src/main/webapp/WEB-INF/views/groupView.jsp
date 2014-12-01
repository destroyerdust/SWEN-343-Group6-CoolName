<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page session="false"%>

<html>
<head>
<title>Group - ${group.getName()}</title>
<%@ include file="/WEB-INF/views/includes.jsp"%>
</head>
<!-- Begin Header -->
<div id="head">
	<!-- Includes all of the content within header.jsp-->
	<%@ include file="/WEB-INF/views/header.jsp"%>
</div>
<!-- End Header -->
<body>
	<div class="container">

		<h1>
			${group.getName()} <span style="float: right;">
				<button type="button" class="btn btn-primary" id="create-group"
					onclick="location.href='/coolname/group/${group.getGroupID()}/join'">Join
					Group</button>
			</span>
		</h1>
		<table id="rideListTable" class="table table-striped table-bordered"
			cellspacing="0">
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
				<c:forEach items="${rideEntries}" var="entry">
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
		<table class="table table-condensed">
			<th>Members of this group:</th>
			<tbody>
				<c:forEach items="${groupUsers}" var="user">
					<tr>
						<td>${user.getUserName()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script>
			// Setup - add a text input to each footer cell
			$('#rideListTable thead tr#filterrow th').each(
					function() {
						var title = $('#rideListTable thead th').eq(
								$(this).index()).text();
						$(this).html(
								'<input type="text" onclick="stopPropagation(event);" placeholder="Search '
										+ title + '" />');
					});

			// DataTable
			var table = $('#rideListTable').DataTable();
			table.width = "80%";
			// Apply the filter
			$("#rideListTable thead input").on(
					'keyup change',
					function() {
						table.column($(this).parent().index() + ':visible')
								.search(this.value).draw();
					});

			function stopPropagation(evt) {
				if (evt.stopPropagation !== undefined) {
					evt.stopPropagation();
				} else {
					evt.cancelBubble = true;
				}
			}
		</script>
	</div>

</body>
</html>