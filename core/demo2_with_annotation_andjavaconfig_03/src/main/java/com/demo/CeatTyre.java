package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// <bean id="tyre1" class="com.demo.CeatTyre" primary="true"/>
@Component(value = "tyre1")
@Primary
public class CeatTyre implements Tyre{
    public  void rotate(){

        System.out.println("ceat tyre");
    }
}
