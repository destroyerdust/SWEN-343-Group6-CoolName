package com.thumbsup.coolname;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thumbsup.coolname.dao.UserDAO;
import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.entity.Vehicle;
import com.thumbsup.coolname.service.UserManager;

@Controller
public class AccountController {
	
	// SIGNUP SERVICES
	
	@RequestMapping(value="account/signup", method=RequestMethod.GET)
	public String getSignup(HttpServletRequest request)
	{
		request.setAttribute("s", true);
		return "signup";
	}
	
	@RequestMapping(value="account/signup", method=RequestMethod.POST)
	public ModelAndView postSignup(@RequestParam(value="usr", required=true, defaultValue="") String userName,
							@RequestParam(value="psw", required=true, defaultValue="") String password,
							@RequestParam(value="name", required=true, defaultValue="") String name,
							@RequestParam(value="lstn", required=true, defaultValue="") String lastName,
							@RequestParam(value="cell", required=true, defaultValue="") String cellPhone,
							@RequestParam(value="caraswr", required=true, defaultValue="") String carAnswer,
							@RequestParam(value="model", required=false) String model,
							@RequestParam(value="seats", required=false) String seats,
							@RequestParam(value="desc", required=false, defaultValue="") String description,
							HttpServletRequest request)
	{
		String page = "";
		if(userName.equals("") || password.equals("") || name.equals("") || lastName.equals("") ||
				cellPhone.equals("") || carAnswer.equals(""))
		{
			page = "signup";
			request.setAttribute("s", false);
		}
		else
		{
			int type = UserType.PASSENGER.getId();
			Vehicle v = null;
			if(carAnswer.equalsIgnoreCase("Yes"))
			{
				v = new Vehicle();
				v.setDescription(description);
				v.setModel(model);
				v.setNumSeats(Integer.parseInt(seats));
				type = UserType.DRIVER.getId();
			}
			UserManager manager = new UserManager();
			User u = manager.createUser(userName, name, lastName, password, cellPhone, type, v);
			if(u == null)
			{
				page = "signup";
				request.setAttribute("s", false);
			}
			else
			{
				page = "redirect:/";
				u = manager.login(userName, password);
				password = null;
				HttpSession session = request.getSession();
				session.setAttribute("auth", u.getUserId());
			}
		}
		return new ModelAndView(page);
	}
	
	// MANAGE ACCOUNT SERVICES
	
	@RequestMapping(value="account/manage", method=RequestMethod.GET)
	public ModelAndView getAccount(HttpServletRequest request)
	{
		String page = "manageAccount";
		Integer userId = (Integer) request.getSession().getAttribute("auth");
		ModelAndView view = null;
		if( userId == null)
		{
			page = "redirect:login";
			view = new ModelAndView(page);
		}
		else
		{
			UserDAO dao = new UserDAO();
			User u = dao.select(userId);
			view = new ModelAndView(page,"user",u);
		}
		return view;
	}
	
	// EDIT PROFILE SERVICES
	@RequestMapping(value="account/profile/edit", method=RequestMethod.GET)
	public ModelAndView getProfile(HttpServletRequest request)
	{
		String page = "editProfile";
		Integer userId = (Integer) request.getSession().getAttribute("auth");
		ModelAndView view = null;
		if( userId == null)
		{
			page = "redirect:/account/login";
			view = new ModelAndView(page);
		}
		else
		{
			UserDAO dao = new UserDAO();
			User u = dao.select(userId);
			request.setAttribute("s", true);
			view = new ModelAndView(page,"user",u);
		}
		return view;
	}
	
	@RequestMapping(value="account/profile/edit", method=RequestMethod.POST)
	public ModelAndView updateProfile(@ModelAttribute("user") User updatedUser, HttpServletRequest request)
	{
		UserManager services = new UserManager();
		User oldUser = services.selectUser((Integer) request.getSession().getAttribute("auth"));
		
		String firstName = updatedUser.getFirstName();
		String lastName = updatedUser.getLastName();
		String phoneNumber = updatedUser.getPhoneNumber();
		String page = "redirect:/account/manage";
		if( (firstName != null && !firstName.equals("")) && (lastName != null && !lastName.equals("")) && (phoneNumber != null && !phoneNumber.equals("")) )
		{
			oldUser.setFirstName(updatedUser.getFirstName());
			oldUser.setLastName(updatedUser.getLastName());
			oldUser.setPhoneNumber(updatedUser.getPhoneNumber());
			services.updateUser(oldUser);
		}
		else
		{
			request.setAttribute("s", false);
			page = "editProfile";
		}
		return new ModelAndView(page);
	}
	
	// VEHICLE MANAGEMENT SERVICES
	@RequestMapping(value="account/vehicle/edit", method=RequestMethod.GET)
	public ModelAndView getVehicles(HttpServletRequest request)
	{
		String page = "myVehicles";
		Integer userId = (Integer) request.getSession().getAttribute("auth");
		ModelAndView view = null;
		if( userId == null)
		{
			page = "redirect:/account/login";
			view = new ModelAndView(page);
		}
		else
		{
			UserDAO dao = new UserDAO();
			User u = dao.select(userId);
			request.setAttribute("s", true);
			request.setAttribute("p", false);
			view = new ModelAndView(page,"user",u);
		}
		return view;
	}
	
