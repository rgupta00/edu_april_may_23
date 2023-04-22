package com.demo;

import com.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {

//        ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        Car car= (Car) ctx.getBean("car");

        car.move();


//       Car car=new Car();
//       car.setCarName("tata nano");
//       car.setTyre(new CeatTyre());//Manual DI :(
//
//       car.move();
    }
}
