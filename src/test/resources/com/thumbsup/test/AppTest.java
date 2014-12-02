package com.thumbsup.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserDAOTest.class,
				RideEntryDAOTest.class,
				SignupDAOTest.class,
				VehicleDAOTest.class,
				RideMatchMakerTest.class,
				User_GroupDAOTest.class,
				RideEntry_GroupDAOTest.class,
				LocationDAOTest.class,
				GroupDAOTest.class})
public class AppTest {

}
