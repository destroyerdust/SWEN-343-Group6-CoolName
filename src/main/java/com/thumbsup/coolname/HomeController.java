package com.thumbsup.coolname;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.service.RideEntryManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Model model) {

		RideEntryManager rem = new RideEntryManager();
		List<RideEntry> listRideEntry = rem.listRideEntries();
		
		//process the list
		for(RideEntry ride: listRideEntry){
			//gets current server time to use for ride status comparison
			Timestamp currentTime = new Timestamp(new java.util.Date().getTime());

			//if the ride has already started but has not ended
			if(currentTime.after(ride.getStartTime()) && currentTime.before(ride.getEndTime())){
				//the ride has already started and is in progress
				ride.setStatus("In Progress");
			}
			//if the ride has not started
			else if(currentTime.before(ride.getStartTime()) && currentTime.before(ride.getEndTime())){
				ride.setStatus("Seating");				
			}
			//if the ride has finished
			else if(currentTime.after(ride.getStartTime()) && currentTime.after(ride.getEndTime())){
				ride.setStatus("Complete");
			}else{
				//this should never happen but just incase (pesky dirty data)
				ride.setStatus("Invalid Start/End Time");
			}
		}

		model.addAttribute("listRideEntrys", listRideEntry);
		
		
		return "home";
	}
	
}
