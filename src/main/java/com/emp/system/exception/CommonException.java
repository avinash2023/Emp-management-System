package com.emp.system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@NoArgsConstructor
@AllArgsConstructor
public class CommonException extends Exception{
    @Getter
    private String message;
    @Getter
    private HttpStatus status;
    @Getter
    private String errorSection;
    @Getter
    private Integer errorCode;

    public CommonException(String errorMessage,HttpStatus status){
        super(errorMessage);
        this.message=errorMessage;
        this.errorCode=status.value();
        this.status=status;
    }
    public CommonException(String errorMessage,HttpStatus status,String errorSection){
        super(errorMessage);
        this.message=errorMessage;
        this.errorCode=status.value();
        this.status=status;
        this.errorSection=errorSection;
    }
    public CommonException(String errorMessage,HttpStatus status,Integer errorCode){
        super(errorMessage);
        this.message=errorMessage;
        this.errorCode=errorCode;
        this.status=status;
    }
}
