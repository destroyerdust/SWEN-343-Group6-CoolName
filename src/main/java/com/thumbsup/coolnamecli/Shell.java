package com.thumbsup.coolnamecli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Console;

import com.thumbsup.coolnamecli.entity.User;

public class Shell {

	public static void main(String[] args) {
		
		Console c = System.console();
		//String input = c.readLine("Hi: ");
		//System.out.println("Input: " + input);
		
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
		System.out.println("ThumbsUp Main Menu");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Please select from the following:");
		System.out.println("");
		System.out.println("1. Add User");
		System.out.println("2. Add Vehicle");
		
		// Input Selection
		//String input = c.readLine("Enter number selection: ");
	    
	    //System.out.println("Input Selected: " + input);
	}
	
	public static void addUser() {
		User user = new User();
	}

}
