package com.hosting.hosting.app.services.userService;

import com.hosting.hosting.app.model.User;

public interface UserService {
    User login(String userName,String password);
    String register(User user);
    
} 