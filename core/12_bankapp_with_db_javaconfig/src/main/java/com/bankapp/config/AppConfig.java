package com.bankapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@EnableConfigurationProperties
@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
@PropertySource("classpath:db.properties")
@Import(DbConfig3.class)
public class AppConfig {


}



