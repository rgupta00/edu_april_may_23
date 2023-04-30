package com.bankapp.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
@Import(DbConfig.class)
public class AppConfig {
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager txMgr=new HibernateTransactionManager();
        txMgr.setSessionFactory(sessionFactory);
        return  txMgr;
    }
    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
        lsfb.setDataSource(dataSource);
        lsfb.setPackagesToScan(new String[] {"com.bankapp.model.entities"});
        lsfb.setHibernateProperties(getProperties());
        return  lsfb;
    }
    private Properties getProperties(){
        Properties properties=new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");
        return  properties;
    }
}
