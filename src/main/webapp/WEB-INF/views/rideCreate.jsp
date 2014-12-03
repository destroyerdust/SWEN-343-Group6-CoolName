<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<%@ include file="/WEB-INF/views/includes.jsp" %>
<head>
	<!-- Begin Header -->
	<div id="head" >
		<!-- Includes all of the content within header.jsp-->
		<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
<title>
	Create a Ride
</title>
<body>

<div class="container">
	<div class="row">
		<div class="col-md-2"></div>	
		<div class="col-md-8">
			<form class="createRideForm form-horizontal" role="form" method="POST">
				<div class="form-group">
					<h1 class="text-center">Create your ride request</h1>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name of Ride</label>
					<div class="col-sm-8">
						<input name="name" type="text" class="form-control">
					</div>
				</div>
				
				<!-- Google Map Begin -->
					<div id="map" style="height: 310px; width: 100%; float: center;"></div>
					<input id="srcLat" name="srcLat" type="hidden" value="" class="form-control">
					<input id="srcLong" name="srcLong" type="hidden" value="" class="form-control">
					<input id="destLat" name="destLat" type="hidden" value="" class="form-control">
					<input id="destLong" name="destLong" type="hidden" value="" class="form-control">
				<!-- Google Map End -->
				
				<div class="form-group">
					<label for="destination" class="col-sm-2 control-label">Destination</label>
					<div class="col-sm-8">
						<input name="destination" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="orgin" class="col-sm-2 control-label">Origin</label>
					<div class="col-sm-8">
						<input name="orgin" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="departureTime" class="col-sm-2 control-label">Departure Time</label>
					<div class="col-sm-8">
						<div class='input-group date' id='datetimepicker1'>
                    		<input name="departureTime" type='text' class="form-control" />
                    		<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    		</span>
                		</div>
					</div>
				</div>
				<div class="form-group">
					<label for="arrivalTime" class="col-sm-2 control-label">Arrival Time</label>
					<div class="col-sm-8">
						<div class='input-group date' id='datetimepicker2'>
                    		<input name="arrivalTime" type='text' class="form-control" />
                    		<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    		</span>
                		</div>
					</div>
				</div>
				<div class="form-group">
					<label for="group-list" class="col-sm-2 control-label">Group</label>
					<div class="col-sm-8">
						<select id="Group" name="rideGroup" class="form-control">
							      		<option value="" selected disabled></option>
								  		${userGroups}				 
						</select>
					</div>
				</div>
				
				<!-- This section for determining if the ride will be Roundtrip -->
				<div class="form-group text-center">
					<h4 class="text-center">Is this a Roundtrip?</h4>
					<div id="WantsRoundtripRide" class="btn-group" data-toggle="buttons">
						<label class="btn btn-primary">
							<input type="radio" value="Yes" name="RoundtripRideChoice">Yes
						</label>
						<label class="btn btn-primary">
							<input type="radio" value="No" name="RoundtripRideChoice">No
						</label>
					</div>
				</div>	

				<div id="RoundTrip" class="form-group text-center">
					<div class="form-group">
						<label for="returnDepartureTime" class="control-label col-sm-2">
							Return Trip Departure Time
						</label>
						<div class="col-sm-8">
							<div class='input-group date' id='datetimepicker3'>
							     <input name="returnDepartureTime" type='text' class="form-control" />
                    			<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    			</span>
                				</div>
						</div>
					</div>
					<div class="form-group">
						<label for="returnArrivalTime" class="control-label col-sm-2">
							Return Trip Departure Time
						</label>
						<div class="col-sm-8">
							<div class='input-group date' id='datetimepicker4'>
							     <input name="returnArrivalTime" type='text' class="form-control" />
                    			<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    			</span>
                				</div>
						</div>
					</div>
				</div>		
															
				<!-- Note that the fieldset should only be viewable if a user has a car -->
				<c:if test="${isDriver}">
					<!-- Note that the fieldset should only be viewable if a driver wants to drive -->
					<div class="form-group text-center">
						<h4 class="text-center">Would you like to drive?</h4>
						<div id="WantsToDrive" class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary">
								<input type="radio" value="Yes" name="DriveCar">Yes
							</label>
							<label class="btn btn-primary">
								<input type="radio" value="No" name="DriveCar">No
							</label>
						</div>
					</div>
					
					<div id="Driving">								
						<fieldset>				
							<h3 class="text-center">Which car would you like to use?</h3>
							<div class="form-group">
								<label for="selectCar" class="control-label col-sm-2">Vehicle</label>
								<div class="col-sm-8">
							    	<select id="Car" name="selectCar" class="form-control">
							      		<option value="" selected disabled>Select your Vehicle</option>
								  		${carChoice}				 
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="numSeats" class="control-label col-sm-2">Available seats</label>
								<div class="col-sm-8">
									<select id="numSeats" name="numSeats" class="form-control">
								  		<option value="" selected disabled>Select # of Available seats</option>
		   							  	<option>1</option>
								  		<option>2</option>
								  		<option>3</option>
								  		<option>99</option>
									</select>
								</div>
							</div>
						</fieldset>					
					</div>
				</c:if>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-lg">Submit</button>
					</div>
				</div>
			</form>
		</div>
	
		<div class="col-md-2"></div>
	</div>
