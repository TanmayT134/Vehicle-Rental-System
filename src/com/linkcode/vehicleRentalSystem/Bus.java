package com.linkcode.VehicleRentalSystem;

public class Bus extends Vehicle {
	
	private int noOfSeats;
	
	Bus(String id, int rate, int no){
		super(id, rate);
		this.noOfSeats = no;
	}

	@Override
	public void displayInfo() {
		System.out.println("------------------------------");
		System.out.println("Vehicle Type : Bus");
		System.out.println("Vehicle ID   : " + getVehicleId());
		System.out.println("Rental Rate  : ₹" + getRentalRate() + " / day");
		System.out.println("Seats        : " + noOfSeats);
		System.out.println("Available    : " + (isAvailable() ? "Yes" : "No"));
		System.out.println("------------------------------");
	}
}
