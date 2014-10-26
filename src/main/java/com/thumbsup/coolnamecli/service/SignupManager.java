package com.thumbsup.coolnamecli.service;

import com.sun.jmx.snmp.Timestamp;
import com.thumbsup.coolnamecli.dao.SignupDAO;
import com.thumbsup.coolnamecli.entity.Signup;

/**
 * Contributors: Conor Craig
 * 
 * Class owns a SignupDAO and manipulates its functionality.
 * 
 * */
public class SignupManager {

	private SignupDAO sDAO = new SignupDAO();

	public int createSignup(int rideOnId, int userId, int rideEntryId,
			Timestamp time) {

		Signup s = sDAO.select(rideOnId);
		s.setRideOnID(rideOnId);
		s.setUserID(userId);
		s.setRideEntryID(rideEntryId);

		sDAO.insert(s);

		return rideOnId;
	}

	public void updateSignup(int rideOnId, int userId, int rideEntryId,
			Timestamp time) {

		Signup s = sDAO.select(rideOnId);
		s.setRideOnID(rideOnId);
		s.setUserID(userId);
		s.setRideEntryID(rideEntryId);

		sDAO.update(s);
	}

	public void deleteSignup(int rideOnId) {

		// Select user to delete
		Signup s = sDAO.select(rideOnId);

		// Delete User
		sDAO.delete(s);

	}
}