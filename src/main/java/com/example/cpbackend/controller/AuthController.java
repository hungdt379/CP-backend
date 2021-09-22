package com.example.cpbackend.controller;

import com.example.cpbackend.apiresponse.ApiResponse;
import com.example.cpbackend.config.JwtUtils;
import com.example.cpbackend.entity.LoginRequest;
import com.example.cpbackend.entity.LoginResponse;
import com.example.cpbackend.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    ApiResponse apiResponse;

    @PostMapping(path = "/login", consumes = "application/json")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try {
            authenticate(loginRequest.getUsername(),loginRequest.getPassword());
        }catch (BadCredentialsException e){
            return apiResponse.errorResponse(e.getMessage(), HttpStatus.BAD_REQUEST, false);
        }
        UserDetails u = jwtUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String token = jwtUtils.generateToken(u);
        return ResponseEntity.ok(new LoginResponse(token, "Login successful", true));
    }

    private void authenticate(String name, String pass) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name,pass));
    }
}
