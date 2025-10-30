package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    public static final String FILE_NAME = "dealership.csv";

    public static Dealership getDealership() {
        try {
            BufferedReader reader = new BufferedReader((new FileReader(FILE_NAME)));
            String line = reader.readLine();
            if (line == null) return null;

            String[] dealerParts = line.split("\\|");
            if (dealerParts.length < 3) return null;

            String name = dealerParts[0].trim();
            String address = dealerParts[1].trim();
            String phone = dealerParts[2].trim();

            Dealership dealership = new Dealership(name, address, phone);

            while ((line = reader.readLine()) != null) {
                String[] vehicleParts = line.split("\\|");
                if (vehicleParts.length < 8) continue;

                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2].trim();
                String model = vehicleParts[3].trim();
                String vehicleType = vehicleParts[4].trim();
                String color = vehicleParts[5].trim();
                int odometer = Integer.parseInt(vehicleParts[6].trim());
                double price = Double.parseDouble(vehicleParts[7].trim());

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);
            }
            reader.close();

            return dealership;

        } catch (IOException e) {
            throw new RuntimeException("Unable to load file: " + FILE_NAME, e);

        }
    }

    public static void saveDealership(Dealership dealership){
        if (dealership == null) return;

        try {
            BufferedWriter w = new BufferedWriter((new FileWriter(FILE_NAME)));
            w.write(dealership.getName() + " | " +
                    dealership.getAddress() + " | " + dealership.getPhone());
            w.newLine();

            for(Vehicle v: dealership.getInventory()) {
                w.write(v.getVin() + "|" +
                        v.getYear() + "|" +
                        v.getMake() + "|" +
                        v.getModel() + "|" +
                        v.getVehicleType() + "|" +
                        v.getColor() + "|" +
                        v.getOdometer() + "|" +
                        v.getPrice());
                w.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save", e);
        }


    }

}
