package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thumbsup.RideMatchMaker;
import com.thumbsup.entity.RideEntry;
import com.thumbsup.entity.User;
import com.thumbsup.service.RideEntryManager;

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
