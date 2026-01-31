package org.bnpl.repository;

import org.bnpl.model.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber){
        return Optional.empty();
    }

    //Vehicle object returned from the save method is different
    // than the Vehicle inside the parameter
    // because the returned vehicle object will have some parameters
    // like createdBy, updatedBy, Id, etc..
    public Vehicle save(Vehicle vehicle){
        return null;
    }
}
