package com.hosting.hosting.app.services.walletService;

import java.util.ArrayList;

public interface WalletService {
    Long walletBalance(String email);
    ArrayList<ArrayList<String>> transationHistory(String email);
}
