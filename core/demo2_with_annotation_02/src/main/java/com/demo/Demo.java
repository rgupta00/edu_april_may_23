package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
        Car car= (Car) ctx.getBean("car");

        car.move();


//       Car car=new Car();
//       car.setCarName("tata nano");
//       car.setTyre(new CeatTyre());//Manual DI :(
//
//       car.move();
    }
}
