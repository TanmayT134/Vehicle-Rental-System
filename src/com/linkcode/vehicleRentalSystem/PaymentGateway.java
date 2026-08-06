package com.linkcode.vehicleRentalSystem;

public class PaymentGateway {
	
	public static boolean processPayment(double totalBill) {
		
		System.out.println(totalBill + " Processing Payment...");
		try {
			Thread.sleep(5000);
			
			System.out.println("Payment Done!");
			return true;
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		return false;
	}

}
