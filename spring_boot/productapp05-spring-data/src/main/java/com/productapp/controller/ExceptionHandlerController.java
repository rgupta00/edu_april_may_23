package com.productapp.controller;

import com.productapp.dto.ErrorMessage;
import com.productapp.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

//THrows adv of AOP
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage>handle404(ProductNotFoundException ex){
        ErrorMessage errorMessage=ErrorMessage.builder()
                .errorMessage(ex.getMessage())
                .contact("rgupta.mtech@gmail.com")
                .errorCode(HttpStatus.NOT_FOUND.toString())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage>handle500(RuntimeException ex){
        ErrorMessage errorMessage=ErrorMessage.builder()
                .errorMessage("internal server error , try after some time")
                .contact("rgupta.mtech@gmail.com")
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    //MethodArgumentNotValidException

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage>handle400(MethodArgumentNotValidException ex){
        //what goes wrong?
        String errorMessageString=
                ex.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(x->x.getDefaultMessage())
                        .collect(Collectors.joining(", "));

        ErrorMessage errorMessage=ErrorMessage.builder()
                .errorMessage(errorMessageString)
                .contact("rgupta.mtech@gmail.com")
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
