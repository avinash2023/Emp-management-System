package com.emp.system.controller;

import com.emp.system.jwt.JwtHelper;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.LoginRequest;
import com.emp.system.model.LoginResponse;
import com.emp.system.service.LoginAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class LoginAuthenticationController {

    @Autowired
    LoginAuthenticationService loginAuthenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        ApiResponse<LoginResponse> response=loginAuthenticationService.login(request);
        return new ResponseEntity<>(response,response.getStatus());
    }
        }
