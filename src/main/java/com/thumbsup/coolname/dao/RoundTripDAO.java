package com.thumbsup.coolname.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolname.dao.SessionFactory;
import com.thumbsup.coolname.entity.RoundTrip;

public class RoundTripDAO extends CRUDManager<RoundTrip, Integer> {

	@Override
	public RoundTrip insert(RoundTrip roundtrip) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();        
		s.save(roundtrip);
        t.commit();
        s.flush();
        RoundTrip resultRoundTrip = (RoundTrip)s.get(RoundTrip.class, roundtrip.getRoundTripID());
        s.close();
        return resultRoundTrip;
	}

	@Override
	public RoundTrip select(Integer pk) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		RoundTrip l = (RoundTrip)s.get(RoundTrip.class, pk);
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoundTrip> selectAll() {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		List<RoundTrip> l = new ArrayList<RoundTrip>();
        l = s.createCriteria(RoundTrip.class).list();
		return l;
	}

	@Override
	public RoundTrip delete(RoundTrip roundtrip) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.delete(roundtrip);
    	transaction.commit();
    	s.flush();
    	roundtrip = (RoundTrip)s.get(RoundTrip.class, roundtrip.getRoundTripID());
    	s.close();
    	return roundtrip;
	}

	@Override
	public RoundTrip update(RoundTrip roundtrip) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.update(roundtrip);
    	transaction.commit();
    	s.flush();
    	RoundTrip resultRoundTrip = (RoundTrip) s.get(RoundTrip.class, roundtrip.getRoundTripID());
    	s.close();
    	return resultRoundTrip;
	}

}
