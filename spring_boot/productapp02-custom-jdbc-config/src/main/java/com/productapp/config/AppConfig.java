package com.productapp.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.productapp")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@Import(DbConfig.class)
public class AppConfig {
    @Bean
    @Primary
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    @Bean
    public JdbcTransactionManager getJdbcTransactionManager(DataSource dataSource){
        JdbcTransactionManager jdbcTransactionManager=
                new JdbcTransactionManager(dataSource);
        return jdbcTransactionManager;
    }
}
