package com.thumbsup.coolnamecli;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserDAOTest.class,
				RideEntryDAOTest.class,
				SignupDAOTest.class,
				VehicleDAOTest.class})
public class AppTest {

}
