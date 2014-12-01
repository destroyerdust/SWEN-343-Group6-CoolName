package com.thumbsup.coolname.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolname.entity.Group;
import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.User;

public class GroupDAO extends CRUDManager<Group, Integer>{
    
	@Override
	public Group insert(Group g) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();        
		s.save(g);
        t.commit();
        s.flush();
        Group resultGroup = (Group)s.get(Group.class, g.getGroupID());
        s.close();
        return resultGroup;
	}

	@Override
	public Group select(Integer pk) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Group g = (Group)s.get(Group.class, pk);
		return g;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> selectAll() {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		List<Group> g = new ArrayList<Group>();
        g = s.createCriteria(Group.class).list();
		return g;
	}

	@Override
	public Group delete(Group group) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.delete(group);
    	transaction.commit();
    	s.flush();
    	group = (Group)s.get(Group.class, group.getGroupID());
    	s.close();
    	return group;
	}

	@Override
	public Group update(Group group) {
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.update(group);
    	transaction.commit();
    	s.flush();
    	Group resultGroup = (Group) s.get(Group.class, group.getGroupID());
    	s.close();
    	return resultGroup;
	}
	
	public List<RideEntry> findRideEntriesForGroup(Integer groupPrimaryKeyID) {

		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();

		Query query = s.createQuery("select re from RideEntry_Group reg, RideEntry re where reg.groupID = :groupID and re.rideEntryID = reg.rideEntryID");
		query.setParameter(""
				+ "groupID", groupPrimaryKeyID);
		List<RideEntry> relatedRideEntries = query.list();

		s.flush();
		s.close();
		return relatedRideEntries;
	}

	public List<User> findUsersForGroup(Integer groupPrimaryKeyID)
	{
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();

		Query query = s.createQuery("select u from User_Group ug, User u where ug.groupID = :groupID and u.userId = ug.userID");
		query.setParameter("" + "groupID", groupPrimaryKeyID);
		List<User> relatedUsers = query.list();

		s.flush();
		s.close();
		return relatedUsers;
	}
}
