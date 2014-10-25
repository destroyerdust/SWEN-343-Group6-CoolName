package com.thumbsup.coolnamecli.service;

import com.thumbsup.coolnamecli.dao.VehicleDAO;
import com.thumbsup.coolnamecli.entity.Vehicle;

public class VehicleManager {
	private VehicleDAO dao = new VehicleDAO();
	
	public void createVehicle(String name, String model, String description, int numSeats)
	{
		Vehicle entity = new Vehicle();
		entity.setName(name);
		entity.setModel(model);
		entity.setDescription(description);
		entity.setNumSeats(numSeats);
		
		dao.insert(entity);
	}
	
	public void deleteVehicle(int vehicleId)
	{
		Vehicle entity = new Vehicle();
		entity.setVehicleID(vehicleId);
		dao.delete(entity);
	}
	
	public void updateVehicle()
	{
		
	}
	
	public void listAll()
	{
		
	}
}


