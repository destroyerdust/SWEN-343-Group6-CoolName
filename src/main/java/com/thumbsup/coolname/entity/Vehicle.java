package com.thumbsup.coolname.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Vehicle database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleID;

	private String description;

	private String model;
	
	private String licensePlate;

	private String name;

	private int numSeats;

	//bi-directional many-to-one association to RideEntry
	@OneToMany(targetEntity= RideEntry.class ,mappedBy="vehicle", orphanRemoval=true)
	private List<RideEntry> rideEntries;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	public Vehicle() {
	}
	
	public Vehicle(int vehicleID, String description, String model,
			String name, int numSeats, List<RideEntry> rideEntries, User user) {
		super();
		this.vehicleID = vehicleID;
		this.description = description;
		this.model = model;
		this.name = name;
		this.numSeats = numSeats;
		this.rideEntries = rideEntries;
		this.user = user;
	}



	public int getVehicleID() {
		return this.vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumSeats() {
		return this.numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public List<RideEntry> getRideEntries() {
		return this.rideEntries;
	}

	public void setRideEntries(List<RideEntry> rideEntries) {
		this.rideEntries = rideEntries;
	}

	public RideEntry addRideEntry(RideEntry rideEntry) {
		getRideEntries().add(rideEntry);
		rideEntry.setVehicle(this);

		return rideEntry;
	}

	public RideEntry removeRideEntry(RideEntry rideEntry) {
		getRideEntries().remove(rideEntry);
		rideEntry.setVehicle(null);

		return rideEntry;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}