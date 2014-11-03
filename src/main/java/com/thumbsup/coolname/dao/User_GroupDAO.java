package com.thumbsup.coolname.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolname.entity.User_Group;

public class User_GroupDAO extends CRUDManager<User_Group, Integer>{

	@Override
	public User_Group insert(User_Group usergroup) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();
		s.save(usergroup);
		t.commit();
		s.flush();
		User_Group resultUser_Group = (User_Group) s.get(User_Group.class, usergroup.getUser_GroupID());
		s.close();
		return resultUser_Group;
	}

	@Override
	public User_Group select(Integer pk) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		User_Group ug = (User_Group) s.get(User_Group.class, pk);
		s.close();
		return ug;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_Group> selectAll() {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		List<User_Group> ug = new ArrayList<User_Group>();
		ug = s.createCriteria(User_Group.class).list();
		s.close();
		return ug;
	}

	@Override
	public User_Group delete(User_Group ug) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();
		s.delete(ug);
		transaction.commit();
		s.flush();
		ug = (User_Group) s.get(User_Group.class, ug.getUser_GroupID());
		s.close();
		return ug;
	}

	@Override
	public User_Group update(User_Group ug) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();
		s.update(ug);
		transaction.commit();
		s.flush();
		User_Group resultUser_Group = (User_Group) s.get(User_Group.class, ug.getUser_GroupID());
		s.close();
		return resultUser_Group;
	}

}
