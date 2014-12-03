package com.thumbsup.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolname.dao.LocationDAO;
import com.thumbsup.coolname.entity.Location;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocationDAOTest {
	private LocationDAO dao = new LocationDAO();
	private static Location entity = new Location();
	
	@BeforeClass
	public static void setUpBeforeClass(){
		entity.setTitle("TestingSuite");
		entity.setLatitude(0);
		entity.setLongitude(0);
		entity.setRideEntryID(1);
	}

	@Test
	public void testA_InsertLocation() {
		Location inserted = dao.insert(entity);
		assertTrue(locationIsEquals(entity, inserted));
	}

	@Test
	public void testB_SelectLocation() {
		Location result = dao.select(entity.getLocationID());
		assertTrue(locationIsEquals(entity, result));
	}

	@Test
	public void testC_SelectAll() {
		List<Location> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateLocation() {
		entity.setTitle("Area modified");
		Location result = dao.update(entity);
		assertTrue(locationIsEquals(entity, result));
	}
	
	@Test
	public void testE_DeleteLocation() {
		Location result = dao.delete(entity);
		assertNull(result);
	}
	
	private boolean locationIsEquals(Location expected, Location actual)
	{
		return(
				expected.getTitle().equals(actual.getTitle()) &&
				expected.getLatitude() == actual.getLatitude() &&
				expected.getLongitude() == actual.getLongitude()
		);
	}

}
