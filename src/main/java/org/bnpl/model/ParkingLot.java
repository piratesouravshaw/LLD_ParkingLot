package org.bnpl.model;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor>floor;
    private List<Gate>gate;
    int capacity;

    public List<ParkingFloor> getFloor() {
        return floor;
    }

    public void setFloor(List<ParkingFloor> floor) {
        this.floor = floor;
    }

    public List<Gate> getGate() {
        return gate;
    }

    public void setGate(List<Gate> gate) {
        this.gate = gate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
