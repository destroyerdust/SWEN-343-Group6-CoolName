'use strict';
/*
 * Author: Conor Craig
 * 
 */

function initialize(center_lat, center_long, src_lat, src_long, dest_lat, dest_long) {
	var mapProp = {
		center : new google.maps.LatLng(center_lat, center_long),
		zoom : 10,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	var map = new google.maps.Map(document.getElementById("map"), mapProp);

	var src_marker = new google.maps.Marker({
		position : new google.maps.LatLng(src_lat, src_long),
		map : map,
		title : 'Click to zoom'
	});

	var dest_marker = new google.maps.Marker({
		position : new google.maps.LatLng(dest_lat, dest_long),
		map : map,
		title : 'Click to zoom'
	});
	
}