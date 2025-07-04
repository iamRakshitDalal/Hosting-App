package com.hosting.hosting.app.services;

import com.hosting.hosting.app.model.User;

public interface UserService {
    User login(String userName,String password);
    String register(User user);
    
} 