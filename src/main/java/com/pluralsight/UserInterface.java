package com.pluralsight;

public class UserInterface {

    // Attribute
    private Dealership dealership;

    // Constructor
    public UserInterface() {
        System.out.println();

    }

    // Methods
    private void init(){
        DealershipFileManager dealerShipParse = new DealershipFileManager();
        this.dealership = DealershipFileManager.getDealership();
    }
    public void display() {

        System.out.println("Welcome to the Dealership Interface");
        init();
    }


    public void processGetByPriceRequest() {
        System.out.println("Processing get-by-price request...");
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Processing get-by-make-model request...");
    }

    public void processGetByYearRequest() {
        System.out.println("Processing get-by-year request...");
    }

    public void processGetByColorRequest() {
        System.out.println("Processing get-by-color request...");
    }

    public void processGetByMileageRequest() {
        System.out.println("Processing get-by-mileage request...");
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Processing get-by-vehicle-type request...");
    }

    public void processGetAllVehiclesRequest() {
        System.out.println("Processing get-all-vehicles request...");
    }

    public void processAddVehicleRequest() {
        System.out.println("Processing add-vehicle request...");
    }

    public void processRemoveVehicleRequest() {
        System.out.println("Processing remove-vehicle request...");
    }
}

