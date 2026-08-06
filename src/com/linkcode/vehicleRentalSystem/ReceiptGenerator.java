package com.linkcode.vehicleRentalSystem;

public class ReceiptGenerator {

    public static void generateReceipt(Vehicle vehicle, Customer customer) {

        double totalBill = vehicle.getRentalRate() * vehicle.getRentedDays();

        System.out.println("\n======================================");
        System.out.println("         RENTAL RECEIPT");
        System.out.println("======================================");
        System.out.println("Customer Name : " + customer.name);
        System.out.println("Mobile No.    : " + customer.mobileNo);
        System.out.println("Vehicle ID    : " + vehicle.getVehicleId());
        System.out.println("Rental Rate   : ₹" + vehicle.getRentalRate() + " / day");
        System.out.println("Days Rented   : " + vehicle.getRentedDays());
        System.out.println("--------------------------------------");
        System.out.println("Total Bill    : ₹" + totalBill);
        System.out.println("======================================\n");
    }
}