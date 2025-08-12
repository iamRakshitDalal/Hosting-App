package com.hosting.hosting.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hosting.hosting.app.model.UserDetail;
import com.hosting.hosting.app.model.UserDetailCombime;
import com.hosting.hosting.app.service.user.UserDetailServicesImpl;
import com.hosting.hosting.app.service.user.UserServices;
import com.hosting.hosting.app.utilis.JwtUtil;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//End point 

//  /hosting/public/health-check
@RequestMapping("/public")
@Slf4j
@RestController
public class PublicController {
    
    @Autowired 
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServicesImpl userDetailServices;

    @Autowired
    private UserServices userServices;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Ok";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDetail userDetail) {
        try{
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDetail.getUsername(), userDetail.getPassword()));
            UserDetails userDetails = userDetailServices.loadUserByUsername(userDetail.getUsername());
            return new ResponseEntity<>(jwtUtil.genrateToken(userDetails.getUsername()),HttpStatus.OK);
        }
        catch(Exception e){
            log.error("Exception occurred while createAuthenticationToken  ", e);
            return new ResponseEntity<>("Incorrect username or password",HttpStatus.BAD_REQUEST);
        }
    }
   
    
    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody UserDetailCombime userDetailCombime) {
        String s=userServices.saveUser(userDetailCombime.getUserDetail(),userDetailCombime.getUser());
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }  
    
    
}
