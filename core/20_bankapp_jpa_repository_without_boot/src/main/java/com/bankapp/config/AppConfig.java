package com.bankapp.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
        basePackages = "com.bankapp.model.repo",
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean",
        transactionManagerRef = "platformTransactionManager")
@ComponentScan(basePackages = {"com.bankapp"})
@Import(DbConfig.class)
public class AppConfig {

    //HibernateTransactionManager vs JpaTransactionManager
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        EntityManagerFactory emf=localContainerEntityManagerFactoryBean(dataSource).getObject();
        return  new JpaTransactionManager(emf);
    }
    //LocalContainerEntityManagerFactoryBean vs LocalContainerSessionFatory
    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan(new String[] {"com.bankapp.model.entities"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(getProperties());
        return factory;
    }
    private Properties getProperties(){
        Properties properties=new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        properties.setProperty("hibernate.show_sql","true");
        //properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");
        return  properties;
    }
}
