package org.bnpl.controllers;

import org.bnpl.dto.GenerateTicketRequestDto;
import org.bnpl.dto.GenerateTicketResponseDto;
import org.bnpl.exceptions.InvalidGateException;
import org.bnpl.exceptions.NoAvailableParkingSpot;
import org.bnpl.model.*;
import org.bnpl.service.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto)  {
         String vehicleNumber=generateTicketRequestDto.getVehicleNumber();
         VehicleType vehicleType=generateTicketRequestDto.getVehicleType();
         Long gateId=generateTicketRequestDto.getGateId();
        Ticket ticket;
        GenerateTicketResponseDto ticketResponseDto=new GenerateTicketResponseDto();
        try {
             ticket = ticketService.generateTicket(gateId, vehicleType, vehicleNumber);
            ticketResponseDto.setTicketId(ticket.getId());
            ticketResponseDto.setSpotNumber(ticket.getSpot().getNumber());
            ticketResponseDto.setOperatorName(ticket.getOperator().getName());
            ticketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(InvalidGateException ex){
            ticketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            ticketResponseDto.setMsg("GateId is null");
        }
        catch(NoAvailableParkingSpot ex){
            ticketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            ticketResponseDto.setMsg("No Parking Spot Available");
        }


        return ticketResponseDto;
    }
}
