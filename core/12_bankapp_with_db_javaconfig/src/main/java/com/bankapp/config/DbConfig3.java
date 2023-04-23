package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
//@PropertySource("classpath:db.properties")
@PropertySources({
        @PropertySource("classpath:db.properties"),
        //@PropertySource("classpath:org/springframework/context/annotation/p1.properties")
})
public class DbConfig3 {

    @Autowired
    private  DbProp dbProp;

    @Bean(name = "datasource")
    public DriverManagerDataSource getDriverManagerDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUrl(dbProp.getUrl());
        ds.setDriverClassName(dbProp.getDriverName());
        ds.setUsername(dbProp.getUsername());
        ds.setPassword(dbProp.getPassword());
        return  ds;
    }
}
