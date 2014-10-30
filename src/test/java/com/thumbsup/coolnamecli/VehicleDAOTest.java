package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolnamecli.dao.VehicleDAO;
import com.thumbsup.coolnamecli.entity.User;
import com.thumbsup.coolnamecli.entity.Vehicle;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleDAOTest {
	private VehicleDAO dao = new VehicleDAO();
	private static Vehicle entity = new Vehicle();
	
	@BeforeClass
	public static void setUpBeforeClass(){
		entity.setName("Car test");
		entity.setModel("Model Test");
		entity.setDescription("Description Test");
		entity.setNumSeats(3);
		User driver = new User();
		driver.setUserId(1);
		driver.setUserType(2);
		entity.setUser(driver);
	}

	@Test
	public void testA_InsertVehicle() {
		Vehicle inserted = dao.insert(entity);
		assertTrue(vehicleIsEquals(entity, inserted));
	}

	@Test
	public void testB_Select() {
		Vehicle result = dao.select(entity.getVehicleID());
		assertTrue(vehicleIsEquals(entity, result));
	}

	@Test
	public void testC_SelectAll() {
		List<Vehicle> result = dao.selectAll();
		assertTrue(result.size() > 0);
	}

	@Test
	public void testD_UpdateVehicle() {
		entity.setDescription("Description Changed");
		Vehicle result = dao.update(entity);
		assertTrue(vehicleIsEquals(entity, result));
	}
	
	@Test
	public void testE_DeleteVehicle() {
		Vehicle result = dao.delete(entity);
		assertNull(result);
	}

	private boolean vehicleIsEquals(Vehicle expected, Vehicle actual)
	{
		return (
				actual.getDescription().equals(expected.getDescription()) &&
				actual.getModel().equals(expected.getModel()) &&
				actual.getName().equals(expected.getName()) &&
				actual.getNumSeats() == expected.getNumSeats() &&
				actual.getUser().getUserId() == expected.getUser().getUserId()
		);
	}
	
}
