package com.emp.system.service;

import com.emp.system.model.ApiResponse;
import com.emp.system.model.LoginDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public ApiResponse<String> login(LoginDto loginDto) throws Exception;
}
