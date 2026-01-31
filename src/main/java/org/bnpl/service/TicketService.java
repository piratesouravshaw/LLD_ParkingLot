package org.bnpl.service;

import org.bnpl.exceptions.InvalidGateException;
import org.bnpl.exceptions.NoAvailableParkingSpot;
import org.bnpl.model.*;
import org.bnpl.repository.GateRepository;
import org.bnpl.repository.ParkingLotRepository;
import org.bnpl.repository.TicketRepository;
import org.bnpl.repository.VehicleRepository;
import org.bnpl.strategies.spotAllocationStrategy.SpotAssignmentStartegy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssignmentStartegy spotAssignmentStartegy;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository, SpotAssignmentStartegy spotAssignmentStartegy,TicketRepository ticketRepository,ParkingLotRepository parkingLotRepository)
    {
        this.gateRepository=gateRepository;
        this.vehicleRepository=vehicleRepository;
        this.spotAssignmentStartegy=spotAssignmentStartegy;
        this.ticketRepository=ticketRepository;
        this.parkingLotRepository=parkingLotRepository;
    }
    public Ticket generateTicket(Long gateId, VehicleType vehicleType,String vehicleNumber) throws NoAvailableParkingSpot,InvalidGateException {
        /*
        * Gate=get gate from that Id else throw an Exception
        * Operator = from gate
        * Vehicle= check if already present if yes get that. Else create
        *Parking spot=strategy
        * ticket ticket=
        *
        * */
        Optional<Gate> gateOptional=gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new InvalidGateException();
        }
        Gate gate=gateOptional.get();
        Operator operator=gate.getOperator();

        Optional<Vehicle>vehicleOptional=vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle vehicle;
        if(vehicleOptional.isEmpty()){
           vehicle=new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
        }
        else{
            vehicle=vehicleOptional.get();
        }
        ParkingLot parkingLot=parkingLotRepository.getParkingLotofGate(gate);
        Optional<ParkingSpot> parkingSpotOptional=spotAssignmentStartegy.findSpot(vehicleType,parkingLot,gate);
        ParkingSpot parkingSpot;
        if(parkingSpotOptional.isEmpty()){
            throw new NoAvailableParkingSpot();
        }
        else{
            parkingSpot=parkingSpotOptional.get();
        }
        Ticket ticket=new Ticket();
        ticket.setSpot(parkingSpot);
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setOperator(operator);
        ticket.setVehicle(vehicle);
        return ticketRepository.saveTicket(ticket);
    }

    // Builder approach when lot of parameters
//    public Ticket generateTicketBuilder(GenerateTicketBuilder builder)
//    {
//        return null;
//    }
}
