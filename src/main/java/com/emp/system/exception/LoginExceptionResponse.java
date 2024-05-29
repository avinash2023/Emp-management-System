package com.emp.system.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class LoginExceptionResponse extends ErrorResponse{


    String errorTitle;

    public LoginExceptionResponse() {
        super(HttpStatus.UNAUTHORIZED);
    }
}