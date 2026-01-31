package org.bnpl.strategies.spotAllocationStrategy;

import org.bnpl.model.Gate;
import org.bnpl.model.ParkingLot;
import org.bnpl.model.ParkingSpot;
import org.bnpl.model.VehicleType;

import java.util.Optional;

public interface SpotAssignmentStartegy {
    Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate);
}
