package org.bnpl;

import org.bnpl.controllers.TicketController;
import org.bnpl.repository.GateRepository;
import org.bnpl.repository.ParkingLotRepository;
import org.bnpl.repository.TicketRepository;
import org.bnpl.repository.VehicleRepository;
import org.bnpl.service.TicketService;
import org.bnpl.strategies.spotAllocationStrategy.SpotAssignmentStartegy;
import org.bnpl.strategies.spotAllocationStrategy.impl.RandomSpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        GateRepository gateRepository=new GateRepository();
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        TicketRepository ticketRepository=new TicketRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();

        SpotAssignmentStartegy spotAssignmentStartegy=new RandomSpotAssignmentStrategy();

        TicketService ticketService= new TicketService(gateRepository,vehicleRepository,spotAssignmentStartegy,ticketRepository,parkingLotRepository);
        TicketController ticketController=new TicketController(ticketService);

        System.out.println("Application has started");


    }
}