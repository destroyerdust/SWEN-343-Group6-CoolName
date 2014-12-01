package com.thumbsup.coolname;


import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thumbsup.coolname.entity.Group;
import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.entity.User_Group;
import com.thumbsup.coolname.entity.Vehicle;
import com.thumbsup.coolname.service.GroupManager;
import com.thumbsup.coolname.service.SignupManager;
import com.thumbsup.coolname.service.UserGroupManager;
import com.thumbsup.coolname.service.UserManager;
import com.thumbsup.coolname.service.VehicleManager;

/**
 * Handles requests for the application ride page.
 */
@Controller
public class GroupController {
	
	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	
	@RequestMapping(value = "/group/create", method = RequestMethod.GET)
	public ModelAndView getCreateGroup( Model model, HttpServletRequest request)
	{
		logger.info("GET: Creating new group! The current use is");
		logger.info("Logged in userID:" + request.getSession().getAttribute("auth"));
		
		if(request.getSession().getAttribute("auth")==null){
			//redirect to login			
			logger.info("user is not authenticated, redirecting to log in");
			return new ModelAndView("redirect:/account/login");
		}
		
		return new ModelAndView("groupCreate");
	}
	
	@RequestMapping(value = "/group/create", method = RequestMethod.POST)
	public ModelAndView postCreateGroup( 
			@RequestParam(value="name", required=true, defaultValue="NULL") String name,
			@RequestParam(value="description", required=true, defaultValue="NULL") String description,			
			HttpServletRequest request,
			Model model)
	{
		
		GroupManager gm = new GroupManager();
		Group group = gm.createGroup(name, description, ((Integer)request.getSession().getAttribute("auth")).intValue());
		
		UserGroupManager ugm = new UserGroupManager();
		User_Group ug = ugm.createSignup(((Integer)request.getSession().getAttribute("auth")).intValue(), group.getGroupID(), new Timestamp(new java.util.Date().getTime()));
		
		return new ModelAndView("redirect:/group/list");
	}
	
	@RequestMapping(value = "/group/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model)
	{
		GroupManager gm = new GroupManager();
		List<Group> groupList = gm.listGroups();
		model.addAttribute("groupList", groupList);
		
		return "groupList";
	}
	
	@RequestMapping(value = "/group/{groupID}/view", method = RequestMethod.GET)
	public String view(Locale locale, Model model, @PathVariable int groupID)
	{
		GroupManager gm = new GroupManager();
		Group group = gm.selectGroup(groupID);
		List<RideEntry> rideEntries = gm.findRideEntriesForGroup(groupID);
		List<User> users = gm.findUsersForGroup(groupID);
		
		model.addAttribute("group", group);
		model.addAttribute("rideEntries", rideEntries);
		model.addAttribute("groupUsers", users);
		
		return "groupView";
	}
	
	@RequestMapping(value = "/group/{groupID}/join", method = RequestMethod.GET)
	public ModelAndView join(Locale locale, Model model, @PathVariable int groupID, HttpServletRequest request)
	{
		if(request.getSession().getAttribute("auth")==null)
		{
			//redirect to login			
			logger.info("user is not authenticated, redirecting to log in");
			return new ModelAndView("redirect:/account/login");
		}
		UserGroupManager ugm = new UserGroupManager();
		ugm.createSignup((Integer)request.getSession().getAttribute("auth"), groupID, new Timestamp(new java.util.Date().getTime()));
		
		return new ModelAndView("redirect:/group/list");
	}
	
	@RequestMapping(value = "/group/{groupID}/leave", method = RequestMethod.DELETE)
	public ModelAndView leave(Locale locale, Model model, @PathVariable int groupID, HttpServletRequest request)
	{
		if(request.getSession().getAttribute("auth")==null)
		{
			//redirect to login			
			logger.info("user is not authenticated, redirecting to log in");
			return new ModelAndView("redirect:/account/login");
		}
		UserGroupManager ugm = new UserGroupManager();
		int ugID = -1;
		for(User_Group ug : ugm.listUserGroups())
		{
			if(ug.getGroupID() == groupID && ug.getUserID() == (Integer)request.getSession().getAttribute("auth"))
			{
				ugID = ug.getUser_GroupID();
				break;
			}
		}
		if(ugID != -1)
		{
			ugm.deleteSignup(ugID);
		}
		
		return new ModelAndView("redirect:/group/list");
	}
}
