package com.thumbsup.coolnamecli.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolnamecli.dao.SessionFactory;
import com.thumbsup.coolnamecli.entity.User;

public class UserDAO extends CRUDManager<User, Integer>{
    
	@Override
	public User insert(User u) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();        
		s.save(u);
        t.commit();
        s.flush();
        u = (User)s.get(User.class, u.getUserId());
        s.close();
        return u;
	}

	@Override
	public User select(Integer pk) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		User u = (User)s.load(User.class, pk);
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAll() {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		List<User> u = new ArrayList<User>();
        u = s.createCriteria(User.class).list();
		return u;
	}

	@Override
	public User delete(User user) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.delete(user);
    	transaction.commit();
    	s.flush();
    	user = (User)s.load(User.class, user.getUserName());
    	s.close();
    	return user;
	}

	@Override
	public User update(User user) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.update(user);
    	transaction.commit();
    	user = (User) s.load(User.class, user.getUserName());
    	s.close();
    	return user;
	}
}
