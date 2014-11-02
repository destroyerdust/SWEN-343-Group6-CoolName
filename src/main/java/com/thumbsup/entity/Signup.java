package com.thumbsup.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Signup database table.
 * 
 */
@Entity
@NamedQuery(name="Signup.findAll", query="SELECT s FROM Signup s")
public class Signup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rideOnID;

	private int rideEntryID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	private int userID;

	public Signup() {
	}

	public Signup(int rideEntryID, Date timestamp, int userID) {
		super();
		this.rideEntryID = rideEntryID;
		this.timestamp = timestamp;
		this.userID = userID;
	}
	
	public int getRideOnID() {
		return this.rideOnID;
	}

	public void setRideOnID(int rideOnID) {
		this.rideOnID = rideOnID;
	}

	public int getRideEntryID() {
		return this.rideEntryID;
	}

	public void setRideEntryID(int rideEntryID) {
		this.rideEntryID = rideEntryID;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}