package com.productapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan
public class AppConfig {
    @Profile("test")
    @Bean
    public Foo getFoo(){
        Foo foo=new Foo();
        foo.setFoo("test");
        return  foo;
    }
    @Profile("dev")
    @Bean
    public Foo getFoo2(){
        Foo foo=new Foo();
        foo.setFoo("dev");
        return  foo;
    }
}
