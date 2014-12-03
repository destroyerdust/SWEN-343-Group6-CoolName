package com.thumbsup.coolname.service;

import java.util.List;

import com.thumbsup.coolname.dao.LocationDAO;
import com.thumbsup.coolname.entity.Location;

public class LocationManager {

	private LocationDAO locationDAO = new LocationDAO();

	// create location
	public Location createlocation(String title, double latitude,
			double longitude, int rideEntryID) {
		Location location = new Location();

		location.setTitle(title);
		location.setRideEntryID(rideEntryID);
		location.setLatitude(latitude);
		location.setLongitude(longitude);

		location = locationDAO.insert(location);

		return location;
	}

	// update location
	public int updatelocation(int locationID, String title, double latitude,
			double longitude, int rideEntryID) {
		Location location = locationDAO.select(locationID);

		location.setTitle(title);
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		location.setRideEntryID(rideEntryID);

		locationDAO.update(location);

		return locationID;
	}

	// deletelocation
	public void deletelocation(int locationID) {
		Location location = locationDAO.select(locationID);

		locationDAO.delete(location);
	}

	// listlocations
	public List<Location> listlocations() {
		List<Location> locations = locationDAO.selectAll();

		return locations;
	}

	public Location selectlocation(int locationID) {
		return locationDAO.select(locationID);
	}

	// Search the Location Table for Locations that contain the RideEntryID
	public List<Location> findLocationFromRideEntryId(int RideEntryID) {
		return locationDAO.findLocationFromRideEntryId(RideEntryID);
	}

}