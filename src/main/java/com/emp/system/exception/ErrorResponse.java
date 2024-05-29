package com.emp.system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private Integer statusCode;
    private String data;
    private String errorSection;
    private Set<String> errors;
    private String errorDetails;

    public ErrorResponse(HttpStatus status) {
        this.status=status;
        this.statusCode= status.value();
    }
}