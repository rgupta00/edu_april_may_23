package com.productapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping(path = "welcome")
    public String hello(){
        return "hello";
    }
}
