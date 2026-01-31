package org.bnpl.model;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> spot;
    int floorNo;

    public List<ParkingSpot> getSpot() {
        return spot;
    }

    public void setSpot(List<ParkingSpot> spot) {
        this.spot = spot;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
}
