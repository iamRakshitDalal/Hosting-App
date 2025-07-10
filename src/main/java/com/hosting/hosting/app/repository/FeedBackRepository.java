package com.hosting.hosting.app.repository;

import com.hosting.hosting.app.entities.FeedBackEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FeedBackRepository extends JpaRepository<FeedBackEntity,Long> {
    
}
