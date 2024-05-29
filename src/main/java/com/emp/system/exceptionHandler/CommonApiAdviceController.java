package com.emp.system.exceptionHandler;


import com.emp.system.exception.CommonException;
import com.emp.system.exception.LoginException;
import com.emp.system.exception.LoginExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.emp.system.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class CommonApiAdviceController extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(CommonApiAdviceController.class);


    /**
     * Handler method for CommonException.
     * @param request
     * @param exception
     * @return GenericResponse
     */
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorResponse> handleCommonException(HttpServletRequest request, CommonException exception) {
        ErrorResponse  response = getErrorResponse(exception.getStatus(), Arrays.asList(exception.getMessage()).stream().collect(Collectors.toSet()));
        response.setErrorSection(exception.getErrorSection() !=null ? exception.getErrorSection() : "");
        return new ResponseEntity<>(response, null, response.getStatus().value());
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ErrorResponse> handleLoginException(HttpServletRequest request, LoginException exception){
        LoginExceptionResponse loginExceptionResponse = new LoginExceptionResponse();
        loginExceptionResponse.setErrors(Arrays.asList(exception.getMessage()).stream().collect(Collectors.toSet()));
        loginExceptionResponse.setErrorTitle(exception.getTitle());
        return new ResponseEntity<>(loginExceptionResponse, null, HttpStatus.UNAUTHORIZED.value());
    }

    private ErrorResponse getErrorResponse(HttpStatus status, Set<String> errors){
        ErrorResponse errorResponse = new ErrorResponse(status);
        errorResponse.setErrors(errors);
        errorResponse.setData(null);
        errorResponse.setErrorDetails("");
        return errorResponse;
    }
}
