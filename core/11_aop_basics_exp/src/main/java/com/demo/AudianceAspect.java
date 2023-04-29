package com.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudianceAspect {
    @After("execution(public void doMagic())")
    public void clapping(){
        System.out.println("clapping we enjoyed a lot!");
    }
}
