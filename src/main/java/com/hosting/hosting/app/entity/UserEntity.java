package com.hosting.hosting.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class UserEntity {

    
    
    @Id
    private String username; 
    private String email;
    private String name; 
    private String company;
    private String address;
    private String city;
    private String state;
    private long zipCode;
    private String country;
    private long mobileNumber;
}
