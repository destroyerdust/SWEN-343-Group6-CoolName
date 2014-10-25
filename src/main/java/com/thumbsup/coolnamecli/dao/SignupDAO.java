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
        Signup result = (Signup)s.get(Signup.class, sign.getRideOnID());
        s.close();
        
        return result;
	}

	@Override
	public Signup select(Integer signupID) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Signup result = (Signup)s.get(Signup.class, signupID);
		s.close();
		
		return result;
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
    	Signup result = (Signup)s.get(Signup.class, sign.getRideOnID());
    	s.close();
    	
    	return result;
	}

	@Override
	public Signup update(Signup sign) {
    	SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.update(sign);
    	transaction.commit();
    	Signup result = (Signup) s.get(Signup.class, sign.getRideOnID());
    	s.close();
    	return result;
	}

}
