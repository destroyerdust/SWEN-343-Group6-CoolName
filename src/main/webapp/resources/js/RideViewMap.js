'use strict';
/*
 * markerArray = []; numMarkers = 0; google.maps.event.addListener(map, "click",
 * function(event) { placeMarker(event.latLng); });
 */

function showImmutableMap(center_lat, center_long, markers_json) {
	var mapProp = {
		center : new google.maps.LatLng(center_lat, center_long),
		zoom : 10,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	var map = new google.maps.Map(document.getElementById("map"), mapProp);
	
	// Iterate over JSON containing marker data and create the google.api Markers
	for (var i = 0; i <= markers_json.length; i++) {
		
		var mark_data = markers_json[i];
		var pos = new google.maps.LatLng(mark_data.latitude,
				mark_data.longitude);
		var marker = new google.maps.Marker({
			position : pos,
			map : map,
			title : mark_data.title
		});
		marker.setMap(map);
	}
}