package com.hosting.hosting.app.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Table(name = "Tickets")
@Entity
public class TicketEntity {

    @Id
    private long id;
    private String email;
    private String name;
    private long mobileNumber;
    private String domainName;
    private LocalDateTime dateOfTicketRaise;
    private String status; 
    private ArrayList<String> message;
    
}
