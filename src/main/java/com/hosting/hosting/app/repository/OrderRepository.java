package com.hosting.hosting.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosting.hosting.app.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,String>  {

    Optional<OrderEntity> findByEmail(String email);
    
}

