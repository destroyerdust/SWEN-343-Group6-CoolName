package com.thumbsup.coolname.service;

import java.sql.Timestamp;
import java.util.List;

import com.thumbsup.coolname.dao.RideEntry_GroupDAO;
import com.thumbsup.coolname.dao.SignupDAO;
import com.thumbsup.coolname.dao.User_GroupDAO;
import com.thumbsup.coolname.entity.RideEntry_Group;
import com.thumbsup.coolname.entity.Signup;
import com.thumbsup.coolname.entity.User_Group;

public class RideEntryGroupManager {

	private RideEntry_GroupDAO regDAO = new RideEntry_GroupDAO();
	
	public RideEntry_Group createSignup(int rideEntryId, int groupId,
			Timestamp time) {

		RideEntry_Group reg = new RideEntry_Group();
		
		reg.setRideEntryID(rideEntryId);
		reg.setGroupID(groupId);

		reg = regDAO.insert(reg);

		return reg;
	}

	public void updateSignup(int rideEntry_GroupID, int rideEntryId, int groupId,
			Timestamp time) {

		RideEntry_Group reg = regDAO.select(rideEntry_GroupID);
		reg.setRideEntry_GroupID(rideEntry_GroupID);
		reg.setRideEntryID(rideEntryId);
		reg.setGroupID(groupId);

		regDAO.update(reg);
	}

	public void deleteSignup(int rideEntry_GroupID) {

		// Select user to delete
		RideEntry_Group reg = regDAO.select(rideEntry_GroupID);

		// Delete User
		regDAO.delete(reg);

	}
	
	public List<RideEntry_Group> listRideEntryGroups()
	{
		List<RideEntry_Group> rideEntryGroups = regDAO.selectAll();
		return rideEntryGroups;
	}

}