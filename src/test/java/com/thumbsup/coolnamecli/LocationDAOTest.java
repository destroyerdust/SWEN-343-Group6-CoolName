package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolnamecli.dao.LocationDAO;
import com.thumbsup.coolnamecli.entity.Location;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocationDAOTest {
	private LocationDAO dao = new LocationDAO();
	private static Location entity = new Location();
	
	@BeforeClass
	public static void setUpBeforeClass(){
		entity.setGroupID(1);
		entity.setArea("Area Test");
	}

	@Test
	public void testA_InsertLocation() {
		Location inserted = dao.insert(entity);
		assertTrue(locationIsEquals(entity, inserted));
	}

	@Test
	public void testB_SelectInteger() {
		Location result = dao.select(entity.getIdLocation());
		assertTrue(locationIsEquals(entity, result));
	}

	@Test
	public void testC_SelectAll() {
		List<Location> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateLocation() {
		entity.setArea("Area modified");
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
				expected.getArea().equals(actual.getArea()) &&
				expected.getGroupID() == actual.getGroupID() &&
				expected.getIdLocation() == actual.getIdLocation()
		);
	}

}
