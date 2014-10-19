package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thumbsup.coolnamecli.dao.UserDAO;
import com.thumbsup.coolnamecli.entity.User;

public class UserDAOTest {

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
		UserDAO.insertUser(u);
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
