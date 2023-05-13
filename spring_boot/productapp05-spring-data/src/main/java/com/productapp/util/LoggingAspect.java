package com.productapp.util;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Aspect
@Log4j2
public class LoggingAspect {

    @AfterThrowing(pointcut = "execution( * com.productapp.service.*Impl.*(..))", throwing = "ex")
    public void loggingExceptions(Exception ex){
        log.error("some ex happens in service layer"+ ex.getMessage());
        System.out.println("---------------------------------------------------------");
    }
}
