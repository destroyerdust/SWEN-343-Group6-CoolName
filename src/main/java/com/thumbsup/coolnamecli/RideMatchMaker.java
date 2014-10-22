package com.thumbsup.coolnamecli;

import java.util.List;

import com.thumbsup.coolnamecli.entity.RideEntry;

/**
 * 
 * Interpret this class to be the holder of domain logic that pertains to
 * matching users within the system.
 * 
 * */
public class RideMatchMaker {

	/* private RideEntryDAO = null */

	public RideMatchMaker(/* RideEntryDAO where */) {
		// setup RideEntryDAO
		// this.RideEntryDAO = red
	}

	/**
	 * Match Driver to Passengers
	 * 
	 * @param Driver
	 *            d : The driver in the system that needs to be matched with
	 *            Passengers
	 * 
	 * @return List<RideEntry> : A list of RideEntries that match the parameters
	 *         of the Driver. The list expresses the Passengers within the
	 *         system that fit and need the Driver.
	 * 
	 * */
	private List<RideEntry> findPassengersForDriver(Driver d) {
		//Hard-coded SQL query (Hibernate form)
		/*
		 * 
		 * 
		 * 
		 * */
		
		//execute query
		
		//parse results
		
		//return result
		return null;
	}

	/* Match Passengers to Drivers */
	private List<RideEntry> findDriversForPassenger(Passenger p) {
		return null;
	}
}
