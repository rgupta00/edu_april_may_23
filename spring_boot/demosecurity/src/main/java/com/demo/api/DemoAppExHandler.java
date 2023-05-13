package com.demo.api;

import com.demo.dto.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

//@RestControllerAdvice
//public class DemoAppExHandler {
//
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ErrorInfo> handle403(){
//        ErrorInfo errorInfo=new ErrorInfo();
//        errorInfo.setMessage("you are not authorized to access this resource..");
//        errorInfo.setStatusCode(HttpStatus.FORBIDDEN.toString());
//        errorInfo.setStatusCode(HttpStatus.FORBIDDEN.toString());
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorInfo);
//    }
//}
