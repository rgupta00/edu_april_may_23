package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("demo.xml");

        //beans are configure eagerly
        Foo foo=context.getBean("foo", Foo.class);

        System.out.println(foo.hashCode());

        Foo foo2=context.getBean("foo", Foo.class);

        System.out.println(foo2.hashCode());
        //System.out.println(foo.getMessage());
    }
}
