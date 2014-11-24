package com.thumbsup.coolname.service;

import java.sql.Timestamp;
import java.util.List;

import com.thumbsup.coolname.dao.GroupDAO;
import com.thumbsup.coolname.dao.RideEntryDAO;
import com.thumbsup.coolname.entity.Group;
import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.Vehicle;

public class GroupManager 
{
	private GroupDAO groupDAO = new GroupDAO();
	
	//createGroup
	public Group createGroup(String name, String description, int ownerID)
	{
		Group group = new Group();
		
		group.setName(name);
		group.setDescription(description);
		group.setOwnerID(ownerID);
		
		group = groupDAO.insert(group);
		
		return group;
	}
	//updateGroup
	public int updateGroup(int groupID, String name, String description, int ownerID)
	{
		Group group = groupDAO.select(groupID);
		
		group.setName(name);
		group.setDescription(description);
		
		groupDAO.update(group);
		
		return groupID;
	}
	//deleteGroup
	public void deleteGroup(int groupID)
	{
		Group group= groupDAO.select(groupID);
		
		groupDAO.delete(group);
	}
	//listGroups
	public List<Group> listGroups()
	{
		List<Group> groups = groupDAO.selectAll();
		
		return groups;
	}
	
	public Group selectGroup(int groupID)
	{
		return groupDAO.select(groupID);
	}

}
