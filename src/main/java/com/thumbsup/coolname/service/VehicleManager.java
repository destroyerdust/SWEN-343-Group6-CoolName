package com.thumbsup.coolname.service;

import java.util.List;

import com.thumbsup.coolname.dao.VehicleDAO;
import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.entity.Vehicle;

public class VehicleManager {
	private VehicleDAO dao = new VehicleDAO();
	
	public Vehicle createVehicle(String name, String model, String description, int numSeats, int userId)
	{
		Vehicle entity = new Vehicle();
		entity.setName(name);
		entity.setModel(model);
		entity.setDescription(description);
		entity.setNumSeats(numSeats);
		User user = new User();
		user.setUserId(userId);
		entity.setUser(user);
		
		entity = dao.insert(entity);
		return entity;
	}
	
	public void deleteVehicle(int vehicleId)
	{
		Vehicle entity = new Vehicle();
		entity.setVehicleID(vehicleId);
		dao.delete(entity);
	}
	
	public void updateVehicle(int vehicleID, String name, String model, String description, int numSeats)
	{
		Vehicle entity = dao.select(vehicleID);
		entity.setName(name);
		entity.setModel(model);
		entity.setDescription(description);
		entity.setNumSeats(numSeats);
		
		dao.update(entity);
	}
	
	public void updateVehicle(Vehicle vehicle)
	{
		dao.update(vehicle);
	}
	
	public List<Vehicle> listAll()
	{
		return dao.selectAll();
	}
	
	public Vehicle selectVehicle(int vehicleID)
	{
		return dao.select(vehicleID);
	}
}