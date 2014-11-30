package com.thumbsup.coolname.service;

import java.util.List;

import com.thumbsup.coolname.dao.RoundTripDAO;
import com.thumbsup.coolname.entity.RoundTrip;
import com.thumbsup.coolname.entity.Vehicle;
import com.thumbsup.coolname.entity.RoundTrip;

public class RoundTripManager 
{
	private RoundTripDAO roundTripDAO = new RoundTripDAO();
	
	public RoundTrip createRoundTrip(int startRoundTripID, int endRoundTripID)
	{
		RoundTrip roundtrip = new RoundTrip();
		
		roundtrip.setStartRideEntryID(startRoundTripID);
		roundtrip.setEndRideEntryID(endRoundTripID);
		
		roundTripDAO.insert(roundtrip);
		
		return roundtrip;		
	}
	
	public int updateRoundTrip(int roundTripID, int startRoundTripID, int endRoundTripID){
		RoundTrip roundtrip = roundTripDAO.select(roundTripID);
		
		roundtrip.setStartRideEntryID(startRoundTripID);
		roundtrip.setEndRideEntryID(endRoundTripID);
		
		roundTripDAO.update(roundtrip);
		
		return roundTripID;		
	}
	
	public void deleteRoundTrip(int roundTripID)
	{
		RoundTrip roundtrip = roundTripDAO.select(roundTripID);
		
		roundTripDAO.delete(roundtrip);
	}
	//listRoundTrip
	public List<RoundTrip> listRideEntries()
	{
		List<RoundTrip> roundtrip = roundTripDAO.selectAll();
		
		return roundtrip;
	}
	
	public RoundTrip selectRoundTrip(int roundTripID)
	{
		return roundTripDAO.select(roundTripID);
	}	

}
