package com.thumbsup.coolnamecli;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the RideEntry database table.
 * 
 */
@Entity
@NamedQuery(name="RideEntry.findAll", query="SELECT r FROM RideEntry r")
public class RideEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rideEntryID;

	private Timestamp creationTimestamp;

	private String destination;

	private Timestamp endTime;

	private String mapUri;

	private String name;

	private String source;

	private Timestamp startTime;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="VehicleID")
	private Vehicle vehicle;

	public RideEntry() {
	}

	public int getRideEntryID() {
		return this.rideEntryID;
	}

	public void setRideEntryID(int rideEntryID) {
		this.rideEntryID = rideEntryID;
	}

	public Timestamp getCreationTimestamp() {
		return this.creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getMapUri() {
		return this.mapUri;
	}

	public void setMapUri(String mapUri) {
		this.mapUri = mapUri;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}