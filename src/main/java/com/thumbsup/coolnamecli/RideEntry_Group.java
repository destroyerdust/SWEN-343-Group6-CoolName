package com.thumbsup.coolnamecli;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RideEntry_Group database table.
 * 
 */
@Entity
@NamedQuery(name="RideEntry_Group.findAll", query="SELECT r FROM RideEntry_Group r")
public class RideEntry_Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rideEntry_GroupID;

	private int groupID;

	private int rideEntryID;

	public RideEntry_Group() {
	}

	public int getRideEntry_GroupID() {
		return this.rideEntry_GroupID;
	}

	public void setRideEntry_GroupID(int rideEntry_GroupID) {
		this.rideEntry_GroupID = rideEntry_GroupID;
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getRideEntryID() {
		return this.rideEntryID;
	}

	public void setRideEntryID(int rideEntryID) {
		this.rideEntryID = rideEntryID;
	}

}