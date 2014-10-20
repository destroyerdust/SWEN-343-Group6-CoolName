package com.thumbsup.coolnamecli.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.thumbsup.coolnamecli.entity.Vehicle;
import com.thumbsup.coolnamecli.dao.SessionFactory;

public class VehicleDAO extends CRUDManager<Vehicle, Integer> {
//		
//	public static void main(String[] args){
//		Configuration configuration = new Configuration().configure();
//		
//		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
//		serviceRegistryBuilder.applySettings(configuration.getProperties());
//		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
//		SessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//		VehicleDAO VehicleManager = new VehicleDAO();
//		
//		
//		//TESTING SECTION
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
//		
//		
//		
//		
//	}
//	
	public Vehicle insert(Vehicle v){
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();        
		s.save(v);
        t.commit();
        s.flush();
        v = (Vehicle)s.load(Vehicle.class, v);
        s.close();
        
        return v;
	}
	
	@Override	
	public Vehicle select(Integer vehicleID){
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Vehicle v = (Vehicle)s.load(Vehicle.class, vehicleID);
		s.close();
		
		return v;
	}
	
	public List<Vehicle> selectAll(){
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
        List<Vehicle> vehicleList = new ArrayList<Vehicle>(); 
		vehicleList = s.createCriteria(Vehicle.class).list();              
        s.close();
        
        return vehicleList;
	}
	
    public Vehicle delete(Vehicle vehicle)
    {   	
    	SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction transaction = s.beginTransaction();    	
    	s.delete(vehicle);
    	transaction.commit();
    	s.flush();
    	vehicle = (Vehicle)s.load(Vehicle.class, vehicle.getVehicleID());
    	s.close();
    	
    	return vehicle;
    }
    
    public Vehicle update(Vehicle vehicle){
    	SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.update(vehicle);
    	transaction.commit();
    	vehicle = (Vehicle) s.load(Vehicle.class, vehicle.getVehicleID());
    	s.close();
    	return vehicle;
    	
    }
    
}
