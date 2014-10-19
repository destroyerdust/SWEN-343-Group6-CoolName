package com.thumbsup.coolnamecli;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the User_Group database table.
 * 
 */
@Entity
@NamedQuery(name="User_Group.findAll", query="SELECT u FROM User_Group u")
public class User_Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_GroupID;

	private int groupID;

	private int userID;

	public User_Group() {
	}

	public int getUser_GroupID() {
		return this.user_GroupID;
	}

	public void setUser_GroupID(int user_GroupID) {
		this.user_GroupID = user_GroupID;
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}