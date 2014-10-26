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
	public User createUser(String userName, String firstName,
			String lastName, String password, String passwordSalt,
			String phoneNumber, int userType) {

		User u = new User();
		u.setUserName(userName);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setPassword(password);
		u.setPhoneNumber(phoneNumber);
		u.setPasswordSalt(passwordSalt);
		u.setUserType(userType);

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
		return userDAO.login(userName, pass);
	}

}
