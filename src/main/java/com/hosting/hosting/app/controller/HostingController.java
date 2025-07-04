package com.hosting.hosting.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hosting.hosting.app.model.User;
import com.hosting.hosting.app.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HostingController {

    private UserService userService;
    HostingController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@RequestAttribute String userName, @RequestAttribute String password) {
        User user = userService.login(userName, password);
        return user;
    }
    
    
}
