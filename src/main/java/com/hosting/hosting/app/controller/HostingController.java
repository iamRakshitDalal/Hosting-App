package com.hosting.hosting.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hosting.hosting.app.model.User;
import com.hosting.hosting.app.services.userService.UserService;
import com.hosting.hosting.app.services.walletService.WalletService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HostingController {
    
    private WalletService walletService;
    private UserService userService;
    HostingController(UserService userService,WalletService walletService){
        this.userService = userService;
        this.walletService = walletService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestAttribute @Valid String email, @RequestAttribute String password) {
        return ResponseEntity.ok( userService.login(email, password));
    }
    @PostMapping("/register")
    public String register(@RequestBody @Valid User user) {
        return userService.register(user) ;
    }

    @GetMapping("/wallet")
    public Long getWalletBalance(@RequestAttribute String email) {
        return walletService.walletBalance(email) ;
    }
    
    
    
}
