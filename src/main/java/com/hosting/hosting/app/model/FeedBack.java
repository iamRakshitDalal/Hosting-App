package com.hosting.hosting.app.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedBack{
    
    private long id;
    private String name;
    private String email;
    private LocalDateTime dateTime;
    private String title;
    private String description;
}