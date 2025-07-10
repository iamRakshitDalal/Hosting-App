package com.hosting.hosting.app.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String email;
    private String domainName;  
    private float pricePerYear;  
    private LocalDate ExpireDate;
    private LocalDate renewPeriod;
    
    
}
