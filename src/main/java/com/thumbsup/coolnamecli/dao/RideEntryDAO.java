package com.thumbsup.coolnamecli.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolnamecli.entity.RideEntry;

public class RideEntryDAO extends CRUDManager<RideEntry, Integer> {

	@Override
	public RideEntry insert(RideEntry entry) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();
		s.save(entry);
		t.commit();
		s.flush();
		RideEntry insertedRide = (RideEntry) s.get(RideEntry.class, entry.getRideEntryID());
		s.close();

		return insertedRide;
	}

	@Override
	public RideEntry select(Integer rideEntryID) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		RideEntry entry = (RideEntry) s.get(RideEntry.class, rideEntryID);
		s.close();

		return entry;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RideEntry> selectAll() {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		List<RideEntry> entryList = new ArrayList<RideEntry>();
		entryList = s.createCriteria(RideEntry.class).list();
		s.close();

		return entryList;
	}

	@Override
	public RideEntry delete(RideEntry entry) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();
		s.delete(entry);
		transaction.commit();
		s.flush();
		RideEntry result = (RideEntry) s.get(RideEntry.class, entry.getRideEntryID());
		s.close();

		return result;
	}

	@Override
	public RideEntry update(RideEntry entry) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();
		s.update(entry);
		transaction.commit();
		RideEntry result = (RideEntry) s.get(RideEntry.class, entry.getRideEntryID());
		s.close();
		return result;
	}

}
