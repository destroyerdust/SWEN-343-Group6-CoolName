package com.thumbsup.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolname.dao.RideEntry_GroupDAO;
import com.thumbsup.coolname.entity.RideEntry_Group;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RideEntry_GroupDAOTest {
	private RideEntry_GroupDAO dao = new RideEntry_GroupDAO();
	private static RideEntry_Group entity = new RideEntry_Group();
	
	@BeforeClass
	public static void setUpBeforeClass(){
		entity.setGroupID(1);
		entity.setRideEntryID(1);
	}

	@Test
	public void testA_InsertRideEntry_Group() {
		RideEntry_Group inserted = dao.insert(entity);
		assertTrue(rideEntry_groupIsEquals(entity, inserted));
	}

	@Test
	public void testB_SelectRideEntry_Group() {
		RideEntry_Group result = dao.select(entity.getRideEntry_GroupID());
		assertTrue(rideEntry_groupIsEquals(entity, result));
	}

	@Test
	public void testC_SelectAll() {
		List<RideEntry_Group> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateRideEntry_Group() {
		entity.setGroupID(2);
		RideEntry_Group result = dao.update(entity);
		assertTrue(rideEntry_groupIsEquals(entity, result));
	}
	
	@Test
	public void testE_DeleteRideEntry_Group() {
		RideEntry_Group result = dao.delete(entity);
		assertNull(result);
	}
	
	private boolean rideEntry_groupIsEquals(RideEntry_Group expected, RideEntry_Group actual)
	{
		return (
				expected.getGroupID() == actual.getGroupID() &&
				expected.getRideEntryID() == actual.getRideEntryID() &&
				expected.getRideEntry_GroupID() == actual.getRideEntry_GroupID()
		);
	}
}
