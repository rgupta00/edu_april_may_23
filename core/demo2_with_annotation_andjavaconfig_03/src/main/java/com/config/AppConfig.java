package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
<context:annotation-config/><!--hey spring i want to go for annotation based apparch-->
    <context:component-scan base-package="com.demo"/> <!--hey spring why not u do compoent scan of the pacakge com.demo-->

 */
@Configuration
@ComponentScan(basePackages = "com.demo")
public class AppConfig {
}
