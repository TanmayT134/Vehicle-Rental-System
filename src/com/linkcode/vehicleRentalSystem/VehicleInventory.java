package com.linkcode.VehicleRentalSystem;

import java.util.*;

public class VehicleInventory {
	
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public void addVehicle(Vehicle veh) {
		vehicles.add(veh);
	}
	
	public void showVehicles() {
		System.out.println("\n========== ALL VEHICLES ==========\n");
		for (Vehicle veh : vehicles) {
			veh.displayInfo();
		}
	}
	
	public void removeVehicle(Vehicle veh) {
		
		vehicles.remove(veh);
		System.out.println("Vehicle Removed!");
		
	}
	
	public ArrayList<Vehicle> getAllVehicles() {
		
		return vehicles;
		
	}
	
	public void showAvailableVehicles(Class<?> class1) {
		System.out.println("\n========== AVAILABLE "
        + class1.getSimpleName().toUpperCase()
        + " ==========\n");
		
		for (Vehicle veh : vehicles) {

			if (class1.isInstance(veh) && veh.isAvailable()) {
				veh.displayInfo();
			}

		}
	}

}
