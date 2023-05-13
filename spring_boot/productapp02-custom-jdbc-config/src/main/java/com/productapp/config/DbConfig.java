package com.productapp.config;//package com.bankapp.config;
//
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DbConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driverClassName}")
    private String driverName;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean(name = "datasource")
    public DriverManagerDataSource getDriverManagerDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setDriverClassName(driverName);
        ds.setUsername(username);
        ds.setPassword(password);
        return  ds;
    }
}
