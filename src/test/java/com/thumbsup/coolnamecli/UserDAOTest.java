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
	private static User testedUser = new User();
	
	@BeforeClass
	public static void setUp()
	{
		testedUser.setUserName("MyUserNameTest");
		testedUser.setFirstName("John");
		testedUser.setLastName("Tester");
		testedUser.setPassword("1324");
		testedUser.setPasswordSalt("saltTest");
		testedUser.setPhoneNumber("888-8888");
		testedUser.setUserType(2);
	}
	
	@Test
	public void testA_InsertUser() {
		User insertedUser = dao.insert(testedUser);
		assertTrue(userIsEquals(testedUser, insertedUser));
		testedUser.setUserId(insertedUser.getUserId());
	}

	@Test
	public void testB_SelectUser() {
		User selectedUser = dao.select(testedUser.getUserId());
		assertTrue(userIsEquals(testedUser, selectedUser));
	}

	@Test
	public void testC_SelectAllUsers() {
		List<User> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateUser() {
		testedUser.setPhoneNumber("000-0000");
		User uptadedUser = dao.update(testedUser);
		assertTrue( userIsEquals(testedUser, uptadedUser));
	}

	@Test
	public void testE_DeleteUser() {
		assertNull(dao.delete(testedUser));
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
