package com.emp.system.controller;

import com.emp.system.model.ApiResponse;
import com.emp.system.model.LoginDto;
import com.emp.system.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value="/login")
    public ResponseEntity<ApiResponse<String>> login(LoginDto loginDto) throws Exception{
        ApiResponse<String> response=loginService.login(loginDto);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
