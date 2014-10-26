package com.thumbsup.coolnamecli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.SecureRandom;

import com.thumbsup.coolnamecli.entity.User;
import com.thumbsup.coolnamecli.entity.Vehicle;
import com.thumbsup.coolnamecli.service.*;

public class Shell {

	static UserManager uMan;
	static VehicleManager vMan;
	static SignupManager sMan;
	static RideEntryManager reMan;
	
	static User authenticatedUser;
	
	public static void main(String[] args) {

		uMan = new UserManager();
		vMan = new VehicleManager();
		sMan = new SignupManager();
		reMan = new RideEntryManager();
		
		System.out.println("Initializing ThumpbsUp Version 0.0.1");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		outputInfo();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String strLine = null;
		
		//Login or Signup
		//This method will dump a bunch of user info into the Shell runtime
		
		authenticatedUser = null;
		
		//Register a new user or login an existing one
		try {
			preconditionUsage();
			String response = in.readLine();
			if(response.equals("register")){
				
				//create a concrete User object from user input
				//save it to database and return it as authenticatedUser
				authenticatedUser = createUser();
			}else if(response.equals("login")){
				
				System.out.println("Login::Username is?");
				String userName = in.readLine();
				System.out.println("Login::Password is?");
				String pass = in.readLine();

				//parse user input and bring a User object up from the database
				authenticatedUser = uMan.login(userName,pass);
			} else {
				terminate();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if(authenticatedUser == null){
			terminate();
		}
		usage();
		
		//Begin shell loop
		for (;;) {
			try {
				System.out.println("...");
				System.out.println(".....");
				System.out.println("Enter a command:");
				strLine = in.readLine();

				if (strLine.equals("exit")) {
					terminate();
				} else if (strLine.equals("usage")) {
					usage();
				} else {
					int command = Integer.parseInt(strLine);
					execute(command);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException nfe) {
				// nfe.printStackTrace();
				System.out.println("Illegal input detected.");
				usageInfo();
			}
		}
	}

	private static void execute(int command) {
		switch (command) {

		case 1: // a Rider being created
			createUser();
			System.out.println("you have added a rider");
			break;

		case 2: // a Driver being created
			createUserAndVehicle();
			System.out.println("you have added a driver");
			break;

		case 3: // Passenger adds a RideEntry
			System.out.println("Passenger has added a RideEntry");
			break;

		case 4: // Driver adds a RideEntry
			System.out.println("Driver has added a RideEntry");
			break;

		case 5: // The matchmaker outputting a list of RideEntries for Rider
			RideMatchMaker maker = new RideMatchMaker(reMan);
			break;

		case 6: // The matchmaker outputting a list of RideEntries for Driver
			break;

		case 7: // Driver adding vehicle to RideEntry
			break;

		default:
			usageInfo();
			break;
		}
	}

	public static void outputInfo() {
		System.out.println("ThumbsUp Information:");
		// Description

		// Authors
		System.out.println("Contributors: ");
		System.out.println("\tSean Barkley");
		System.out.println("\tConor Craig");
		System.out.println("\tAaron Damrau");
		System.out.println("\tNathan Perry");
		System.out.println("\tIago Moreiera");

	}

	public static void preconditionUsage(){
		System.out.println("Are you registering a new user or logging in?");
		System.out.println();
		System.out.println("Type the following commands to proceed:");
		System.out.println("register: Register yourself as a new user");
		System.out.println("login: login as an existsing user");
	}
	
	public static void usage() {
		System.out.println("usage: print this message");
		System.out.println("exit: exit the system");

		// a Rider being created
		System.out.println("1: Add a Passenger");

		// a Driver being created
		System.out.println("2: Add a Driver");

		// a Rider making a RideEntry
		System.out.println("3: Passenger adds a RideEntry");

		// a Driver making a RideEntry
		System.out.println("4: Driver adds a RideEntry");

		// The matchmaker outputting a list of RideEntries for Rider
		System.out.println("5: Matchmake a Driver to many RideEntries");

		// The matchmaker outputting a list of RideEntries for Driver
		System.out.println("6: Matchmake a Passenger to many RideEntries");

		// Driver adding vehicle to RideEntry
		System.out.println("7: Add a Vehicle to a Driver's RideEntry");

		// Visual print of RideEntry because the vehicle changed
	}

	public static void usageInfo() {
		System.err.println("Please Enter a legitimate command.");
		System.err
				.println("Enter 'usage' to see a list of available commands.");
	}
	
	// Normal user no car
	public static User createUser(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		User u = new User();

		SecureRandom random = new SecureRandom();
		
		String userName = null;
		String firstName = null;
		String lastName = null;
		String password = null;
		String phoneNumber = null;
		String passwordSalt = new BigInteger(130, random).toString(32);
		passwordSalt = passwordSalt.substring(0, 10);
		int userType = 3;
		
		try {
			System.out.println("User Name: ");
			userName = in.readLine();
			System.out.println("First Name: ");
			firstName = in.readLine();
			System.out.println("Last Name: ");
			lastName = in.readLine();
			System.out.println("Password: ");
			password = in.readLine();
			System.out.println("Phone Number: ");
			phoneNumber = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		u = uMan.createUser(userName, firstName, lastName, password, passwordSalt, phoneNumber, userType);
		System.out.println("User ID: " + u.getUserId());
		return u;
		
	}
	
	// Driver creation
	public static void createUserAndVehicle(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		User u = new User();
		Vehicle v = new Vehicle();

		SecureRandom random = new SecureRandom();
		
		String userName = null;
		String firstName = null;
		String lastName = null;
		String password = null;
		String phoneNumber = null;
		String passwordSalt = new BigInteger(130, random).toString(32);
		passwordSalt = passwordSalt.substring(0, 10);
		int userType = 2;
		
		String name = null;
		String model = null;
		String description = null;
		int numSeats = 0;
		
		try {
			System.out.println("User");
			System.out.println("User Name: ");
			userName = in.readLine();
			System.out.println("First Name: ");
			firstName = in.readLine();
			System.out.println("Last Name: ");
			lastName = in.readLine();
			System.out.println("Password: ");
			password = in.readLine();
			System.out.println("Phone Number: ");
			phoneNumber = in.readLine();
			System.out.println("Vehicle");
			System.out.println("Name:");
			name = in.readLine();
			System.out.println("Model:");
			model = in.readLine();
			System.out.println("Description:");
			description = in.readLine();
			System.out.println("Number Seats:");
			numSeats =in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		u = uMan.createUser(userName, firstName, lastName, password, passwordSalt, phoneNumber, userType);
		System.out.println("User ID: " + u.getUserId());
		v = vMan.createVehicle(name, model, description, numSeats, u.getUserId());
		System.out.println("Vehicle ID: " + v.getVehicleID());
		
	}

	private static void terminate() {
		System.exit(0);
	}
}
