package com.thumbsup.coolnamecli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.thumbsup.coolnamecli.dao.*;

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
			System.out.println("you have added a rider");
			break;

		case 2: // a Driver being created
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

	private static void terminate() {
		System.exit(0);
	}
}
