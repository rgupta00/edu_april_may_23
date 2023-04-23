//package com.bankapp.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//@Configuration
//@PropertySource("classpath:db.properties")
//public class DbConfig {
//    @Value("${jdbc.url}")
//    private String url;
//
//    @Value("${jdbc.driverName}")
//    private String driverName;
//
//    @Value("${jdbc.username}")
//    private String username;
//
//    @Value("${jdbc.password}")
//    private String password;
//
//    @Bean(name = "datasource")
//    public DriverManagerDataSource getDriverManagerDataSource(){
//        DriverManagerDataSource ds=new DriverManagerDataSource();
//        ds.setUrl(url);
//        ds.setDriverClassName(driverName);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        return  ds;
//    }
//}
