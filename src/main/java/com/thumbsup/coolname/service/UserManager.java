package com.thumbsup.coolname.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.thumbsup.coolname.dao.UserDAO;
import com.thumbsup.coolname.entity.Group;
import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.entity.Vehicle;

public class UserManager {

	private UserDAO userDAO = new UserDAO();

	/**
	 * Creates the user object to send to the userDAO
	 * 
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param passwordSalt
	 * @param phoneNumber
	 * @param userType
	 * @return
	 */
	public User createUser(String userName, String firstName,
			String lastName, String password,
			String phoneNumber, int userType, Vehicle vehicle) {
		
		String passSalt = BCrypt.gensalt();
		String encryptedPass = BCrypt.hashpw(password, passSalt);
		password = null;
		User u = new User();
		u.setUserName(userName);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setPassword(encryptedPass);
		u.setPhoneNumber(phoneNumber);
		u.setPasswordSalt(passSalt);
		u.setUserType(userType);
		if(vehicle != null)
		{
			u.setVehicles(new ArrayList<Vehicle>());
			u.addVehicle(vehicle);
		}
		if(getSalt(userName) != null)
			u = null;
		else
			u = userDAO.insert(u);

		return u;
	}

	/**
	 * Selects the user from the userId and then updates the user's fields
	 * that a user can select
	 * 
	 * @param userId
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param phoneNumber
	 * @param userType
	 */
	public void updateUser(int userId, String userName, String firstName,
			String lastName, String password, String phoneNumber, int userType) {
		
		User u = userDAO.select(userId);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setPassword(password);
		u.setPhoneNumber(phoneNumber);
		u.setUserType(userType);
		
		userDAO.update(u);
	}
	
	public void updateUser(User user)
	{
		userDAO.update(user);
	}

	/**
	 * Selects the user based off the userId and tells the userDAO to delete
	 * 
	 * @param userId
	 */
	public void deleteUser(int userId) {
		
		// Select user to delete
		User u = userDAO.select(userId);
		
		// Delete User
		userDAO.delete(u);

	}

	public User login(String userName, String pass) {
		User u = null;
		String salt =userDAO.getSalt(userName);
		if(salt != null)
		{
			pass = BCrypt.hashpw(pass, salt);
			u = userDAO.login(userName, pass);
		}
		return u;
	}
	
	public String getSalt(String username)
	{
		UserDAO dao = new UserDAO();
		return dao.getSalt(username);
	}

	public User selectUser(int userID)
	{
		return userDAO.select(userID);
	}
	
	public List<Group> getGroupsForUser(int userPrimaryKeyID)
	{
		return userDAO.findGroupForUser(userPrimaryKeyID);
	}
	
	public List<RideEntry> getRideHistoryForUser(int userPrimaryKeyID)
	{
		return userDAO.findRideHistoryForUser(userPrimaryKeyID);
	}
}
