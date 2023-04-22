package com.demo;

import org.springframework.stereotype.Component;

// <bean id="tyre2" class="com.demo.MrfTyre"/>
@Component(value = "tyre2")
public class MrfTyre implements Tyre{
    public  void rotate(){
        System.out.println("mrf tyre");
    }
}
