package com.thumbsup.coolnamecli;

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

	private String userID;

	public Signup() {
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

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}