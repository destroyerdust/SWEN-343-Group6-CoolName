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
	private static RideEntry entity = new RideEntry();
	
	@BeforeClass
	public static void setUpBeforeClass(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, 0);
		entity.setCreationTimestamp(new Timestamp(cal.getTime().getTime()));
		entity.setDestination("DestinationTest");
		cal.add(Calendar.HOUR, 2);
		entity.setEndTime(new Timestamp(cal.getTime().getTime()));
		entity.setMapUri("URI TEST");
		entity.setName("Ride Name Test");
		entity.setSource("SourceTest");
		entity.setStartTime(new Timestamp(cal.getTime().getTime()));
		Vehicle v = new Vehicle();
		v.setVehicleID(1);
		entity.setVehicle(v);
	}

	@Test
	public void testA_InsertRideEntry() {
		RideEntry insertedRide = dao.insert(entity);
		assertTrue(rideIsEquals(entity, insertedRide));
		entity.setRideEntryID(insertedRide.getRideEntryID());
	}

	@Test
	public void testB_SelectRideEntry() {
		RideEntry result = dao.select(entity.getRideEntryID());
		assertTrue(rideIsEquals(entity, result));
	}

	@Test
	public void testC_SelectAllRides() {
		List<RideEntry> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateRideEntry() {
		entity.setDestination("Destination Changed");
		RideEntry updated = dao.update(entity);
		assertTrue(rideIsEquals(entity, updated));
	}
	
	@Test
	public void testE_DeleteRideEntry() {
		RideEntry result = dao.delete(entity);
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
