package com.linkcode.vehicleRentalSystem;

import java.util.*;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static VehicleInventory inventory = new VehicleInventory();

	public static void main(String[] args) {
		
		initializeVehicleInventory();
		boolean flag = true;
		while(flag) {
		
			System.out.println("-----Vehicle Rental System-----");
			System.out.println("1.Admin\n2.Customer\n3.Exit");
			System.out.println("Enter Choice :");
			
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1-> showAdminMenu();
			case 2-> showCustomerMenu();
			case 3-> flag = false;
			default -> System.out.println("Invalid Choice! Please try again.");
			}
		}	
		
	}
	
	private static void initializeVehicleInventory() {
		inventory.addVehicle(new Car("C001", 5000, 6));
		inventory.addVehicle(new Car("C002", 7000, 8));
		inventory.addVehicle(new Bus("BS01", 15000, 20));
		inventory.addVehicle(new Bus("BS02", 20000, 26));
		inventory.addVehicle(new Bike("B001", 700, true));
		inventory.addVehicle(new Bike("B002", 500, false));
	}
	
	public static void showAdminMenu() {
		System.out.println("Enter Username :");
		String username = sc.next();
		
		System.out.println("Enter Password :");
		String password = sc.next();
		
		if(Admin.authenticate(username, password)) {
			boolean flag = true;
			while(flag) {
				System.out.println("-----Admin Menu-----");
				System.out.println("1.Add Vehicle");
				System.out.println("2.Remove Vehicle");
				System.out.println("3.Send Vehicle For Maintenance");
				System.out.println("4.Complete Vehicle Maintenance");
				System.out.println("5.Show All Vehicles");
				System.out.println("6.Exit");
				
				System.out.println("Enter Choice:");
				int ch = sc.nextInt();
				
				switch(ch) {
				case 1->{
					System.out.println("1.Car");
					System.out.println("2.Bike");
					System.out.println("3.Bus");
					
					int n = sc.nextInt();
					
					System.out.println("Enter Vehicle Id:");
					String id = sc.next();
					System.out.println("Enter Rental Rate:");
					int rate = sc.nextInt();
					
					switch(n) {
					case 1-> {
						System.out.println("Enter Number Of Seats:");
						int no = sc.nextInt();
						Car car = new Car(id, rate, no);
						inventory.addVehicle(car);
					}
					case 2-> {
						System.out.println("Helmet Available (Yes / No):");
						boolean ha= sc.next().equalsIgnoreCase("yes");
						Bike bike = new Bike(id, rate, ha);
						inventory.addVehicle(bike);
					}
					case 3-> {
						System.out.println("Enter Number Of Seats:");
						int no = sc.nextInt();
						Bus bus = new Bus(id, rate, no);
						inventory.addVehicle(bus);
					}
					default -> System.out.println("Invalid Choice! Please try again.");
					}
				}
				case 2-> {
					System.out.println("Enter Vehicle Id : ");
					String id = sc.next();
					Vehicle vehicle = findVehicleById(id);
					if(vehicle != null) {
						System.out.println("Vehicle Found!");
						inventory.removeVehicle(vehicle);
					}else {
						System.out.println("Vehicle not Found!");
					}
				}
				case 3-> {
					System.out.println("Enter Vehicle Id:");
					String id = sc.next();
					Vehicle veh = findVehicleById(id);
					if(veh != null) {
						veh.sendForMaintenance();
					}else {
						System.out.println("Vehicle Not Found!");
					}
					
				}
				case 4-> {
					System.out.println("Enter Vehicle Id:");
					String id = sc.next();
					Vehicle veh = findVehicleById(id);
					if(veh != null) {
						veh.completeMaintenance();
					}else {
						System.out.println("Vehicle Not Found!");
					}
				}
				case 5->{
					inventory.showVehicles();
				}
				case 6-> flag = false;
				default -> System.out.println("Invalid Choice! Please try again.");
				}
			}
			
			
			
		}else {
			System.out.println("Username or Password is incorrect!");
		}
	}
	
	private static Vehicle findVehicleById(String id) {
		ArrayList<Vehicle> vehicles = inventory.getAllVehicles();
		
		for(Vehicle veh : vehicles) {
			if(veh.getVehicleId().equalsIgnoreCase(id)) {
				return veh;
			}
		}
		
		return null;
	}
	
	public static void  showCustomerMenu() {
		System.out.println("-----Customer Form-----");
		System.out.println("Enter Your Name:");
		String name = sc.next();
		System.out.println("Enter Mobile Number:");
		long mobile = sc.nextLong();
		System.out.println("Licsence Available (Yes / No):");
		String la = sc.next();
		boolean licAvailable = la.equalsIgnoreCase("yes");
		
		Customer cust1 = new Customer(name, mobile, licAvailable);
		boolean flag = true;
		while(flag) {
			System.out.println("Hello " + name);
			System.out.println("1.Show Available Cars");
			System.out.println("2.Show Available Bikes");
			System.out.println("3.Show Available Bus");
			System.out.println("4.Rent Vehicle");
			System.out.println("5.Return All Rented Vehicles");
			System.out.println("6.View Rented Vehilces");
			System.out.println("7.Exit");
			System.out.println("Enter Your Choice:");
			int ch = sc.nextInt();
			switch(ch) {
			case 1-> {
				inventory.showAvailableVehicles(Car.class);
			}
			case 2->{
				inventory.showAvailableVehicles(Bike.class);
			}
			case 3->{
				inventory.showAvailableVehicles(Bus.class);
			}
			case 4-> {
				System.out.println("Enter Vehicle Id:");
				String id = sc.next();
				Vehicle vehicle = findVehicleById(id);
				if(vehicle != null) {
					System.out.println("Enter no. of Days:");
					int no = sc.nextInt();
					cust1.rentvehicle(vehicle, no);
				}else {
					System.out.println("Vehicle Not Found!");
				}
			}
			case 5-> {
				cust1.returnAllVehicle();
				System.out.println("All Vehicles are Returned");
			}
			case 6-> {
				cust1.viewRentedVehicles();
			}
			case 7-> flag = false;
			default -> System.out.println("Invalid Choice! Please try again.");
			}
		}
		
	}
	
}
