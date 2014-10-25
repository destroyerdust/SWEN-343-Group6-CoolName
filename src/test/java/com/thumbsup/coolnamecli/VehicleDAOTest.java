package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thumbsup.coolnamecli.dao.VehicleDAO;
import com.thumbsup.coolnamecli.entity.User;
import com.thumbsup.coolnamecli.entity.Vehicle;

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
	public void testInsertVehicle() {
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
	public void testDeleteVehicle() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateVehicle() {
		fail("Not yet implemented");
	}

}
