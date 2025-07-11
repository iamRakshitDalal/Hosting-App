package com.hosting.hosting.app.entities;

import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Wallet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletEntity {
    @Id
    private String email;
    private Float balance;
    private Map<String,List<String>> transactionHistory;
        
}
