package com.emp.system.service.impl;

import com.emp.system.exception.CommonException;
import com.emp.system.model.LoginDto;
import com.emp.system.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String login(LoginDto loginDto) throws CommonException {
        if(!("Harpreet".equalsIgnoreCase(loginDto.getEmployeeId()) || "Sahil".equalsIgnoreCase(loginDto.getEmployeeId()))){
            throw new CommonException("dms.invalid.request", HttpStatus.BAD_REQUEST,200);
        }
        return "User Login Successfully.";
    }
}
