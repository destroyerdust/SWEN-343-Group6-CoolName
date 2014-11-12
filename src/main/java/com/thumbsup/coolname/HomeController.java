package com.thumbsup.coolname;

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
		
		//System.out.println("listRideEntry Size: " + listRideEntry.size());
	
		model.addAttribute("listRideEntrys", listRideEntry);
		
		
		return "home";
	}
	
}
