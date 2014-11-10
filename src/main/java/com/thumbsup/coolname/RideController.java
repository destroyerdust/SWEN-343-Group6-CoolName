package com.thumbsup.coolname;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.entity.Vehicle;
import com.thumbsup.coolname.service.RideEntryManager;
import com.thumbsup.coolname.service.SignupManager;
import com.thumbsup.coolname.service.UserManager;
import com.thumbsup.coolname.service.VehicleManager;

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
	public ModelAndView GetCreateRide( Model model, HttpServletRequest request) {
		logger.info("GET: Creating new ride! The current use is");
		logger.info("Logged in userID:" + request.getSession().getAttribute("auth"));
		
		if(request.getSession().getAttribute("auth")==null){
			//redirect to login			
			logger.info("user is not authenticated, redirecting to log in");
			return new ModelAndView("redirect:/account/login");
		}
		
		//Need to get the authenticated user's vehicles and send the list to the view
		UserManager um = new UserManager();
		
		User currentUser = um.selectUser( Integer.parseInt(request.getSession().getAttribute("auth").toString()));
		
		List<Vehicle> cars = currentUser.getVehicles();
	
		Boolean isDriver = false;
		String carChoice = "";
		
		//if user is a driver
		if(cars.size()!=0){				
			isDriver = true;
			for(Vehicle v : cars){
				carChoice+="<option value=\"" + v.getVehicleID() + "\" >" + v.getName() + "</option>\n";			
			}
			logger.info(carChoice);
		
		}
		request.setAttribute("isDriver", isDriver);
		request.setAttribute("carChoice", carChoice);		
		
		
		
		
		return new ModelAndView("rideCreate");
	}
	
	@RequestMapping(value = "/ride/create", method = RequestMethod.POST)
	public ModelAndView PostCreateRide( 
			@RequestParam(value="name", required=true, defaultValue="NULL") String name,
			@RequestParam(value="destination", required=true, defaultValue="NULL") String destination,
			@RequestParam(value="orgin", required=true, defaultValue="NULL") String orgin,
			@RequestParam(value="depatureTime", required=true, defaultValue="NULL") long depatureTime,
			@RequestParam(value="selectCar", required=false, defaultValue="NULL") String selectCar,
			@RequestParam(value="numSeats", required=false, defaultValue="NULL") String numSeats,			
			HttpServletRequest request,
			Model model) {
		logger.info("POST: Creating new ride! The current use is");
		logger.info("Logged in userID:" + request.getSession().getAttribute("auth"));
		
		
		if(request.getSession().getAttribute("auth")==null){
			//redirect to login			
		}
		else{
			int userPK = (Integer) request.getSession().getAttribute("auth");
			
			UserManager um = new UserManager();						
			User currentUser = um.selectUser(userPK);

			Vehicle vehicle = null;
			if(currentUser.getVehicles().size()>0){
			
				//get selected vehicle
				VehicleManager vm = new VehicleManager();
				vm.selectVehicle((Integer)selectCar);
			}
		
			//convert times to correctly formatted datetime
			java.util.Date date= new java.util.Date();
			
			Timestamp creationTimestamp = new Timestamp(date.getDate());
				
			Timestamp departTime = new Timestamp(depatureTime);
			
			RideEntryManager rem = new RideEntryManager();
			
			rem.createRideEntry(creationTimestamp, 
					destination, 
					null, 
					null, 
					name, 
					orgin, 
					departTime, 
					vehicle);			
			
			return new ModelAndView("redirect:/");
		}
		
		return new ModelAndView("rideCreate");
	}
	
	@RequestMapping(value = "/ride/history", method = RequestMethod.GET)
	public String CreateRideHistory(Locale locale, Model model, HttpServletRequest req) {
		logger.info("Welcome ride! The client locale is {}.", locale);
		
		//Retrieve a list of ride entries
		RideEntryManager red = new RideEntryManager();
		HttpSession s = req.getSession();
		int userPK;
		//Get the userID
		if(s.getAttribute("auth") == null){
			return "rideHistory";
		} else {
			//verbose for error checking
			Object authObj = s.getAttribute("auth");
			int temp = Integer.parseInt(authObj.toString());
			userPK = temp;
		}
		
		List<RideEntry> myRideEntries = red.getRideHistoryForUser(userPK);
		
		//add relevant data attributes to the model

		//model.addAttribute("serverTime", formattedDate );
		if(myRideEntries.size() >= 0){
			model.addAttribute("myRides", myRideEntries);
		}
		
		return "rideHistory";
	}
	
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
	
	/**
	 * ToDO
	 * @param locale
	 * @param model
	 * @param rideEntryID
	 * @param request
	 * @return
	 */
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
