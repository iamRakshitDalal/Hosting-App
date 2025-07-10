package com.hosting.hosting.app.services.walletService;

import java.util.ArrayList;

import com.hosting.hosting.app.model.Wallet;

public interface WalletService {
    Long walletBalance(String email);
    ArrayList<ArrayList<String>> transationHistory(String email);
    void createWallet(String email);
    public Long updateWalletBalance(Wallet wallet);
}
