package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolnamecli.dao.User_GroupDAO;
import com.thumbsup.coolnamecli.entity.User_Group;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class User_GroupDAOTest {
	private User_GroupDAO dao = new User_GroupDAO();
	private static User_Group entity = new User_Group();
	
	@BeforeClass
	public static void setUpBeforeClass(){
		entity.setGroupID(1);
		entity.setUserID(1);
	}

	@Test
	public void testA_InsertUser_Group() {
		User_Group insertedEntity = dao.insert(entity);
		assertTrue(user_groupIsEquals(entity, insertedEntity));
	}

	@Test
	public void testB_SelectInteger() {
		User_Group result = dao.select(entity.getUser_GroupID());
		assertTrue(user_groupIsEquals(entity, result));
	}

	@Test
	public void testC_SelectAll() {
		List<User_Group> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateUser_Group() {
		entity.setGroupID(2);
		User_Group result = dao.update(entity);
		assertTrue(user_groupIsEquals(entity, result));
	}
	
	@Test
	public void testE_DeleteUser_Group() {
		User_Group result = dao.delete(entity);
		assertNull(result);
	}
	
	private boolean user_groupIsEquals(User_Group expected, User_Group actual)
	{
		return (
				expected.getGroupID() == actual.getGroupID() &&
				expected.getUserID() == actual.getUserID() &&
				expected.getUser_GroupID() == actual.getUser_GroupID()
		);
	}

}
