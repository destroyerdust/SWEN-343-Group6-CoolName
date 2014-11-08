package com.thumbsup.coolname;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
}
