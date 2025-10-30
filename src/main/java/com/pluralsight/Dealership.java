package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> matchedVehicles = new ArrayList<>();

        for (Vehicle v: inventory){
            if(v.getPrice() >= min && v.getPrice() <= max) {
                matchedVehicles.add(v);
            }
        }
        return matchedVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matchedVehicles = new ArrayList<>();

        for (Vehicle v: inventory) {
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                matchedVehicles.add(v);
            }
        }
        return matchedVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> matchedVehicles = new ArrayList<>();

        for (Vehicle v: inventory){
            if(v.getYear() >= min && v.getYear() <= max) {
                matchedVehicles.add(v);
            }
        }
        return matchedVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> matchedVehicles = new ArrayList<>();

        for (Vehicle v: inventory) {
            if(color.equalsIgnoreCase(v.getColor())) {
                matchedVehicles.add(v);
            }
        }
        return matchedVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> matchedVehicles = new ArrayList<>();

        for (Vehicle v: inventory) {
            if(v.getOdometer() >= min && v.getOdometer() <= max);
            matchedVehicles.add(v);
        }
        return matchedVehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> matchedVehicles = new ArrayList<>();

        for (Vehicle v: inventory) {
            if(v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                matchedVehicles.add(v);
            }
        }
        return matchedVehicles;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        // empty for now
    }
}
