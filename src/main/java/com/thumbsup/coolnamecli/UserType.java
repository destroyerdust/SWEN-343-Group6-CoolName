package com.thumbsup.coolnamecli;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UserType database table.
 * 
 */
@Entity
@NamedQuery(name="UserType.findAll", query="SELECT u FROM UserType u")
public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userTypeID;

	private String userType;

	public UserType() {
	}

	public int getUserTypeID() {
		return this.userTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}