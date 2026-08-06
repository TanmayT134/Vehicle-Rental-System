package com.linkcode.vehicleRentalSystem;

public class Car extends Vehicle {
	
	private int noOfSeats;
	
	Car(String id, int rate, int no){
		super(id, rate);
		this.noOfSeats = no;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("------------------------------");
		System.out.println("Vehicle Type : Car");
		System.out.println("Vehicle ID   : " + getVehicleId());
		System.out.println("Rental Rate  : ₹" + getRentalRate() + " / day");
		System.out.println("Seats        : " + noOfSeats);
		System.out.println("Available    : " + (isAvailable() ? "Yes" : "No"));
		System.out.println("------------------------------");
	}

}
