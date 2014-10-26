package com.thumbsup.coolnamecli.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thumbsup.coolnamecli.entity.Vehicle;
import com.thumbsup.coolnamecli.dao.SessionFactory;

public class VehicleDAO extends CRUDManager<Vehicle, Integer> {

	public Vehicle insert(Vehicle v){
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Transaction t = s.beginTransaction();        
		s.save(v);
        t.commit();
        s.flush();
        Vehicle inserted = (Vehicle)s.get(Vehicle.class, v.getVehicleID());
        s.close();
        
        return inserted;
	}
	
	@Override	
	public Vehicle select(Integer vehicleID){
		SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
		Vehicle result = (Vehicle)s.get(Vehicle.class, vehicleID);
		s.close();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
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
    	Vehicle result = (Vehicle)s.get(Vehicle.class, vehicle.getVehicleID());
    	s.close();
    	
    	return result;
    }
    
    public Vehicle update(Vehicle vehicle){
    	SessionFactory factory = SessionFactory.getSessionFactory();
		Session s = factory.getSession();
    	Transaction transaction = s.beginTransaction();
    	s.update(vehicle);
    	transaction.commit();
    	Vehicle result = (Vehicle) s.get(Vehicle.class, vehicle.getVehicleID());
    	s.close();
    	return result;
    }
    
}
