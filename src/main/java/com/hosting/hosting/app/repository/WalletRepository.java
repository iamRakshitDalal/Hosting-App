package com.hosting.hosting.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hosting.hosting.app.entities.WalletEntity;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity,String>  {
    
}
