package com.productapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //Pathvaraible and request param
    @GetMapping(path = "hello/{name}/{city}")
    public String hello(@PathVariable(name = "name")String username,@PathVariable(name = "city")String city){
        return "hello you .."+ username+ " city name: "+ city;
    }
    //hello2?name=raja&city=noida       => pagination
    @GetMapping(path = "hello2")
    public String hello2(@RequestParam(name = "name")String name, @RequestParam(name = "city")String city){
        return "hello you .."+ name+ " city name: "+ city;
    }
}
