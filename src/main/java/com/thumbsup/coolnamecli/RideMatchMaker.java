package com.thumbsup.coolnamecli;

import java.util.List;

import com.thumbsup.coolnamecli.entity.RideEntry;

/**
 * This class contains methods that match Drivers with Passengers.
 * This class has access to and will spawn sessions from the RideEntryDAO.
 * This class is meant to be invoked by some other object in the runtime.
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
		 * Process:
		 *  1) User the RideEntryDAO to get the full list of RideEntries.
		 *  2) Selectively pick from the RideEntries those that do not have a vehicle ID 
		 *  3) Discriminate the RideEntries by Group and Location
		 * 
		 * Potential code:
		 *  String hql = "FROM RideEntry RE WHERE RE.VehicleID == null";
		 *  Query query = session.createQuery(hql);
		 *  List results = query.list();
		 * */
		
		//return result
		return null;
	}

	/* Match Passengers to Drivers */
	private List<RideEntry> findDriversForPassenger(Passenger p) {
		
		//Please reference the findPassengersForDriver method for how to fill this out.
		return null;
	}
}
