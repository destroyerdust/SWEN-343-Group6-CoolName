package com.thumbsup.coolnamecli.service;

import com.thumbsup.coolnamecli.dao.UserDAO;
import com.thumbsup.coolnamecli.entity.User;

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
	public Integer createUser(String userName, String firstName,
			String lastName, String password, String passwordSalt,
			String phoneNumber, int userType) {
		int userId = 0;

		User u = new User();
		u.setUserName(userName);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setPassword(password);
		u.setPasswordSalt(passwordSalt);
		u.setPhoneNumber(phoneNumber);
		u.setUserType(userType);

		userDAO.insert(u);

		return userId;
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

}
