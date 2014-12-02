package com.thumbsup.coolname;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thumbsup.coolname.entity.Group;
import com.thumbsup.coolname.entity.RideEntry;
import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.entity.Vehicle;
import com.thumbsup.coolname.service.GroupManager;
import com.thumbsup.coolname.service.RideEntryGroupManager;
import com.thumbsup.coolname.service.RideEntryManager;
import com.thumbsup.coolname.service.RoundTripManager;
import com.thumbsup.coolname.service.SignupManager;
import com.thumbsup.coolname.service.UserManager;
import com.thumbsup.coolname.service.VehicleManager;

/**
 * Handles requests for the application ride page.
 */
@Controller
public class RideController {
	
	private static final Logger logger = LoggerFactory.getLogger(RideController.class);
	
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
				if(v.getName() != null){
					carChoice+="<option value=\"" + v.getVehicleID() + "\" >" + v.getName() + "</option>\n";
				}else{
					carChoice+="<option value=\"" + v.getVehicleID() + "\" >" + v.getModel() + "</option>\n";
				}
			}
		}
		
		List<Group> groups = um.getGroupsForUser((Integer)request.getSession().getAttribute("auth"));
		String userGroups = "";
		if(groups.size()!=0)
		{				
			for(Group group : groups)
			{
				userGroups+="<option value=\"" + group.getGroupID() + "\" >" + group.getName() + "</option>\n";
			}
		}
		
		
		request.setAttribute("isDriver", isDriver);
		request.setAttribute("carChoice", carChoice);		
		request.setAttribute("userGroups", userGroups);
		
		return new ModelAndView("rideCreate");
	}
	
	@RequestMapping(value = "/ride/create", method = RequestMethod.POST)
	public ModelAndView PostCreateRide( 
			@RequestParam(value="name", required=true, defaultValue="NULL") String name,
			@RequestParam(value="destination", required=true, defaultValue="NULL") String destination,
			@RequestParam(value="orgin", required=true, defaultValue="NULL") String origin,
			@RequestParam(value="departureTime", required=true, defaultValue="NULL") String departureTime,
			@RequestParam(value="RoundtripRideChoice") String roundtrip,
			@RequestParam(value="returnDepartureTime") String returnDepartureTime,
			@RequestParam(value="DriveCar", required=false) String wantsToDrive,
			@RequestParam(value="selectCar", required=false, defaultValue="NULL") String selectCar,
			@RequestParam(value="numSeats", required=false, defaultValue="NULL") String numSeats,
			@RequestParam(value="rideGroup", required=false, defaultValue="NULL") String group,
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
			Integer numseats = null;
			Vehicle vehicle = null;
			
			
			//convert times to correctly formatted datetime for the depature time					
			Timestamp departTime = formatTimestamp(departureTime);
			
			java.util.Date date= new java.util.Date();
			Timestamp creationTimestamp = new Timestamp(date.getTime());
			
			//make a call to the RideEntryManger and actually create database entry in DB
			RideEntryManager rem = new RideEntryManager();	
			
			
			//if the driver wants to drive
			if(wantsToDrive != null && wantsToDrive.equals("Yes")){
				//if the current user has vehicles and they selected one to drive then drive						
				if(currentUser.getVehicles().size()>0 && !selectCar.equals("NULL")){
				
					//get selected vehicle
					VehicleManager vm = new VehicleManager();
					vehicle = vm.selectVehicle(Integer.parseInt(selectCar));
				}
				//if the number of seats chosen was null then
				if(!numSeats.equals("NULL")){
					numseats = Integer.parseInt(numSeats);
				}
				
				//if the user wants a roundtrip then create two rideEntries
				// and the user is driving
				if (roundtrip.equals("Yes")) {
					logger.info("The user has chosen to create a Roundtrip ride");
					
					//create a new RoundTripManger for creating a new roundtrip
					RoundTripManager rtm = new RoundTripManager();					
					
					Timestamp departTime2 = formatTimestamp(returnDepartureTime);
					
					RideEntry startRide = rem.createRideEntry(
							creationTimestamp, destination, null, null, name,
							origin, departTime, numseats, userPK, vehicle);
					
					//swap the orgin and destination
					RideEntry endRide = rem.createRideEntry(
							creationTimestamp, origin, null, null, name,
							destination, departTime2, numseats, userPK, vehicle);
					
					rtm.createRoundTrip(startRide.getRideEntryID(), endRide.getRideEntryID());
					if(!group.equals("NULL"))
					{
						RideEntryGroupManager regm = new RideEntryGroupManager();
						regm.createSignup(startRide.getRideEntryID(), Integer.parseInt(group), creationTimestamp);
						regm.createSignup(endRide.getRideEntryID(), Integer.parseInt(group), creationTimestamp);
					}
					
				} else {
					//otherwise there is just one ride					
					RideEntry createdRide = rem.createRideEntry(
							creationTimestamp, destination, null, null, name,
							origin, departTime, numseats, userPK, vehicle);
					if(!group.equals("NULL"))
					{
						RideEntryGroupManager regm = new RideEntryGroupManager();
						regm.createSignup(createdRide.getRideEntryID(), Integer.parseInt(group), creationTimestamp);	
					}
				}
			} 
			//if there is no driver
			else{
				// if the user wants a roundtrip then create two rideEntries
				// and the user is not driving
				if (roundtrip.equals("Yes")) {
					logger.info("The user has chosen to create a Roundtrip ride");

					//create a new RoundTripManger for creating a new roundtrip
					RoundTripManager rtm = new RoundTripManager();					
					
					Timestamp departTime2 = formatTimestamp(returnDepartureTime);
					
					RideEntry startRide = rem.createRideEntry(
							creationTimestamp, destination, null, null, name,
							origin, departTime, 0, userPK, vehicle);

					// swap the origin and destination
					RideEntry endRide = rem.createRideEntry(creationTimestamp,
							origin, null, null, name, destination, departTime2,
							0, userPK, vehicle);
					
					rtm.createRoundTrip(startRide.getRideEntryID(), endRide.getRideEntryID());
					if(!group.equals("NULL"))
					{
						RideEntryGroupManager regm = new RideEntryGroupManager();
						regm.createSignup(startRide.getRideEntryID(), Integer.parseInt(group), creationTimestamp);
						regm.createSignup(endRide.getRideEntryID(), Integer.parseInt(group), creationTimestamp);
					}

				} else {					
					RideEntry createdRide = rem.createRideEntry(
							creationTimestamp, destination, null, null, name,
							origin, departTime, 0, userPK, vehicle);
					if(!group.equals("NULL"))
					{
						RideEntryGroupManager regm = new RideEntryGroupManager();
						regm.createSignup(createdRide.getRideEntryID(), Integer.parseInt(group), creationTimestamp);	
					}
				}
			}
			
			return new ModelAndView("redirect:/");
		}
		
		return new ModelAndView("rideCreate");
	}
	
	//used for formating a string timestamp
	public Timestamp formatTimestamp(String time){
		//convert times to correctly formatted datetime for the depature time
		time = time.replace("T", " ");			
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Timestamp newTime = null;
		try
		{
			newTime = new Timestamp(sdf.parse(time).getTime());
		}
		catch (ParseException e)
		{
			//if it fails then make the departure time the current time on the server
			logger.info("Timestamp format failed, now setting current timestamp");
			e.printStackTrace();
			java.util.Date date= new java.util.Date();
			newTime = new Timestamp(date.getTime());
		}			
		return newTime;
	}
	
	@ResponseBody
	@RequestMapping(value = "/ride/coolname/ride/create/seats", method = RequestMethod.GET)
	public String GetMaxNumSeats(Model model, @RequestParam(value="selectCar") String selectCar) {		
		String result ="";
		VehicleManager vm = new VehicleManager();
		int number = vm.selectVehicle(Integer.parseInt(selectCar)).getNumSeats();
		logger.info("The number of seats in the selected vehicle is: " + number);
		result += "<option value=\"\" selected disabled>Select # of Available seats</option>\n";
		for(int x=1; x<=number; x++){
			result += "<option value=\"" + x + "\" >" + x + "</option>\n";
		}

		return result;
	}
	
	
	@RequestMapping(value = "/ride/history", method = RequestMethod.GET)
	public String CreateRideHistory(Locale locale, Model model, HttpServletRequest req) {
		logger.info("Welcome ride! The client locale is {}.", locale);
		
		//Retrieve a list of ride entries
		UserManager um = new UserManager();
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
		
		List<RideEntry> myRideEntries = um.getRideHistoryForUser(userPK);
		
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
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		RideEntryManager rem = new RideEntryManager();
		RideEntry re = rem.selectRideEntry(rideEntryID);
		
		re.updateStatus();
		
		if(re.getVehicle() != null)
		{
			VehicleManager vm = new VehicleManager();
			int vehicleID = re.getVehicle().getVehicleID();
			Vehicle v = vm.selectVehicle(vehicleID);				
			
			UserManager um = new UserManager();
			int userID = v.getUser().getUserId();
			User driver = um.selectUser(userID);
			
			model.addAttribute("rideEntry", re);
			model.addAttribute("vehicleModel", v.getModel());
			model.addAttribute("driverName", driver.getFirstName() + " " + driver.getLastName());
		}
		else
		{
			model.addAttribute("rideEntry", re);
			model.addAttribute("vehicleModel", "No vehicle");
			model.addAttribute("driverName", "No driver");
		}

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
