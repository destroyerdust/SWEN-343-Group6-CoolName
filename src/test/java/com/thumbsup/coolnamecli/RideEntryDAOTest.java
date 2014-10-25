package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolnamecli.dao.RideEntryDAO;
import com.thumbsup.coolnamecli.entity.RideEntry;
import com.thumbsup.coolnamecli.entity.Vehicle;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RideEntryDAOTest {
	private RideEntryDAO dao = new RideEntryDAO();
	private static RideEntry testedRideEntry = new RideEntry();
	
	@BeforeClass
	public static void setUpBeforeClass(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, 0);
		testedRideEntry.setCreationTimestamp(new Timestamp(cal.getTime().getTime()));
		testedRideEntry.setDestination("DestinationTest");
		cal.add(Calendar.HOUR, 2);
		testedRideEntry.setEndTime(new Timestamp(cal.getTime().getTime()));
		testedRideEntry.setMapUri("URI TEST");
		testedRideEntry.setName("Ride Name Test");
		testedRideEntry.setSource("SourceTest");
		testedRideEntry.setStartTime(new Timestamp(cal.getTime().getTime()));
		Vehicle v = new Vehicle();
		v.setVehicleID(1);
		testedRideEntry.setVehicle(v);
	}

	@Test
	public void testA_InsertRideEntry() {
		RideEntry insertedRide = dao.insert(testedRideEntry);
		assertTrue(rideIsEquals(testedRideEntry, insertedRide));
		testedRideEntry.setRideEntryID(insertedRide.getRideEntryID());
	}

	@Test
	public void testB_SelectRideEntry() {
		RideEntry result = dao.select(testedRideEntry.getRideEntryID());
		assertTrue(rideIsEquals(testedRideEntry, result));
	}

	@Test
	public void testC_SelectAllRides() {
		List<RideEntry> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateRideEntry() {
		testedRideEntry.setDestination("Destination Changed");
		RideEntry updated = dao.update(testedRideEntry);
		assertTrue(rideIsEquals(testedRideEntry, updated));
	}
	
	@Test
	public void testE_DeleteRideEntry() {
		RideEntry result = dao.delete(testedRideEntry);
		assertNull(result);
	}
	
	private boolean rideIsEquals(RideEntry expected, RideEntry actual)
	{
		return (
			expected.getCreationTimestamp().compareTo(actual.getCreationTimestamp()) == 0 &&
			expected.getDestination().equals(actual.getDestination()) &&
			expected.getEndTime().compareTo(actual.getEndTime()) == 0 &&
			expected.getMapUri().equals(actual.getMapUri()) &&
			expected.getName().equals(actual.getName()) &&
			expected.getSource().equals(actual.getSource()) &&
			expected.getStartTime().compareTo(actual.getStartTime()) == 0 &&
			(expected.getVehicle().getVehicleID()) == (actual.getVehicle().getVehicleID())
		);
	}

}
