package com.bankapp.model.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    //Wildcard?
//    @Around("execution(public void com.bankapp.model.service.AccountServiceImpl.transfer(..))")
    //hey any visibity any return type package should be "com.bankapp.model.service" any class any method, taking any no of arguments

//    @Pointcut("execution( * com.bankapp.model.service..*.*(..))")
//    public void allMethodsOfSericeLayer(){}

   // @Around("allMethodsOfSericeLayer()")
    //@Around("@annoation(MyAppLogging.class)")
    //Step 2: tell AOP about it
   @Around("@annotation(MyAppLogging)")
    public Object aroundLogging(ProceedingJoinPoint joinPoint)throws Throwable{

        String targetMethodName= joinPoint.getSignature().getName();
        logger.info(targetMethodName+" method is started");
        long start=System.currentTimeMillis();

        Object result=joinPoint.proceed();

        long end=System.currentTimeMillis();
        long timeTaken= end-start;
        logger.info(targetMethodName+" method is finished {}",timeTaken);

        return result;
    }
}
