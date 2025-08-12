package com.hosting.hosting.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/user")
@RestController 
public class UesrController {
    
    @GetMapping("/hello")
    public String getMethodName() {
        return "ok";
    }
    
}
