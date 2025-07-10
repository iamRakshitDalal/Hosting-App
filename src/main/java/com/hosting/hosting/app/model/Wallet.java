package com.hosting.hosting.app.model;

import java.time.LocalDate;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wallet {
    private String email;
    private Float balance;
    private String DomainName;
    private Float priceOfDomain;
    private LocalDate date;
}
