package com.thumbsup.coolnamecli;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.thumbsup.coolnamecli.Vehicle;

public class VehicleManager {
	private static SessionFactory factory;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		VehicleManager VM = new VehicleManager();
		
		User user = VM.addUser(1, "Alfred", "Tomcat", "789-654-1230", "Welcome1234");
		
		Integer vmID01 = VM.addVehicle("Toyota", "Corola", 4, "Crappy Car", user);
		
		VM.listVehicles();

		
	}
	
	public User addUser(int userType, String firstName, String lastName, String phoneNumber, String password) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      Integer userId = null;
	      User user = null;
	      
	      try{
	    	  tx = session.beginTransaction();
	    	  user = new User(userType, firstName, lastName, phoneNumber, password);
	    	  userId = (Integer) session.save(user);
	    	  tx.commit();
	      }catch (HibernateException e) {
	          if (tx!=null) tx.rollback();
	          e.printStackTrace(); 
	       }finally {
	          session.close(); 
	       }
		return user;
	}
	
	public Integer addVehicle(String model, String name, int numSeats, String description, User user) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer vehicleId = null;
		try {
			tx = session.beginTransaction();
			Vehicle vehicle = new Vehicle(model, name, numSeats, description, user);
			vehicleId = (Integer) session.save(vehicle);
			tx.commit();
		} catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close();
	      }
		return vehicleId;
	}

	public void listVehicles() {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	List vehicles = session.createQuery("FROM Vehicle").list();
	    	for (Iterator iterator = vehicles.iterator(); iterator.hasNext();){
	    		Vehicle vehicle = (Vehicle) iterator.next();
	    		System.out.println("Model: " + vehicle.getModel());
	    		System.out.println("Name: " + vehicle.getName());
	    		System.out.println("NumSeats: " + vehicle.getNumSeats());
	    		System.out.println("Description: " + vehicle.getDescription());
	    		User user = vehicle.getUser();
	    		System.out.println("User ");
	    		System.out.println("\tUserType: " + user.getUserType());
	    		System.out.println("\tFirst Name: " + user.getFirstName());
	    		System.out.println("\tLast Name: " + user.getLastName());
	    		System.out.println("\tPhone Number: " + user.getPhoneNumber());
	    	}
	    	tx.commit();
	    } catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    	e.printStackTrace();
	    } finally {
	    	session.close();
	    }

	}
	
	public void deleteVehicle(Integer vehicleId) {
		 Session session = factory.openSession();
	     Transaction tx = null;
	     try {
	    	 tx = session.beginTransaction();
	    	 Vehicle vehicle = (Vehicle) session.get(Vehicle.class, vehicleId);
	    	 session.delete(vehicle);;
	    	 tx.commit();
	     }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
}


