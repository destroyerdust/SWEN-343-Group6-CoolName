package com.thumbsup.coolnamecli.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolnamecli.dao.SessionFactory;
import com.thumbsup.coolnamecli.entity.Group;
import com.thumbsup.coolnamecli.entity.Location;
import com.thumbsup.coolnamecli.entity.User;

public class LocationDAO extends CRUDManager<Location, Integer> {

	@Override
	public Location insert(Location location) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();        
		s.save(location);
        t.commit();
        s.flush();
        Location resultLocation = (Location)s.get(Location.class, location.getGroupID());
        s.close();
        return resultLocation;
	}

	@Override
	public Location select(Integer pk) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Location l = (Location)s.get(Location.class, pk);
		return l;
	}

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
    	location = (Location)s.get(Location.class, location.getIdLocation());
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
    	Location resultLocation = (Location) s.get(Location.class, location.getIdLocation());
    	s.close();
    	return resultLocation;
	}

}
