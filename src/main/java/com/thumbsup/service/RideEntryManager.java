package com.thumbsup.service;

import java.sql.Timestamp;
import java.util.List;

import com.thumbsup.dao.RideEntryDAO;
import com.thumbsup.entity.RideEntry;
import com.thumbsup.entity.Vehicle;

public class RideEntryManager 
{
	private RideEntryDAO rideEntryDAO = new RideEntryDAO();
	
	//createRideEntry
	public RideEntry createRideEntry(Timestamp creationTimestamp, String destination, Timestamp endTime, String mapUri, String name, String source, Timestamp startTime, Vehicle vehicle)
	{
		RideEntry entry = new RideEntry();
		
		entry.setCreationTimestamp(creationTimestamp);
		entry.setDestination(destination);
		entry.setEndTime(endTime);
		entry.setMapUri(mapUri);
		entry.setName(name);
		entry.setSource(source);
		entry.setStartTime(startTime);
		entry.setVehicle(vehicle);
		
		entry = rideEntryDAO.insert(entry);
		
		return entry;
	}
	//updateRideEntry
	public int updateRideEntry(int rideEntryID, Timestamp creationTimestamp, String destination, Timestamp endTime, String mapUri, String name, String source, Timestamp startTime, Vehicle vehicle)
	{
		RideEntry entry = rideEntryDAO.select(rideEntryID);
		
		entry.setCreationTimestamp(creationTimestamp);
		entry.setDestination(destination);
		entry.setEndTime(endTime);
		entry.setMapUri(mapUri);
		entry.setName(name);
		entry.setSource(source);
		entry.setStartTime(startTime);
		entry.setVehicle(vehicle);
		
		rideEntryDAO.update(entry);
		
		return rideEntryID;
	}
	//deleteRideEntry
	public void deleteRideEntry(int rideEntryID)
	{
		RideEntry entry = rideEntryDAO.select(rideEntryID);
		
		rideEntryDAO.delete(entry);
	}
	//listRideEntry
	public List<RideEntry> listRideEntries()
	{
		List<RideEntry> entries = rideEntryDAO.selectAll();
		
		return entries;
	}
}
