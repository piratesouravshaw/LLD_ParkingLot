package org.bnpl.strategies.spotAllocationStrategy.impl;

import org.bnpl.model.*;
import org.bnpl.strategies.spotAllocationStrategy.SpotAssignmentStartegy;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStartegy {

    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate) {
        for(ParkingFloor parkingFloor: parkingLot.getFloor()){
            for(ParkingSpot parkingSpot:parkingFloor.getSpot()){
                if(parkingSpot.getStatus().equals("EMPTY") && parkingSpot.getSupportedVehicles().contains(vehicleType)){
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }
}
