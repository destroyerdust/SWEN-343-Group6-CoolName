package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolnamecli.dao.RideEntryDAO;
import com.thumbsup.coolnamecli.entity.RideEntry;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RideEntryDAOTest {
	RideEntryDAO dao = new RideEntryDAO();
	RideEntry testedRideEntry = new RideEntry();
	
	@BeforeClass
	public static void setUpBeforeClass(){
	}

	@Test
	public void testInsertRideEntry() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRideEntry() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRideEntry() {
		fail("Not yet implemented");
	}

}
