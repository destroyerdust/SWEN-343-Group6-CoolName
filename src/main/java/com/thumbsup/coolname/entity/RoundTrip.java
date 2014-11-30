package com.thumbsup.coolname.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Location database table.
 * 
 */
@Entity
@NamedQuery(name = "RoundTrip.findAll", query = "SELECT rt FROM RoundTrip rt")
public class RoundTrip implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int RoundTripID;

	private int StartRideEntryID;
	
	private int EndRideEntryID;
	

	public RoundTrip() {
	}
	
	public int getRoundTripID() {
		return RoundTripID;
	}


	public void setRoundTripID(int roundTripID) {
		RoundTripID = roundTripID;
	}


	public int getStartRideEntryID() {
		return StartRideEntryID;
	}


	public void setStartRideEntryID(int startRideEntryID) {
		StartRideEntryID = startRideEntryID;
	}


	public int getEndRideEntryID() {
		return EndRideEntryID;
	}


	public void setEndRideEntryID(int endRideEntryID) {
		EndRideEntryID = endRideEntryID;
	}


	
}