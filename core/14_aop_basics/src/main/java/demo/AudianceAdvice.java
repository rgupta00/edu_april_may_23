package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect //aspect= advice + pointcut
public class AudianceAdvice {
    @Before("execution(public void doMagic())")
    public void clapping(JoinPoint joinPoint){
        System.out.println("**********"+joinPoint.getSignature().getName());
        System.out.println("clapping we enjoyed a lot!==>before");
    }


//    @Pointcut("execution(public void doMagic())")
//    public void myPointCut(){}
//
//    @Before("myPointCut()")
//    public void clapping(JoinPoint joinPoint){
//        System.out.println("**********"+joinPoint.getSignature().getName());
//        System.out.println("clapping we enjoyed a lot!==>before");
//    }


    //how to get infor about the target method

    //Arond work like a filter
//    @Around("execution(public void doMagic())")
//    public Object clapping(ProceedingJoinPoint joinPoint)throws  Throwable{
//        System.out.println("before calling the target method");
//
//        //Object result=joinPoint.proceed();
//
//        System.out.println("after calling the target method");
//
//        return null;
//    }
//
//    @AfterThrowing(value = "execution(public void doMagic())" , throwing = "ex")
//    public void callTheDr(JoinPoint joinPoint, Exception ex){
//        System.out.println("**********"+joinPoint.getSignature().getName());
//        System.out.println("We got a ex: "+ex.getMessage());
//    }


//    @Before("execution(public void doMagic())")
//    public void clapping(JoinPoint joinPoint){
//        System.out.println("**********"+joinPoint.getSignature().getName());
//        System.out.println("clapping we enjoyed a lot!==>before");
//    }

    //@Afer and @AfterReturning
//    @After("execution(public void doMagic())")
//    public void clappingAfter(){
//        System.out.println("clapping we enjoyed a lot!===>After");
//    }
//
//    @AfterReturning("execution(public void doMagic())")
//    public void clappingAfterReturing(){
//        System.out.println("clapping we enjoyed a lot!===>AfterReturning");
//    }
}
