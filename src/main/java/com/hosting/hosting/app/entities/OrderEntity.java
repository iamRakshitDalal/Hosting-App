package com.hosting.hosting.app.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity 
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    private String orderId;
    private String email;
    private String domainName;    
    private LocalDateTime ExpireDate;
    private Long sellingPrice;
    private Long price;
    private String renewTime;
}
