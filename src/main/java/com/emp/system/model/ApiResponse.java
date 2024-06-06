package com.emp.system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiResponse<T> implements Serializable {
    private HttpStatus status;
    private Integer statusCode;
    private String responseMessage;
    private T data;

    public ApiResponse() {
        status= HttpStatus.OK;
        statusCode= HttpStatus.OK.value();
    }

    public ApiResponse(HttpStatus status) {
        this.status=status;
        this.statusCode= status.value();
    }
}
