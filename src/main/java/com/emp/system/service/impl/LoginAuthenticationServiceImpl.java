package com.emp.system.service.impl;

import com.emp.system.jwt.JwtHelper;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.LoginRequest;
import com.emp.system.model.LoginResponse;
import com.emp.system.service.LoginAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationServiceImpl implements LoginAuthenticationService {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;
    @Override
    public ApiResponse<LoginResponse> login(LoginRequest request) {
        ApiResponse<LoginResponse> apiResponse=new ApiResponse<>();
        this.doAuthenticate(request.getUserName(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        String token = this.helper.generateToken(userDetails);

        LoginResponse response = LoginResponse.builder()
                .token(token)
                .userName(userDetails.getUsername()).build();
        apiResponse.setData(response);
        return apiResponse;
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credentials Invalid !!");
        }

    }
}
