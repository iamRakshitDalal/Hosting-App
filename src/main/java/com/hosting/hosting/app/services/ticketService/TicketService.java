package com.hosting.hosting.app.services.ticketService;

import java.util.ArrayList;
import java.util.List;

import com.hosting.hosting.app.model.Ticket;

public interface TicketService {
    String raiseTicket(Ticket ticket);
    List<Ticket> readRaiseTicketByUser(String email);
    List<Ticket> readAllTicket();
    
}
