package com.thumbsup.coolname;

import java.util.ArrayList;
import java.util.List;

import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.service.RideEntryManager;

/**
 * This class contains methods that match Drivers with Passengers. This class
 * has access to and will invoke the RideEntryManger. This class is a repository
 * for logic and query-results parsing; it is meant to be invoked by some other
 * object in the runtime.
 * 
 * */
public class RideMatchMaker {

	private RideEntryManager rem;

	public RideMatchMaker(RideEntryManager rem) {
		this.rem = rem;
	}

	/**
	 * Match One Driver to many Passenger RideEntries
	 * 
	 * @param User
	 *            driver : The driver in the system that needs to be matched
	 *            with Passengers
	 * 
	 * @return List<RideEntry> : A list of RideEntries that match the parameters
	 *         of the Driver. The list expresses the Passengers within the
	 *         system that fit and need the Driver.
	 * 
	 * */
	public List<RideEntry> findPassengersForDriver(User driver) {

		List<RideEntry> results = rem.listRideEntries();

		// parse results (destructively modify)
		// Remove all RideEntry objects that actually have a Vehicle already.
		// Intuition: RideEntries without Vehicles are simply passengers that
		// don't have a driver yet.
		for (int i = 0; i < results.size(); i++) {
			if (results.get(i).getVehicle() != null) {
				results.remove(i);
			}
		}

		return results;
	}

	/**
	 * Match One Passenger to many Driver RideEntries
	 * 
	 * @param User
	 *            passenger : The driver in the system that needs to be matched
	 *            with Passengers
	 * 
	 * @return List<RideEntry> : A list of RideEntries that match the parameters
	 *         of the Passenger. The list expresses the Drivers within the
	 *         system that fit and need the Passenger.
	 * 
	 * */
	public List<RideEntry> findDriversForPassenger(User passenger) {

		List<RideEntry> results = rem.listRideEntries();

		// parse results (destructively modify)
		// Remove all RideEntry objects that don't have a Vehicle already.
		// Intuition: RideEntries with Vehicles are Drivers that are looking for
		// Passengers
		List<RideEntry> toDelete = new ArrayList<RideEntry>();
		for (RideEntry re : results) {
			if (re.getVehicle() == null) {
				toDelete.add(re);
			}
		}
		results.removeAll(toDelete);

		return results;
	}
}
