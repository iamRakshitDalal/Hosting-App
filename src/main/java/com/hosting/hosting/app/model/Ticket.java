package com.hosting.hosting.app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private long id;
    private String email;
    private String name;
    private long mobileNumber;
    private String domainName;
    private LocalDateTime dateOfTicketRaise;
    private String status; 
    private ArrayList<String> message;
    

    
        
}
