package com.thumbsup.coolnamecli.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolnamecli.entity.RideEntry;

public class RideEntryDAO extends CRUDManager<RideEntry, Integer>
{
	private static SessionFactory SessionFactory;

	@Override
	public RideEntry insert(RideEntry entry)
	{
		Session s = SessionFactory.getSession();
		Transaction t = s.beginTransaction();
		s.save(entry);
		t.commit();
		s.flush();
		entry = (RideEntry)s.load(RideEntry.class, entry);
        s.close();
        
        return entry;
	}

	@Override
	public RideEntry select(Integer rideEntryID)
	{
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		RideEntry entry = (RideEntry)s.load(RideEntry.class, rideEntryID);
		s.close();
		
		return entry;
	}

	@Override
	public List<RideEntry> selectAll()
	{
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
        List<RideEntry> entryList = new ArrayList<RideEntry>(); 
		entryList = s.createCriteria(RideEntry.class).list();              
        s.close();
        
        return entryList;
	}

	@Override
	public RideEntry delete(RideEntry entry)
	{
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();    	
    	s.delete(entry);
    	transaction.commit();
    	s.flush();
    	entry = (RideEntry)s.load(RideEntry.class, entry.getRideEntryID());
    	s.close();
    	
    	return entry;
	}

	@Override
	public RideEntry update(RideEntry entry)
	{
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.update(entry);
    	transaction.commit();
    	entry = (RideEntry) s.load(RideEntry.class, entry.getRideEntryID());
    	s.close();
    	return entry;
	}
	

}
