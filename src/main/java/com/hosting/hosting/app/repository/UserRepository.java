package com.hosting.hosting.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosting.hosting.app.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,String>{
    Optional<UserEntity> findByEmail(String email);
}
