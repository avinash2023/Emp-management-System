package com.emp.system.service;

import com.emp.system.model.ApiResponse;
import com.emp.system.model.LoginRequest;
import com.emp.system.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginAuthenticationService {
    ApiResponse<LoginResponse> login(LoginRequest request);
}
