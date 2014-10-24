package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.thumbsup.coolnamecli.dao.UserDAO;
import com.thumbsup.coolnamecli.entity.User;

public class UserDAOTest {
	UserDAO dao = new UserDAO();
	private static User u = new User();
	
	@BeforeClass
	public static void setUp()
	{
		u.setUserName("MyUserNameTest");
		u.setFirstName("John");
		u.setLastName("Tester");
		u.setPassword("1324");
		u.setPasswordSalt("saltTest");
		u.setPhoneNumber("888-8888");
		u.setUserType(2);
	}
	
	@Test
	public void testInsertUser() {
		User insertedUser = dao.insert(u);
		assertTrue(userIsEquals(u, insertedUser));
	}

	@Test
	public void testSelectUser() {
		User selectedUser = dao.select(u.getUserId());
		assertTrue(userIsEquals(u, selectedUser));
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
	
	private boolean userIsEquals(User expected, User actual)
	{
		return (
				(expected.getFirstName().equals(actual.getFirstName())) &&
				(expected.getLastName().equals(actual.getLastName())) &&
				(expected.getUserName().equals(actual.getUserName())) &&
				(expected.getPassword().equals(actual.getPassword())) &&
				(expected.getPasswordSalt().equals(actual.getPasswordSalt())) &&
				(expected.getPhoneNumber().equals(actual.getPhoneNumber())) &&
				(expected.getUserType() == (actual.getUserType()) )
			);
	}

}
