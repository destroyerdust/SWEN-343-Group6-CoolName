package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.dao.UserDAO;
import com.thumbsup.entity.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTest {
	UserDAO dao = new UserDAO();
	private static User entity = new User();
	
	@BeforeClass
	public static void setUp()
	{
		entity.setUserName("MyUserNameTest");
		entity.setFirstName("John");
		entity.setLastName("Tester");
		entity.setPassword("1324");
		entity.setPasswordSalt("saltTest");
		entity.setPhoneNumber("888-8888");
		entity.setUserType(2);
	}
	
	@Test
	public void testA_InsertUser() {
		User insertedUser = dao.insert(entity);
		assertTrue(userIsEquals(entity, insertedUser));
		entity.setUserId(insertedUser.getUserId());
	}

	@Test
	public void testB_SelectUser() {
		User selectedUser = dao.select(entity.getUserId());
		assertTrue(userIsEquals(entity, selectedUser));
	}

	@Test
	public void testC_SelectAllUsers() {
		List<User> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateUser() {
		entity.setPhoneNumber("000-0000");
		User uptadedUser = dao.update(entity);
		assertTrue( userIsEquals(entity, uptadedUser));
	}

	@Test
	public void testE_DeleteUser() {
		assertNull(dao.delete(entity));
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
