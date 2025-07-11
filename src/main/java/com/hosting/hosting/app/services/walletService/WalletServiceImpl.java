package com.hosting.hosting.app.services.walletService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hosting.hosting.app.entities.WalletEntity;
import com.hosting.hosting.app.model.Wallet;
import com.hosting.hosting.app.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService {
    private WalletRepository walletRepository;

    WalletServiceImpl(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

     
    @Override
    public Float walletBalance(String email) {
        return  walletRepository.findById(email).get().getBalance();
    }


    @Override
    public List<List<String>> transationHistory(String email) {
        return  walletRepository.findById(email).get().getTransactionHistory();
    }


    @Override
    public void createWallet(String email) {
        WalletEntity walletEntity= new WalletEntity();
        walletEntity.setBalance(0);
        walletEntity.setEmail(email);
        walletEntity.setTransactionHistory(null);
        walletRepository.save(walletEntity);
        return;
    }

    @Override
    public Long updateWalletBalance(Wallet wallet) {
        Optional<WalletEntity> optional = walletRepository.findById(wallet.getEmail());
        if(optional.isPresent()){
            WalletEntity walletEntity = optional.get();
            walletEntity.setBalance(wallet.getBalance()+wallet.getBalance());
            walletEntity.setTransactionHistory(walletEntity.getTransactionHistory().put(wallet.getDomainName(), null));
        }
        return null;
    }

    
}
