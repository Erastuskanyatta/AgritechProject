<<<<<<< HEAD
package com.example.agritech.WebApp.ValidationHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
           Map<String, String> errors = new HashMap<>();
           ex.getBindingResult().getAllErrors().forEach((error) ->{
          String fieldName = ((FieldError) error).getField();
          String message = error.getDefaultMessage();
          errors.put(fieldName, message);
      });
           return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
=======
package com.example.agritech.WebApp.ValidationHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
           Map<String, String> errors = new HashMap<>();
           ex.getBindingResult().getAllErrors().forEach((error) ->{
          String fieldName = ((FieldError) error).getField();
          String message = error.getDefaultMessage();
          errors.put(fieldName, message);
      });
           return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
