package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolnamecli.dao.UserDAO;
import com.thumbsup.coolnamecli.entity.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	public void testA_InsertUser() {
		User insertedUser = dao.insert(u);
		assertTrue(userIsEquals(u, insertedUser));
		u.setUserId(insertedUser.getUserId());
	}

	@Test
	public void testB_SelectUser() {
		User selectedUser = dao.select(u.getUserId());
		assertTrue(userIsEquals(u, selectedUser));
	}

	@Test
	public void testE_SelectAllUsers() {
		List<User> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testC_UpdateUser() {
		u.setPhoneNumber("000-0000");
		User uptadedUser = dao.update(u);
		assertTrue( userIsEquals(u, uptadedUser));
	}

	@Test
	public void testD_DeleteUser() {
		assertNull(dao.delete(u));
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
