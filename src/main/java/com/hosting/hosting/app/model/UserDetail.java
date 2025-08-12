package com.hosting.hosting.app.model;

import java.util.List;


import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    private int id;
    @NonNull
    private String username;  
    @NonNull
    private String password;
    private List<String> roles;
}