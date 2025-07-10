package com.hosting.hosting.app.entities;

import java.util.ArrayList;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Wallet")
public class WalletEntity {
    @Id
    private String email;
    private Float balance;
    private Map<String,ArrayList<String>> transactionHistory;
        
}
