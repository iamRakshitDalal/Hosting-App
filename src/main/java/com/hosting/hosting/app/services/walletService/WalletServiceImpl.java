package com.hosting.hosting.app.services.walletService;

import org.springframework.stereotype.Service;

import com.hosting.hosting.app.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService {
    private WalletRepository walletRepository;

    WalletServiceImpl(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }
    @Override
    public Long walletBalance(String email) {
        return  walletRepository.findById(email).get().getBalance();
    }
    
}
