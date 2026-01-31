package org.bnpl.model;

import java.util.List;

public class ParkingSpot extends BaseModel{
    int number;
    List<VehicleType> supportedVehicles;
    SpotStatus status;
    Vehicle vehicle;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<VehicleType> getSupportedVehicles() {
        return supportedVehicles;
    }

    public void setSupportedVehicles(List<VehicleType> supportedVehicles) {
        this.supportedVehicles = supportedVehicles;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
