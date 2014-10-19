package com.thumbsup.coolnamecli.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.thumbsup.coolnamecli.entity.User;
import com.thumbsup.coolnamecli.entity.Vehicle;

public class VehicleDAO {
	
	private static SessionFactory SessionFactory;
	
	public static void main(String[] args){
		Configuration configuration = new Configuration().configure();
		
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		SessionFactory = configuration.buildSessionFactory(serviceRegistry);

		VehicleDAO VehicleManager = new VehicleDAO();
		
		
		//TESTING SECTION
//		
//		User u = new User();
//		u.setUserName("testing");
//		
//		Vehicle v = new Vehicle();
//		v.setUser(u);
//		v.setDescription("Testing this DAO");
//		
//		VehicleManager.createVehicle(v);
//		
//		Vehicle v2 = VehicleManager.selectVehicle(v.getVehicleID());
//		
//		System.out.println(v2.getVehicleID());
//		System.out.println(v2.getDescription());
		
		
		
		
	}
	
	public static void createVehicle(Vehicle v){
		Session s = SessionFactory.openSession();
		Transaction t = s.beginTransaction();        
		s.save(v);
        t.commit();
        s.close();
	}
	
	public static Vehicle selectVehicle(int vehicleID){
    	Vehicle selectedVehicle = new Vehicle();
    	
    	Session s = SessionFactory.openSession();  
    	
    	Transaction transaction = s.beginTransaction();
    	selectedVehicle = (Vehicle)s.get(Vehicle.class, vehicleID);
        transaction.commit();
        
        s.close();
        return selectedVehicle;
	}
	
	public static List<Vehicle> selectAllVehicle(){
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
	    	
    	Session s = SessionFactory.openSession();    
        
    	Transaction transaction = s.beginTransaction();
        vehicleList = s.createCriteria(Vehicle.class).list();
        transaction.commit();
        
        s.close();
        
        return vehicleList;
	}
	
    public static void updateVehicle(Vehicle updatedVehicle)
    {   	
    	Session s = SessionFactory.openSession();
    	
    	Vehicle oldVehicle = (Vehicle) s.load(Vehicle.class, updatedVehicle.getVehicleID());
    	
    	Transaction transaction = s.beginTransaction();
    	s.update(updatedVehicle);
    	transaction.commit();
    	
    	s.close();    	
    }
    
    public static void deleteVehicle(Vehicle vehicle){
    	Session s = SessionFactory.openSession();
    	
    	Transaction transaction = s.beginTransaction();
    	s.delete(vehicle);
    	transaction.commit();
    	
    	s.close();
    	
    }
    
}
