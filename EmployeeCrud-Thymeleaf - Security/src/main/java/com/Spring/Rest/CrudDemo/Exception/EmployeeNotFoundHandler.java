package com.Spring.Rest.CrudDemo.Exception;

import com.Spring.Rest.CrudDemo.entity.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.function.EntityResponse;

@ControllerAdvice
public class EmployeeNotFoundHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handler(EmployeeNotFoundException exc){
        EmployeeErrorResponse error=new EmployeeErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handler(Exception exc){
        EmployeeErrorResponse error=new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
