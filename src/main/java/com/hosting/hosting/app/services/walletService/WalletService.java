package com.hosting.hosting.app.services.walletService;

import java.util.List;

import com.hosting.hosting.app.model.Wallet;

public interface WalletService {
    Float walletBalance(String email);
    List<List<String>> transationHistory(String email);
    void createWallet(String email);
    public Long updateWalletBalance(Wallet wallet);
}
