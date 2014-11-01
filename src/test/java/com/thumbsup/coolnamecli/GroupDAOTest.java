package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolnamecli.dao.GroupDAO;
import com.thumbsup.coolnamecli.entity.Group;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupDAOTest {
	private GroupDAO dao = new GroupDAO();
	private static Group entity = new Group();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity.setName("Name Test");
	}

	@Test
	public void testA_InsertGroup() {
		Group result = dao.insert(entity);
		assertTrue(groupIsEquals(entity, result));
	}

	@Test
	public void testB_SelectGroup() {
		Group result = dao.select(entity.getGroupID());
		assertTrue(groupIsEquals(entity, result));
	}

	@Test
	public void testC_SelectAll() {
		List<Group> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateGroup() {
		entity.setName("Name modified");
		Group result = dao.update(entity);
		assertTrue(groupIsEquals(entity, result));
	}
	
	@Test
	public void testE_DeleteGroup() {
		Group result = dao.delete(entity);
		assertNull(result);
	}
	
	private boolean groupIsEquals(Group expected, Group actual)
	{
		return (
				expected.getGroupID() == actual.getGroupID() &&
				expected.getName().equals(actual.getName())
		);
	}

}
