package com.thumbsup.coolnamecli.service;

import java.util.List;

import com.thumbsup.coolnamecli.dao.VehicleDAO;
import com.thumbsup.coolnamecli.entity.User;
import com.thumbsup.coolnamecli.entity.Vehicle;

public class VehicleManager {
	private VehicleDAO dao = new VehicleDAO();
	
	public void createVehicle(String name, String model, String description, int numSeats, int userId)
	{
		Vehicle entity = new Vehicle();
		entity.setName(name);
		entity.setModel(model);
		entity.setDescription(description);
		entity.setNumSeats(numSeats);
		User user = new User();
		user.setUserId(userId);
		entity.setUser(user);
		
		dao.insert(entity);
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
	
	public List<Vehicle> listAll()
	{
		return dao.selectAll();
	}
}


