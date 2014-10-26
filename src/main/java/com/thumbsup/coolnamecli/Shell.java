package com.thumbsup.coolnamecli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.thumbsup.coolnamecli.entity.User;
import com.thumbsup.coolnamecli.entity.Vehicle;
import com.thumbsup.coolnamecli.service.UserManager;
import com.thumbsup.coolnamecli.service.VehicleManager;

public class Shell {

	public static void main(String[] args) {

		System.out.println("Initializing ThumpbsUp Version 0.0.1");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		outputInfo();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String strLine = null;
		
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
	public static void createUser(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		User u = new User();
		UserManager UM = new UserManager();
		
		String userName = null;
		String firstName = null;
		String lastName = null;
		String password = null;
		String phoneNumber = null;
		String passwordSalt = null;
		int userType = 2;
		
		
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
			System.out.println("Password Salt WE NEED TO FIX THIS: ");
			passwordSalt = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		u = UM.createUser(userName, firstName, lastName, password, passwordSalt, phoneNumber, userType);
		System.out.println("User ID: " + u.getUserId());
		
	}
	
	// Driver creation
	public static void createUserAndVehicle(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		User u = new User();
		Vehicle v = new Vehicle();
		UserManager UM = new UserManager();
		VehicleManager VM = new VehicleManager();
		
		String userName = null;
		String firstName = null;
		String lastName = null;
		String password = null;
		String phoneNumber = null;
		String passwordSalt = null;
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
			System.out.println("Password Salt WE NEED TO FIX THIS: ");
			passwordSalt = in.readLine(); 
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
		
		u = UM.createUser(userName, firstName, lastName, password, passwordSalt, phoneNumber, userType);
		System.out.println("User ID: " + u.getUserId());
		v = VM.createVehicle(name, model, description, numSeats, u.getUserId());
		System.out.println("Vehicle ID: " + v.getVehicleID());
		
	}

	private static void terminate() {
		System.exit(0);
	}

}
