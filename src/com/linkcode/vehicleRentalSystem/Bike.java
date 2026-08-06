package com.linkcode.vehicleRentalSystem;

public class Bike extends Vehicle {
	
	private boolean helmetAvailable;
	
	Bike(String id, int rate, boolean ha){
		super(id, rate);
		this.helmetAvailable = ha;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("------------------------------");
		System.out.println("Vehicle Type : Bike");
		System.out.println("Vehicle ID   : " + getVehicleId());
		System.out.println("Rental Rate  : ₹" + getRentalRate() + " / day");
		System.out.println("Helmet       : " + (helmetAvailable ? "Available" : "Not Available"));
		System.out.println("Available    : " + (isAvailable() ? "Yes" : "No"));
		System.out.println("------------------------------");
	}

}
