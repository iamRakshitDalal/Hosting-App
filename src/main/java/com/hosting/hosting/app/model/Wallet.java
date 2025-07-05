package com.hosting.hosting.app.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wallet {
    private String email;
    private long balance;
    private ArrayList<ArrayList<String>> transactionHistory;
}
