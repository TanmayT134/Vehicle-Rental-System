package com.linkcode.vehicleRentalSystem;

public class Vehicle {
	private String vehicleId;
	private int rentalRate;
	private boolean isAvailable;
	private int rentedDays;
	private boolean underMaintenance;
	
	public Vehicle(String vehicleId, int rentalRate) {
		super();
		this.vehicleId = vehicleId;
		this.rentalRate = rentalRate;
		this.isAvailable = true;
		this.rentedDays = 0;
		this.underMaintenance = false;
	}
	
	public void rent(Customer customer, int no) {
		if(this.isAvailable) {
			double totalBill = no * rentalRate;
			if (PaymentGateway.processPayment(totalBill)) {

				isAvailable = false;
				rentedDays = no;

				ReceiptGenerator.generateReceipt(this, customer);

				EmailService.sendBookingConfirmation(this, customer);

			} else {

				System.out.println("Payment Not Done!");

			}
		}
	}
	
	public void returnVehicle() {

		if (!isAvailable) {
			isAvailable = true;
			rentedDays = 0;

			System.out.println("--------------------------------");
			System.out.println("Vehicle Returned Successfully!");
			System.out.println("Vehicle ID : " + vehicleId);
			System.out.println("--------------------------------");

		} else {
			System.out.println("Vehicle is already available.");
		}

	}
	
	public void sendForMaintenance() {
		if(this.isAvailable) {
			this.isAvailable = false;
			this.underMaintenance = true;
			System.out.println("Vehicle Sent!");
		}else {
			System.out.println("Already under maintenance!");
		}
	}
	
	public void completeMaintenance() {
		if(this.underMaintenance) {
			this.underMaintenance = false;
			this.isAvailable = true;
			System.out.println("Vehicle Maintenance Completed");
		}else {
			System.out.println("Vehicle Already Available!");
		}
		
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public int getRentalRate() {
		return rentalRate;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public int getRentedDays() {
		return rentedDays;
	}

	public boolean isUnderMaintenance() {
		return underMaintenance;
	}

	public void displayInfo() {

	}
	
}
