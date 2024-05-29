package com.emp.system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class LoginException extends Exception{
    private String message;
    private int statusCode;
    @Getter
    private String title;

    public LoginException(String message, String title){
        super(message);
        this.message=message;
        this.title=title;

    }




}
