package com.bankapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
@PropertySource("classpath:db.properties")
@EnableAspectJAutoProxy
public class AppConfig {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverName}")
    private String driver;

    @Bean
    public DriverManagerDataSource getDriverManagerDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        ds.setDriverClassName(driver);
        return  ds;
    }
}
