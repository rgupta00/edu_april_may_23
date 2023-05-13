package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private  Foo foo;

    @Value("${my.app:not found}")
    private String value;

    @GetMapping(path = "hello")
    public String hello(){
        System.out.println(foo.getFoo());
        return "hello .."+ value;
    }
}
