package com.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfig {

    @Autowired
    Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setHibernateProperties(hibernateProperties());
        bean.setPackagesToScan(new String[]{"com.springmvc.entity"});
        bean.setAnnotatedClasses(new Class[]{com.springmvc.entity.Todo.class});
        return bean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        source.setUrl(environment.getRequiredProperty("jdbc.url"));
        source.setUsername(environment.getRequiredProperty("jdbc.username"));
        source.setPassword(environment.getRequiredProperty("jdbc.password"));
        return source;
    }

    private Properties hibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        prop.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
//        prop.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        prop.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return prop;
    }

    @Bean
    public HibernateTemplate hibernateTemplate() {
        HibernateTemplate template = new HibernateTemplate();
        template.setSessionFactory(sessionFactory().getObject());
        return template;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory().getObject());
        return manager;
    }

}
