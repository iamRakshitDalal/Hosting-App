package com.hosting.hosting.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private int id;
    private String title;
    private String description;
}
