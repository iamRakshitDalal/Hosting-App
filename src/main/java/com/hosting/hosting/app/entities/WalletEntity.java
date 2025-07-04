package com.hosting.hosting.app.entities;

import java.util.ArrayList;

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
    private long balance;
    private ArrayList<ArrayList<String>> transactionHistory;
}
