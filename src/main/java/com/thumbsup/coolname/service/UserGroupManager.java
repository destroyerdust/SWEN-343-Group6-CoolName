package com.thumbsup.coolname.service;

import java.sql.Timestamp;
import java.util.List;

import com.thumbsup.coolname.dao.SignupDAO;
import com.thumbsup.coolname.dao.User_GroupDAO;
import com.thumbsup.coolname.entity.Signup;
import com.thumbsup.coolname.entity.User_Group;

public class UserGroupManager {

	private User_GroupDAO ugDAO = new User_GroupDAO();
	
	public User_Group createSignup(int userId, int groupId,
			Timestamp time) {

		User_Group ug = new User_Group();
		
		ug.setUserID(userId);
		ug.setGroupID(groupId);

		ug = ugDAO.insert(ug);

		return ug;
	}

	public void updateSignup(int user_GroupID, int userId, int groupId,
			Timestamp time) {

		User_Group ug = ugDAO.select(user_GroupID);
		ug.setUser_GroupID(user_GroupID);
		ug.setUserID(userId);
		ug.setGroupID(groupId);

		ugDAO.update(ug);
	}

	public void deleteSignup(int user_GroupID) {

		// Select user to delete
		User_Group ug = ugDAO.select(user_GroupID);

		// Delete User
		ugDAO.delete(ug);

	}
	
	public List<User_Group> listUserGroups()
	{
		List<User_Group> userGroups = ugDAO.selectAll();
		return userGroups;
	}

}