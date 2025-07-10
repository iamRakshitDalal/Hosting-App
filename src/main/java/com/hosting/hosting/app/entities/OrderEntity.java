package com.hosting.hosting.app.entities;


import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity 
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    private String email;
    private Map<String,List<String>> domainDetails;
    
}
