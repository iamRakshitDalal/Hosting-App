package com.hosting.hosting.app.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String email;
    private String domainName;    
    private LocalDateTime ExpireDate;
    private Long sellingPrice;
    private Long price;
    private String renewTime;
}
