package com.hosting.hosting.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hosting.hosting.app.model.Ticket;
import com.hosting.hosting.app.services.ticketService.TicketService;
import com.hosting.hosting.app.services.userService.UserService;
import com.hosting.hosting.app.services.walletService.WalletService;

@RequestMapping("/ticket")
@RestController
public class TicketController {

    private TicketService ticketService;

    TicketController(UserService userService,WalletService walletService,TicketService ticketService){
        this.ticketService= ticketService;
    }


    @PostMapping("/raise")
    public String raiseTicket(@RequestBody Ticket ticket) {
        return ticketService.raiseTicket(ticket);
    } 

    @PostMapping("/Update")
    public String raiseTicketUpdate(@RequestBody Ticket ticket) {
        return ticketService.raiseTicketUpdate(ticket);
    } 


    @GetMapping("/get")
    public List<Ticket> getMethodName(@RequestParam String email) {
        return ticketService.readRaiseTicketByUser(email);
    }

    @PostMapping("/delete")
    public String postMethodName(@RequestParam Long id) {
        return ticketService.DeleteTicket(id);
    }
    
}
