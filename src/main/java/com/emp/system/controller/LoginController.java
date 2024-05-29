package com.emp.system.controller;

import com.emp.system.model.LoginDto;
import com.emp.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value="/login")
    public ResponseEntity<String> login(LoginDto loginDto){
        String response=loginService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
