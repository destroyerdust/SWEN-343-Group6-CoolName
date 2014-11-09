package com.thumbsup.coolname;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.service.RideEntryManager;

/**
 * Handles requests for the application ride page.
 */
@Controller
public class RideController {
	
	private static final Logger logger = LoggerFactory.getLogger(RideController.class);
	
	/**
	 * TODO
	 */
	@RequestMapping(value = "/ride/create", method = RequestMethod.GET)
	public String GetCreateRide( Model model) {
		logger.info("GET: Creating new ride! The current use is");
		
		//model.addAttribute("serverTime", formattedDate );
		
		return "rideCreate";
	}
	
	@RequestMapping(value = "/ride/create", method = RequestMethod.POST)
	public String PostCreateRide( Model model) {
		logger.info("POST: Creating new ride! The current use is");
		
		//model.addAttribute("serverTime", formattedDate );
		
		return "rideCreate";
	}
	
	@RequestMapping(value = "/ride/history", method = RequestMethod.GET)
	public String CreateRideHistory(Locale locale, Model model, HttpServletRequest req) {
		logger.info("Welcome ride! The client locale is {}.", locale);
		
		//Retrieve a list of ride entries
		RideEntryManager red = new RideEntryManager();
		HttpSession s = req.getSession();
		int userPK = 1;
		
		//Get the userID
		if(s.getAttribute("auth") != null){
			userPK = Integer.parseInt((String) s.getAttribute("Auth"));
		}
		
		List<RideEntry> myRideEntries = red.getRideHistoryForUser(userPK);
		
		//add relevant data attributes to the model

		//model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myRides", myRideEntries);
		//return the page
		
		return "rideHistory";
	}
}
