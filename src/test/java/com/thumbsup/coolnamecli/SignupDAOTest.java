package com.thumbsup.coolnamecli;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thumbsup.coolnamecli.dao.SignupDAO;
import com.thumbsup.coolnamecli.entity.Signup;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignupDAOTest {
	private SignupDAO dao = new SignupDAO();
	private static Signup entity = new Signup();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, 0);
		entity.setRideEntryID(1);
		entity.setTimestamp(cal.getTime());
		entity.setUserID(1);
	}

	@Test
	public void testA_InsertSignup() {
		Signup insertedEntity = dao.insert(entity);
		signIsEqual(entity, insertedEntity);
	}

	@Test
	public void testB_Select() {
		Signup result = dao.select(entity.getRideOnID());
		signIsEqual(entity, result);
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSignup() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSignup() {
		fail("Not yet implemented");
	}
	
	private boolean signIsEqual(Signup expected, Signup actual)
	{
		return (
			actual.getRideEntryID() == expected.getRideEntryID() &&
			actual.getTimestamp().compareTo(expected.getTimestamp()) == 0 &&
			actual.getUserID() == expected.getUserID()
		);
	}

}
