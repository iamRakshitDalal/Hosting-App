package com.hosting.hosting.app.services.ticketService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.hosting.hosting.app.entities.TicketEntity;
import com.hosting.hosting.app.model.Ticket;
import com.hosting.hosting.app.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    TicketServiceImpl(TicketRepository ticketRepository){
        this.ticketRepository =ticketRepository;
    }

    @Override
    public String raiseTicket(Ticket ticket){
        TicketEntity ticketEntity = new TicketEntity();
        ticket.setStatus("processing");
        BeanUtils.copyProperties(ticket, ticketEntity);
        ticketRepository.save(ticketEntity);
        return "Ticket has been raised";
    }

    @Override
    public List<Ticket> readRaiseTicketByUser(String email) {
        List<TicketEntity> ticketEntities = ticketRepository.findAllByEmail(email);
        return ticketEntities.stream().map(ticket -> new Ticket(ticket.getId(),ticket.getEmail(),ticket.getName(),ticket.getMobileNumber(),ticket.getDomainName(),ticket.getDateOfTicketRaise(),ticket.getStatus(),ticket.getMessage())).collect(Collectors.toList());
    }

    @Override
    public List<Ticket> readAllTicket() {
        List<TicketEntity> ticketEntities = ticketRepository.findAllByStatus("processing");
        return ticketEntities.stream().map(ticket ->new Ticket(ticket.getId(),ticket.getEmail(),ticket.getName(),ticket.getMobileNumber(),ticket.getDomainName(),ticket.getDateOfTicketRaise(),ticket.getStatus(),ticket.getMessage())).collect(Collectors.toList());
    }

    @Override
    public String DeleteTicket(Long id) {
        Optional<TicketEntity> optional = ticketRepository.findById(id);
        if(optional.isPresent()){
            ticketRepository.delete(optional.get());
            return "Delete Successfully";
        }
        return "Not Find";
    }

    @Override
    public String raiseTicketUpdate(Ticket ticket) {
        if(ticketRepository.existsById(ticket.getId())){
            TicketEntity ticketEntity = new TicketEntity();
            BeanUtils.copyProperties(ticket, ticketEntity);
            ticketRepository.save(ticketEntity);
            return "Update Successfully";
        }
        return "Not Find"; 
    }
    
}
