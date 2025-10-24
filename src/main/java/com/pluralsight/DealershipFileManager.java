package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public static Dealership getDealership() {
        try {
            BufferedReader reader = new BufferedReader((new FileReader("dealership.csv")));
            String line = reader.readLine();
            if (line == null) return null;

            String[] dealerParts = line.split("\\|");
            String name = dealerParts[0];
            String address = dealerParts[1];
            String phone = dealerParts[2];

            Dealership dealership = new Dealership(name, address, phone);

            while ((line = reader.readLine()) != null) {
                String[] vehicleParts = line.split("\\|");
                if (vehicleParts.length < 8) continue;

                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String vehicleType = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                double price = Double.parseDouble(vehicleParts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);
            }
            reader.close();

            return dealership;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveDealerShip(Dealership dealership){

    }
}
