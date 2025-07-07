package com.hosting.hosting.app.entities;

import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;

@Entity
public class CartEntity {
    private String email;
    private Map<String,List<String>> domianDetails;
}
