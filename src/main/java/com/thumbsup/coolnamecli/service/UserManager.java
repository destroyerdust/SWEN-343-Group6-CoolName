package com.thumbsup.coolnamecli.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.thumbsup.coolnamecli.entity.User;

public class UserManager {
	private static SessionFactory factory;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		UserManager MU = new UserManager();
		
		@SuppressWarnings("unused")
		Integer UserID1 = MU.addUser(0, "Bob", "Builder", "5555555555", "BobBuilder01");
		Integer UserID2 = MU.addUser(0, "Clark", "Clenton", "5555555552", "1231231");
		
		//MU.listUsers();
		
		//MU.deleteUser(UserID2);
		
		MU.listUsers();
		
	}
	
	
	public Integer addUser(int userType, String fname, String lname, String phoneNumber, String password) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userId = null;
		try {
			tx = session.beginTransaction();
			User user = new User(userType, fname, lname, phoneNumber, password);
			userId = (Integer) session.save(user);
			tx.commit();
		} catch  (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return userId;
	}
	
	public void listUsers() {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<User> users = session.createQuery("FROM User U where U.lastName = 'Builder'").list();
			for (Iterator<User> iterator = users.iterator(); iterator.hasNext();){
				User user = (User) iterator.next();
				System.out.println("First Name: " + user.getFirstName());
				System.out.println("Last Name: " + user.getLastName());
				System.out.println("Phone Number: " + user.getPhoneNumber());
			}
			tx.commit();
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	
	public void deleteUser(Integer UserId) {
		 Session session = factory.openSession();
	     Transaction tx = null;
	     try {
	    	 tx = session.beginTransaction();
	    	 User user = (User) session.get(User.class, UserId);
	    	 session.delete(user);;
	    	 tx.commit();
	     }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}

}
