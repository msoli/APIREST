package com.mikeio.config;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Inject
    private AngularProperties angularProperties;

    @Inject
    private DataSource dataSource;


    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        sessionFactory.setPackagesToScan(new String[]{"com.mikeio.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }


    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", angularProperties.getHibernate().getDialect());
        properties.put("hibernate.show_sql", angularProperties.getHibernate().getShowSql());
        properties.put("hibernate.format_sql", angularProperties.getHibernate().getFormatSql());
        return properties;
    }


    @Bean(name = "transactionManager")
    @Inject
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

}