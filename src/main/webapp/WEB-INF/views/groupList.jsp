<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
	<head>
		<title>ThumbsUp - Groups</title>
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
			
			<h1>
				Groups - Find the right <bdi id="group" onclick="gerp()">group</bdi> for you.
				<span style = "float:right;">
					<button type="button" class="btn btn-primary" id="create-group" onclick="location.href='/coolname/group/create'">Create Group</button>
				</span>
			</h1>
			<script>
			function gerp()
			{
				document.getElementById("group").innerHTML = "gerp";
			}
			</script>
			
	<c:if test="${!empty groupList}">
		<table id="groupTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th></th>
            </tr>
        	<tr id="filterrow">
        		<th>Name</th>
                <th>Description</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${groupList}" var="group">
        		<tr>
        			<td><a href="/coolname/group/${group.getGroupID()}/view">${group.getName()}</a></td>
        			<td>${group.getDescription()}</td>
        			<td>
        				<c:set var="contains" value="false"/>        			
						<c:forEach var="ug" items="${userGroups}">							
  							<c:if test="${group.getName() eq ug.getName()}">
  								<c:set var="contains" value="true"/>
								<c:if test="${group.getOwnerID() eq ownerCheck}">
									<button type="button" class="btn btn-primary" id="edit-group"
										onclick="location.href='/coolname/group/${group.getGroupID()}/edit'">Edit
										Group</button>
								</c:if>
								<button type="button" class="btn btn-primary" id="leave-group"
								onclick="location.href='/coolname/group/${group.getGroupID()}/leave'">Leave
								Group</button>
  							</c:if>
						</c:forEach>
						<c:if test="${!contains}">
							<button type="button" class="btn btn-primary" id="create-group"
							onclick="location.href='/coolname/group/${group.getGroupID()}/join'">Join
							Group</button>
    					</c:if>
        			</td>
        		</tr>
        	</c:forEach>
        </tbody>
    </table>
        <script>
        // Setup - add a text input to each footer cell
        $('#groupTable thead tr#filterrow th').each( function () {
            var title = $('#groupTable thead th').eq( $(this).index() ).text();
            $(this).html( '<input type="text" onclick="stopPropagation(event);" placeholder="Search '+title+'" />' );
        } );
     
        // DataTable
        var table = $('#groupTable').DataTable();
         
        // Apply the filter
        $("#groupTable thead input").on( 'keyup change', function () {
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
