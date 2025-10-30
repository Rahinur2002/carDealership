package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    // Attribute
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);

    // Constructor
    public UserInterface() {
        System.out.println();

    }

    // Methods
    private void init(){
        DealershipFileManager dealerShipFile = new DealershipFileManager();
        this.dealership = DealershipFileManager.getDealership();
    }
    public void display() {
        init();

        if(dealership == null) {
            System.out.println("Theres currently no dealership");
            return;
        }

        boolean running = true;
        while (running){
           displayMenu();
            System.out.println("What would you like to do?: ");
            int userInput;
            try {
                userInput = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                continue;
            }

            switch (userInput) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> running = false;
                default -> System.out.println("Invalid input!");
            }
        }
        System.out.println("Have a good day!");
    }


    public void processAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }

    public void processGetByPriceRequest() {
        System.out.println("Enter the minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());

        defaultHeader();
        List<Vehicle> matchedVehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(matchedVehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Enter the make: ");
        String make = scanner.nextLine();

        System.out.println("Enter the model: ");
        String model = scanner.nextLine();

        defaultHeader();
        List<Vehicle> matchedVehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(matchedVehicles);
    }

    public void processGetByYearRequest() {
        System.out.println("Enter the minimum year: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the maximum year: ");
        int max = Integer.parseInt(scanner.nextLine());

        defaultHeader();
        List<Vehicle> matchedVehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(matchedVehicles);
    }

    public void processGetByColorRequest() {
        System.out.println("Enter the color: ");
        String color = scanner.nextLine();

        defaultHeader();
        List<Vehicle> matchedVehicles = dealership.getVehiclesByColor(color);
        displayVehicles(matchedVehicles);
    }

    public void processGetByMileageRequest() {
        System.out.println("Enter the minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the maximum mileage");
        int max = Integer.parseInt(scanner.nextLine());

        defaultHeader();
        List<Vehicle> matchedVehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(matchedVehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter Vehicle Type: ");
        String type = scanner.nextLine();

        defaultHeader();
        List<Vehicle> matchedVehicles = dealership.getVehiclesByType(type);
        displayVehicles(matchedVehicles);
    }

    public void processGetAllVehiclesRequest() {
        defaultHeader();
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        System.out.println("Processing add-vehicle request...");

    }

    public void processRemoveVehicleRequest() {
        System.out.println("Processing remove-vehicle request...");
    }

    private void displayVehicles(List<Vehicle> vehicles){
        if(vehicles == null || vehicles.isEmpty()){
            System.out.println("There are no vehicles at the moment!");
            return;
        }

        for(Vehicle v: vehicles){
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s $%-10s%n",
            v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(),
            v.getColor(), v.getOdometer(), v.getPrice());
        }
    }

    public void displayMenu(){
        System.out.println("Welcome to the Dealership Interface");
        System.out.println("""
                ===================================================
                1 - Find vehicles within a price range
                2 - Find vehicles by make / model
                3 - Find vehicles by year range
                4 - Find vehicles by color
                5 - Find vehicles by mileage range
                6 - Find vehicles by type
                7 - List ALL vehicles
                8 - Add a vehicle
                9 - Remove a vehicle
                99 - Quit
                ===================================================""");
    }
    private static void defaultHeader(){
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n", "Vin", "Year", "Make",
                "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("======================================================================================");
    }
}

