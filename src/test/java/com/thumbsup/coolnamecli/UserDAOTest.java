package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thumbsup.coolnamecli.dao.UserDAO;
import com.thumbsup.coolnamecli.entity.User;

public class UserDAOTest {
	UserDAO dao = new UserDAO();
	
	@Test
	public void testInsertUser() {
		User u = new User();
		u.setUserName("MyUserNameTest");
		u.setFirstName("John");
		u.setLastName("Tester");
		u.setPassword("1324");
		u.setPasswordSalt("saltTest");
		u.setPhoneNumber("888-8888");
		u.setUserType(2);
		User insertedUser = dao.insert(u);
		System.out.println("TEST");
		assertTrue(
					(u.getFirstName().equals(insertedUser.getFirstName())) &&
					(u.getLastName().equals(insertedUser.getLastName())) &&
					(u.getUserName().equals(insertedUser.getUserName())) &&
					(u.getPassword().equals(insertedUser.getPassword())) &&
					(u.getPasswordSalt().equals(insertedUser.getPasswordSalt())) &&
					(u.getPhoneNumber().equals(insertedUser.getPhoneNumber())) &&
					(u.getUserType() == (insertedUser.getUserType()) )
				);
	}

	@Test
	public void testSelectUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAllUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
