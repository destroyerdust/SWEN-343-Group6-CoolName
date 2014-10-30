package com.thumbsup.coolnamecli.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolnamecli.entity.RideEntry_Group;

public class RideEntry_GroupDAO extends CRUDManager<RideEntry_Group, Integer>{

	@Override
	public RideEntry_Group insert(RideEntry_Group ridegroup) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();
		s.save(ridegroup);
		t.commit();
		s.flush();
		RideEntry_Group resultRideEntry_Group = (RideEntry_Group) s.get(RideEntry_Group.class, ridegroup.getRideEntry_GroupID());
		s.close();
		return resultRideEntry_Group;
	}

	@Override
	public RideEntry_Group select(Integer pk) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		RideEntry_Group rg = (RideEntry_Group) s.get(RideEntry_Group.class, pk);
		s.close();
		return rg;
	}

	@Override
	public List<RideEntry_Group> selectAll() {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		List<RideEntry_Group> rg = new ArrayList<RideEntry_Group>();
		rg = s.createCriteria(RideEntry_Group.class).list();
		s.close();
		return rg;
	}

	@Override
	public RideEntry_Group delete(RideEntry_Group rg) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();
		s.delete(rg);
		transaction.commit();
		s.flush();
		rg = (RideEntry_Group) s.get(RideEntry_Group.class, rg.getRideEntry_GroupID());
		s.close();
		return rg;
	}

	@Override
	public RideEntry_Group update(RideEntry_Group rg) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();
		s.update(rg);
		transaction.commit();
		s.flush();
		RideEntry_Group resultRideEntry_Group = (RideEntry_Group) s.get(RideEntry_Group.class, rg.getRideEntry_GroupID());
		s.close();
		return resultRideEntry_Group;
	}

}
