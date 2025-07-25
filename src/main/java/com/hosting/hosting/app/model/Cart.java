package com.hosting.hosting.app.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String email;
    private String domianName;
    private float domainPricePerYear;
    private int rentForTime;
}
