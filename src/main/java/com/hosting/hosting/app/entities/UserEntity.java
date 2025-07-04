package com.hosting.hosting.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "UserData")
public class UserEntity {
    @Id
    private String email;
    private String fullName;    
    private String password;
    private String company;
    private String address;
    private String city;
    private String state;
    private long zipCode;
    private String country;
    private long mobileNumber;
    
}