	@RequestMapping(value="account/vehicle/edit", method=RequestMethod.POST)
	public ModelAndView updateVehicles(@ModelAttribute("user") User updatedUser, HttpServletRequest request)
	{
		UserManager services = new UserManager();
		User oldUser = services.selectUser((Integer) request.getSession().getAttribute("auth"));
		if(updatedUser.getVehicles() != null)
		{
			if(validateVehicleList(updatedUser.getVehicles()))
			{
				request.setAttribute("s", false);
				return new ModelAndView("myVehicles", "user", oldUser);
			}
			List<Integer> toDelete = new ArrayList<Integer>();
			for (Vehicle vehicle : oldUser.getVehicles()) {
				boolean delete = true;
				for (Vehicle v : updatedUser.getVehicles()) {
					if(vehicle.getVehicleID() == v.getVehicleID() && v.getDescription() != null)
					{
						delete = false;
						vehicle.setName(v.getName());
						vehicle.setModel(v.getModel());
						vehicle.setNumSeats(v.getNumSeats());
						vehicle.setDescription(v.getDescription());
						vehicle.setLicensePlate(v.getLicensePlate());
					}	
				}
				if(delete)
					toDelete.add(oldUser.getVehicles().indexOf(vehicle));
			}
			for (int index : toDelete) {
				if(oldUser.getVehicles().get(index).getRideEntries().size() > 0)
				{
					request.setAttribute("s", true);
					request.setAttribute("p", true);
					return new ModelAndView("myVehicles","user", oldUser);
				}
				oldUser.getVehicles().remove(index);
			}
		}
		else
		{
			for (Vehicle v : oldUser.getVehicles()) {
				if(v.getRideEntries().size() > 0)
				{
					request.setAttribute("p", true);
					request.setAttribute("s", true);
					return new ModelAndView("myVehicles","user", oldUser);
				}
			}
			oldUser.getVehicles().clear();
		}
		services.updateUser(oldUser);
		return new ModelAndView("redirect:/account/manage");
	}
	
	private boolean validateVehicleList(List<Vehicle> vehicles)
	{
		boolean status = false;
		for (Vehicle vehicle : vehicles) {
			if( vehicle.getVehicleID() != 0 && (vehicle.getDescription().equals("") || vehicle.getLicensePlate().equals("") || vehicle.getModel().equals("") || vehicle.getName().equals("") ||
					vehicle.getNumSeats() == 0 || vehicle.getLicensePlate().length() > 4))
			{
				status = true;
			}
		}
		return status;
	}
	
	@RequestMapping(value="/account/vehicle/create", method=RequestMethod.GET)
	public ModelAndView getCreateVehicle(HttpServletRequest request)
	{
		String page = "createVehicle";
		Integer userId = (Integer) request.getSession().getAttribute("auth");
		ModelAndView view = null;
		if( userId == null)
		{
			page = "redirect:/account/login";
			view = new ModelAndView(page);
		}
		else
		{
			UserDAO dao = new UserDAO();
			User u = dao.select(userId);
			request.setAttribute("s", true);
			view = new ModelAndView(page,"user",u);
		}
		return view;
	}
	
	@RequestMapping(value="account/vehicle/create", method=RequestMethod.POST)
	public ModelAndView postCreateVehicle(@RequestParam(value="model", required=true, defaultValue="") String model,
							@RequestParam(value="seats", required=true, defaultValue="") String seats,
							@RequestParam(value="desc", required=true, defaultValue="") String description,
							@RequestParam(value="name", required=true, defaultValue="") String name,
							@RequestParam(value="license", required=true, defaultValue="") String license,
							HttpServletRequest request)
	{
		String page = "redirect:/account/vehicle/edit";
		if(model != null && seats != null && !model.equals("") && !seats.equals("") && !name.equals("") && !license.equals("") && license.length() <= 4)
		{
			Vehicle v = null;
			v = new Vehicle();
			v.setName(name);
			v.setLicensePlate(license);
			v.setDescription(description);
			v.setModel(model);
			v.setNumSeats(Integer.parseInt(seats));
			int type = UserType.DRIVER.getId();
			UserManager services = new UserManager();
			User user = services.selectUser((Integer) request.getSession().getAttribute("auth"));
			user.setUserType(type);
			user.addVehicle(v);
			services.updateUser(user);
		}
		else
		{
			request.setAttribute("s", false);
			page = "createVehicle";
		}
		return new ModelAndView(page);
	}
	
	
	// LOGIN SERVICES
	
	@RequestMapping(value = "/account/login", method = RequestMethod.GET)
	public String getLogin(HttpServletRequest request) {
		request.setAttribute("l", true);
		return "login";
	}

	@RequestMapping(value = "/account/login", method = RequestMethod.POST)
	public ModelAndView postLogin(
			@RequestParam(value = "usr", required = true, defaultValue = "") String username,
			@RequestParam(value = "psw", required = true, defaultValue = "") String password,
			HttpServletRequest request) {
		String page = "";
		if (username.equals("") || password.equals("")) {
			page = "login";
			request.setAttribute("l", false);
		} else {
			UserManager manager = new UserManager();
			User u = manager.login(username, password);
			password = null;
			if (u == null) {
				page = "login";
				request.setAttribute("l", false);
			} else {
				page = "redirect:/";
				HttpSession session = request.getSession();
				session.setAttribute("auth", u.getUserId());
			}
		}

		return new ModelAndView(page);
	}
	
	@RequestMapping(value="/account/logout", method=RequestMethod.GET)
	public ModelAndView fireLogout(HttpServletRequest request){
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}
	
}
