package com.linkcode.VehicleRentalSystem;

public class Admin {

	private final static String ADMIN_USERNAME = "admin";
	private final static String ADMIN_PASSWORD = "12345";
	
	public static boolean authenticate(String username, String password) {
		if(ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
			return true;
		}
		
		return false;
	}
	
	
}