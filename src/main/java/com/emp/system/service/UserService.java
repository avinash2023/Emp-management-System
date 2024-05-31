package com.emp.system.service;

import com.emp.system.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    List<User> store=new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Durgesh","durgesh@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Sahil","sahil@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Avinash","avinash@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Mayank","manank@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Harpreet","harpreet@gmail.com"));
    }
    public List<User>getUser(){
        return this.store;
    }
}