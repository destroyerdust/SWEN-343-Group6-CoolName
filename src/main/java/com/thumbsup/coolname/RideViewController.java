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

import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.service.RideEntryManager;

@Controller
public class RideViewController
{
	private static final Logger logger = LoggerFactory.getLogger(RideViewController.class);
	private int rideEntryID;
	
	/**
	 * Select ride viewer
	 */
	@RequestMapping(value = "/ride/{rideEntryID}/view", method = RequestMethod.GET)
	public String view(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		RideEntryManager rem = new RideEntryManager();
		model.addAttribute("rideEntry",rem.selectRideEntry(rideEntryID));

		return "rideView";
	}
}
