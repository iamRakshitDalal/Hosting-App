package com.hosting.hosting.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosting.hosting.app.entities.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity,Long>{

    List<TicketEntity> findAllByEmail(String email);

    List<TicketEntity> findAllByStatus(String string);
   
}
