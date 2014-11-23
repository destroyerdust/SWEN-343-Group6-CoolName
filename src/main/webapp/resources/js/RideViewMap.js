'use strict';
/*
 * Author: Conor Craig
 * 
 */

function initialize() {
var mapProp = {
	center : new google.maps.LatLng(43.0758, -77.6647),
	zoom : 10,
	mapTypeId : google.maps.MapTypeId.ROADMAP
};
var map = new google.maps.Map(document.getElementById("map"), mapProp);
}