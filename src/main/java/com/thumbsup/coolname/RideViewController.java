package com.thumbsup.coolname;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.Signup;
import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.entity.Vehicle;
import com.thumbsup.coolname.service.RideEntryManager;
import com.thumbsup.coolname.service.SignupManager;
import com.thumbsup.coolname.service.UserManager;
import com.thumbsup.coolname.service.VehicleManager;

@Controller
public class RideViewController
{
	private static final Logger logger = LoggerFactory.getLogger(RideViewController.class);
	
	/**
	 * Select ride viewer
	 */
	@RequestMapping(value = "/ride/{rideEntryID}/view", method = RequestMethod.GET)
	public String view(Locale locale, Model model, @PathVariable int rideEntryID) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		RideEntryManager rem = new RideEntryManager();
		RideEntry re = rem.selectRideEntry(rideEntryID);
		
		VehicleManager vm = new VehicleManager();
		int vehicleID = re.getVehicle().getVehicleID();
		Vehicle v = vm.selectVehicle(vehicleID);
		
		UserManager um = new UserManager();
		int userID = v.getUser().getUserId();
		User driver = um.selectUser(vehicleID);
		
		model.addAttribute("rideEntry", re);
		model.addAttribute("vehicleModel", v.getModel());
		model.addAttribute("driver", driver);

		return "rideView";
	}
	
	@RequestMapping(value = "/ride/{rideEntryID}/join", method = RequestMethod.GET)
	public ModelAndView join(Locale locale, Model model, @PathVariable int rideEntryID, HttpServletRequest request)
	{
		Integer userID = (Integer)request.getSession().getAttribute("auth");
		if(userID == null)
		{
			//Do nothing
		}
		else
		{
			SignupManager sum = new SignupManager();
			sum.createSignup(userID, rideEntryID, new Timestamp(new Date().getTime()));
		}
		return new ModelAndView("redirect:/");
	}
}