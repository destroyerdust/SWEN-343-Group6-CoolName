package com.thumbsup.coolnamecli.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolnamecli.entity.Signup;
import com.thumbsup.coolnamecli.entity.Vehicle;

public class SignupDAO extends CRUDManager<Signup, Integer> {

	@Override
	public Signup insert(Signup sign) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();        
		s.save(sign);
        t.commit();
        s.flush();
        sign = (Signup)s.load(Signup.class, sign);
        s.close();
        
        return sign;
	}

	@Override
	public Signup select(Integer signupID) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Signup sign = (Signup)s.load(Signup.class, signupID);
		s.close();
		
		return sign;
	}

	@Override
	public List<Signup> selectAll() {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
        List<Signup> signupList = new ArrayList<Signup>(); 
		signupList = s.createCriteria(Signup.class).list();              
        s.close();
        
        return signupList;
	}

	@Override
	public Signup delete(Signup sign) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();    	
    	s.delete(sign);
    	transaction.commit();
    	s.flush();
    	sign = (Signup)s.load(Signup.class, sign.getRideOnID());
    	s.close();
    	
    	return sign;
	}

	@Override
	public Signup update(Signup sign) {
    	SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.update(sign);
    	transaction.commit();
    	sign = (Signup) s.load(Signup.class, sign.getRideOnID());
    	s.close();
    	return sign;
	}

}
