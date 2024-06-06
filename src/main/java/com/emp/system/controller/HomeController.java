package com.emp.system.controller;
import com.emp.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import com.emp.system.model.User;

@RestController
@RequestMapping("/welcome")
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public List<User> getUser(){
        return userService.getUser();
    }
    @GetMapping("/userId")
    public String getUserId(Principal principal){
        return principal.getName();
    }

}
