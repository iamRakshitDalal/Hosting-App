package com.hosting.hosting.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hosting.hosting.app.model.Ticket;
import com.hosting.hosting.app.model.User;
import com.hosting.hosting.app.services.ticketService.TicketService;
import com.hosting.hosting.app.services.userService.UserService;
import com.hosting.hosting.app.services.walletService.WalletService;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HostingController {
    
    private WalletService walletService;
    private UserService userService;
    private TicketService ticketService;
    HostingController(UserService userService,WalletService walletService,TicketService ticketService){
        this.userService = userService;
        this.walletService = walletService;
        this.ticketService= ticketService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        User user =userService.login(email, password);
        if(user == null){
            return ResponseEntity.ok("Wrong Login Credential");
        }
        return ResponseEntity.ok(user);
    }
    @PostMapping("/register")
    public String register(@RequestBody @Valid User user) {
        return userService.register(user) ;
    }
 
    @GetMapping("/wallet")
    public Long getWalletBalance(@RequestParam String email) {
        return walletService.walletBalance(email) ;
    }

    @GetMapping("/wallet/Transactions")
    public ArrayList<ArrayList<String>> getTransactionHistory(@RequestParam String email) {
        return walletService.transationHistory(email) ;
    }

   /*  @PostMapping("/wallet/addmoney")                               x
    public String addmoney() {
        
        
        return "working";
    } */

    @PostMapping("/raiseTicket")
    public String raiseTicket(@RequestBody Ticket ticket) {
        return ticketService.raiseTicket(ticket);
    } 

    @GetMapping("/userTickets")
    public List<Ticket> getMethodName(@RequestParam String email) {
        return ticketService.readRaiseTicketByUser(email);
    }
    
    
        
    
    
}


