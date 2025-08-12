package com.hosting.hosting.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosting.hosting.app.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity,String>{

    
}