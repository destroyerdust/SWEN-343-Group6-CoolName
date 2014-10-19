package com.thumbsup.coolnamecli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Initializing ThumpbsUp Version 0.0.1");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		outputInfo();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		mainMenu();
	}
	
	public static void outputInfo() {
		System.out.println("ThumbsUp Information:");
		// Description
		System.out.println("ThumbsUp is a ...(Add Description)");
		
		// Authors
		System.out.println("Authors: ");
		System.out.println("\tSean Barkley");
		System.out.println("\tConnor Craig");
		System.out.println("\twords...(add rest)");
	}
	
	public static void mainMenu() {
		String input = null;
		
		System.out.println("ThumbsUp Main Menu");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Please select from the following:");
		System.out.println("");
		System.out.println("1. Add User");
		System.out.println("2. Add Vehicle");
		
		// Input Selection
		System.out.print("Enter number selection: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//  read the input from the command-line; need to use try/catch with the
	    //  readLine() method
	    try {
	    	input = br.readLine();
	    } catch (IOException ioe) {
	       System.out.println("IO error trying to read your input!");
	       System.out.println("Returning to main menu!");
	       mainMenu();
	    }
	    
	    System.out.println("Input Selected: " + input);
	}
	
	public static void addUser() {
		
	}

}
