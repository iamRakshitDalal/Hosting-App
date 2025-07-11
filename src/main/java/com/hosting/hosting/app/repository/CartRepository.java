package com.hosting.hosting.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosting.hosting.app.entities.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity,String>  {

    Optional<CartEntity> findByEmail(String email);
    
}

