package org.bnpl.repository;

import org.bnpl.model.Gate;
import org.bnpl.model.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long,ParkingLot>parkingLots=new TreeMap<>();
    public ParkingLot getParkingLotofGate(Gate gate){
        // delhi airpot , mumbai airport gate
        for(ParkingLot parkingLot: parkingLots.values()){
            if(parkingLot.getGate().contains(gate)){
                return parkingLot;
            }
        }
        return null;
    }
}
