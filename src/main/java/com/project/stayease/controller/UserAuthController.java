package com.project.stayease.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stayease.DTOs.JwtResponse;
import com.project.stayease.DTOs.LoginRequest;
import com.project.stayease.DTOs.UserDTO;
import com.project.stayease.config.JwtService;
import com.project.stayease.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@Slf4j

public class UserAuthController {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthController.class);


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;




    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        logger.info("Creating user: {}", userDTO.getUsername());
       // UserDTO user = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if (loginRequest == null || loginRequest.getPassword() == null || loginRequest.getUsername() == null) {
            log.error("Invalid sign up request: {}", loginRequest);
            throw new IllegalArgumentException("Request cannot be null or missing required fields");
        }

        logger.info("Attempting to log in user: {}", loginRequest.getUsername());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        logger.info("User {} logged in successfully", loginRequest.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
