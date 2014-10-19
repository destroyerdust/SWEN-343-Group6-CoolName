package com.thumbsup.coolnamecli;

public class Vehicle {

	private int vehicleId;
	private String model;
	private String name;
	private int numSeats;
	private String description;
	private User user;
	
	public Vehicle() {}

	public Vehicle(String model, String name, int numSeats,
			String description, User user) {
		this.model = model;
		this.name = name;
		this.numSeats = numSeats;
		this.description = description;
		this.user = user;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
