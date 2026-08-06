package com.linkcode.VehicleRentalSystem;

import java.util.*;

public class Customer {
	
	String name;
	long mobileNo;
	private boolean isLicenseAvailable;
	private ArrayList<Vehicle> rentedVehicles;
	
	public Customer(String name, long mobileNo, boolean isLicenseAvailable) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.isLicenseAvailable = isLicenseAvailable;
		this.rentedVehicles = new ArrayList<Vehicle>();
	}
	
	public void rentvehicle(Vehicle vehicle, int no) {
		if(vehicle.isAvailable()) {
			vehicle.rent(this, no);
			rentedVehicles.add(vehicle);
		}else {
			System.out.println("Vehicle is not Available!");
		}
	}
	
	public void returnAllVehicle() {

		if (rentedVehicles.isEmpty()) {
			System.out.println("No rented vehicles found.");
			return;
		}

		for (Vehicle vehicle : rentedVehicles) {
			vehicle.returnVehicle();
		}

		rentedVehicles.clear();

		System.out.println("All rented vehicles have been returned.");

	}
	
	public void viewRentedVehicles() {
		System.out.println("-----Rented Vehicle List-----");
		rentedVehicles.forEach(val->System.out.println("Vehicle Id : " + val.getVehicleId()));
		System.out.println("-----------------------------");
	}
	
}
