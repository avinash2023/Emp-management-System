package com.emp.system.service.impl;

import com.emp.system.exception.CommonException;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.LoginDto;
import com.emp.system.service.LoginService;
import net.bytebuddy.description.type.TypeList;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public ApiResponse<String> login(LoginDto loginDto) throws CommonException {
        ApiResponse<String> response=new ApiResponse<>();
        if(!("Harpreet".equalsIgnoreCase(loginDto.getEmployeeId()) || "Sahil".equalsIgnoreCase(loginDto.getEmployeeId()))){
            throw new CommonException("Invalid employee Id", HttpStatus.BAD_REQUEST,200);
        }
        response.setData("Harpreet");
        response.setResponseMessage("User Login Successfully.");
        return response;
    }
}
