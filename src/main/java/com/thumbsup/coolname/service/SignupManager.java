package com.thumbsup.coolname.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.thumbsup.coolname.dao.SignupDAO;
import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.Signup;

/**
 * Contributors: Conor Craig
 * 
 * Class owns a SignupDAO and manipulates its functionality.
 * 
 * */
public class SignupManager {

	private SignupDAO sDAO = new SignupDAO();
	
	public Signup createSignup(int userId, int rideEntryId,
			Timestamp time) {

		Signup s = new Signup();
		s.setUserID(userId);
		s.setRideEntryID(rideEntryId);

		s = sDAO.insert(s);

		return s;
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
	
	public List<Signup> listSignups()
	{
		return sDAO.selectAll();
	}
	
	public List<Signup> selectByRide(RideEntry ride)
	{
		List<Signup> result = sDAO.selectAll();
		List<Signup> toDelete = new ArrayList<Signup>();
		for (Signup signup : result) {
			if(signup.getRideEntryID() != ride.getRideEntryID())
			{
				toDelete.add(signup);
			}
		}
		result.removeAll(toDelete);
		return result;
	}
			

}