</div>

</body>

<script>
	$(document).ready(function(){
		$("#RoundTrip").hide();
		$("#Driving").hide();		
	});

	$('#WantsRoundtripRide').change(function(){
		if($('input[name=RoundtripRideChoice]:checked').val() == "Yes"){
			$("#RoundTrip").show();
		}else{
			$("#RoundTrip").hide();
		}
	});

	$("#WantsToDrive").change(function(){
		if($('input[name=DriveCar]:checked').val() == "Yes"){
			$("#Driving").show();
		}else{
			$("#Driving").hide('fast');
		}
	});
	
	$("#Car").change(function() {		
		$.ajax({
			type: "GET",
			url:  "coolname/ride/create/seats",
			data:{
				selectCar: $("#Car").val()		
			},
			dataType: "text",
			success:	
				function(data){				
					$("#numSeats").empty().append( data);
				},
			error: function(jqxhr,textStatus,errorThrown)
            {
                console.log(jqxhr);
                console.log(textStatus);
                console.log(errorThrown);
            }
		});		
 	});
	
	$(function () {
        $('#datetimepicker1').datetimepicker();
    });
	$(function () {
        $('#datetimepicker2').datetimepicker();
    });
	$(function () {
        $('#datetimepicker3').datetimepicker();
    });
	$(function () {
        $('#datetimepicker4').datetimepicker();
    });
</script>
<script>
    $(document).ready(function() {
        $('.createRideForm').bootstrapValidator({
        	excluded: [':disabled', ':hidden', ':not(:visible)'],
        	message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	name: {
                    message: 'The name of ride is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The name of ride is required and cannot be empty'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: 'The name of ride must be more than 6 and less than 30 characters long'
                        }
                    }
                },
                destination: {
                    validators: {
                        notEmpty: {
                            message: 'The destination is required'
                        }
                    }
                },
                orgin: {
                	validators: {
                		notEmpty: {
                			message: 'The origin is required'
                		}
                	}
                }
            }
        });
    });
    
    /* The following function creates the markable Google Map to the "map" element "
    	Clicking on the map either: 
    		1) sets the ride's origin marker,
    		2) sets the ride's destination marker,
    		else) clears the markers
    */
    (function () {
        'use strict';

        //Rochester, NY coordinates
        var center_lat = 43.0758,
            center_long = -77.6647;

        function showMarkableMap(center_lat, center_long) {
            var mapOptions = {
                center : new google.maps.LatLng(center_lat, center_long),
                zoom : 10,
                mapTypeId : google.maps.MapTypeId.ROADMAP
            },
            
            map = new google.maps.Map(document.getElementById("map"), mapOptions);
            
            //Use the Array and a Switch statement to control all markers on the map
            var markersArray = [];
            
            //On click, do something to the map and markersArray
            google.maps.event.addListener(map, 'click', function(event) {
                var positionClicked = new google.maps.LatLng(event.latLng.lat(), event.latLng.lng());

            	switch(markersArray.length){
	            	case 0:  //add origin
		            	var srcMarker = new google.maps.Marker({
		        			position : positionClicked,
		        			map : map,
		        			title : "Origin"
		        		});
	            		markersArray.push(srcMarker);
		                document.getElementById('srcLat').value = event.latLng.lat();
                		document.getElementById('srcLong').value = event.latLng.lng();
		            	break;
		            	
	            	case 1: //add destination
		            	var destMarker = new google.maps.Marker({
		        			position : positionClicked,
		        			map : map,
		        			title : "Destination"
		        		});
	            		markersArray.push(destMarker);
		            	document.getElementById('destLat').value = event.latLng.lat();
                		document.getElementById('destLong').value = event.latLng.lng();
		            	break;
		            	
	            	default: //reset count, reset array
	            		for (var i = 0; i < markersArray.length; i++ ) {
	            	   	 	markersArray[i].setMap(null);
	            	  	}
	            	 	markersArray.length = 0;
	            		break; 
            	}
            }) 
        }

        google.maps.event.addDomListener(window, 'load', function () {
            showMarkableMap(center_lat, center_long);
        });
    }());
    </script>

</html>
