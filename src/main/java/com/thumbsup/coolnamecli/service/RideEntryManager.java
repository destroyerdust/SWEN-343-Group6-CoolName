package com.thumbsup.coolnamecli.service;

import java.sql.Timestamp;
import java.util.List;

import com.thumbsup.coolnamecli.dao.RideEntryDAO;
import com.thumbsup.coolnamecli.entity.RideEntry;
import com.thumbsup.coolnamecli.entity.Vehicle;

public class RideEntryManager 
{
	private RideEntryDAO rideEntryDAO = new RideEntryDAO();
	
	//createRideEntry
	public int createRideEntry(int rideEntryID, Timestamp creationTimestamp, String destination, Timestamp endTime, String mapUri, String name, String source, Timestamp startTime, Vehicle vehicle)
	{
		RideEntry entry = new RideEntry();
		
		entry.setCreationTimestamp(creationTimestamp);
		entry.setDestination(destination);
		entry.setEndTime(endTime);
		entry.setMapUri(mapUri);
		entry.setName(name);
		entry.setRideEntryID(rideEntryID);
		entry.setSource(source);
		entry.setStartTime(startTime);
		entry.setVehicle(vehicle);
		
		rideEntryDAO.insert(entry);
		
		return rideEntryID;
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
