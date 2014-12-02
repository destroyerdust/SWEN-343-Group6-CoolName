package com.thumbsup.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thumbsup.coolname.RideMatchMaker;
import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.service.RideEntryManager;

public class RideMatchMakerTest {
	private static User entity = new User();
	private RideMatchMaker maker = new RideMatchMaker(new RideEntryManager());
	
	@BeforeClass
	public static void setUpBeforeClass(){
		entity.setUserName("MyUserNameTest");
		entity.setFirstName("John");
		entity.setLastName("Tester");
		entity.setPassword("1324");
		entity.setPasswordSalt("saltTest");
		entity.setPhoneNumber("888-8888");
		entity.setUserType(2);
	}

	@Test
	public void testFindPassengersForDriver() {
		List<RideEntry> rides = maker.findPassengersForDriver(entity);
		assertTrue(rides.size() > 0);
	}

	@Test
	public void testFindDriversForPassenger() {
		List<RideEntry> rides = maker.findDriversForPassenger(entity);
		assertTrue(rides.size() > 0);
	}

}
