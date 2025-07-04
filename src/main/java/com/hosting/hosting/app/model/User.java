package com.hosting.hosting.app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String fullName;
    @Email(message = "Invalid email format")
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    private String company;
    private String address;
    private String city;
    private String state;
    private long zipCode;
    private String country;
    private long mobileNumber;
}
   
