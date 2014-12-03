package com.thumbsup.coolname.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolname.entity.Location;

public class LocationDAO extends CRUDManager<Location, Integer> {

	@Override
	public Location insert(Location location) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();
		s.save(location);
		t.commit();
		s.flush();
		Location resultLocation = (Location) s.get(Location.class,
				location.getLocationID());
		s.close();
		return resultLocation;
	}

	@Override
	public Location select(Integer pk) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Location l = (Location) s.get(Location.class, pk);
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> selectAll() {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		List<Location> l = new ArrayList<Location>();
		l = s.createCriteria(Location.class).list();
		return l;
	}

	@Override
	public Location delete(Location location) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();
		s.delete(location);
		transaction.commit();
		s.flush();
		location = (Location) s.get(Location.class, location.getLocationID());
		s.close();
		return location;
	}

	@Override
	public Location update(Location location) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();
		s.update(location);
		transaction.commit();
		s.flush();
		Location resultLocation = (Location) s.get(Location.class,
				location.getLocationID());
		s.close();
		return resultLocation;
	}

	/*
	 * Method goes into the Location table and returns the locations that
	 * correspond to the given RideEntryID
	 */
	public List<Location> findLocationFromRideEntryId(int rideEntryID) {

		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();

		Query query = s
		// .createQuery("select locations from Location location where location.rideEntryID = :parameterRideEntryID");
				.createQuery("FROM Location as l where l.rideEntryID = :parameterRideEntryID");
		query.setParameter("" + "parameterRideEntryID", rideEntryID);
		List<Location> locations = query.list();

		s.flush();
		s.close();
		return locations;
	}
}
