package com.thumbsup.coolname.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.thumbsup.coolname.entity.User;

public class UserDAO extends CRUDManager<User, Integer> {

	@SuppressWarnings("rawtypes")
	public User login(String userName, String pass) {
		User u;
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		// Access DB
		String hql = "FROM User AS u WHERE u.userName = '" + userName + "' AND u.password = '"+ pass + "'";
		Query query = s.createQuery(hql);
		List results = query.list(); // Query DB

		// Create user from DB result
		if(results.size() == 0){
			System.err.println("Invalid login credentials");
			return null;
		}
		u = (User) results.get(0);
		// return user
		s.flush();
		s.close();
		return u;
	}
	
	public String getSalt(String username)
	{
		String salt = null;
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Criteria criteria = s.createCriteria(User.class);
		User u = (User) criteria.add(Restrictions.eq("userName", username))
		                             .uniqueResult();
		if( u != null)
			salt = u.getPasswordSalt();
		return salt;
	}

	@Override
	public User insert(User u) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();
		s.save(u);
		t.commit();
		s.flush();
		User resultUser = (User) s.get(User.class, u.getUserId());
		s.close();
		return resultUser;
	}

	@Override
	public User select(Integer pk) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		User u = (User) s.get(User.class, pk);
		s.close();
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAll() {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		List<User> u = new ArrayList<User>();
		u = s.createCriteria(User.class).list();
		s.close();
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
		user = (User) s.get(User.class, user.getUserId());
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
		s.flush();
		User resultUser = (User) s.get(User.class, user.getUserId());
		s.close();
		return resultUser;
	}
}
