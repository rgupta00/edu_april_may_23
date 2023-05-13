package com.productapp;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id="myendpoint")
@Component
public class MyCustomerActuator {
    @Bean @ReadOperation
    public String endPoint(){
        return "hello to custom endpoint";
    }
}
