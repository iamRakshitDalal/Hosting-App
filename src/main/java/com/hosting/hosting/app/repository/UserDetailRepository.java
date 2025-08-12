package com.hosting.hosting.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosting.hosting.app.entity.UserDetailEntity;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity,Integer>{

    Optional<UserDetailEntity> findByUsername(String username);

    
}
