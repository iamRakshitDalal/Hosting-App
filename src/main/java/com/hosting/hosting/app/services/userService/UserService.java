package com.hosting.hosting.app.services.userService;

import com.hosting.hosting.app.model.User;

public interface UserService {
    String register(User user);
    User login(String email,String password);
    String upateUser(User user);
    String deleteUser(String email);
    String UpdatePassword(String email,String password);
    
} 