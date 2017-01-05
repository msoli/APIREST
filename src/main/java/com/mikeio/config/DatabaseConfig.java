package com.mikeio.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;


import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by SISTEMAS03 on 04/05/2016.
 */
@Configuration
public class DatabaseConfig {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);

    //    @Inject
    private AngularProperties angularProperties;

    @Bean(name = "dataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


//    @Bean(name = "dataSource", destroyMethod = "close")
//    public DataSource getDataSource() {
//
//        Properties props = new Properties();
//        props.setProperty("dataSourceClassName", angularProperties.getDatabase().getDataSourceClassName());
//        props.setProperty("dataSource.url", angularProperties.getDatabase().getUrl());
//        props.setProperty("dataSource.user", angularProperties.getDatabase().getUsername());
//        props.setProperty("dataSource.password", angularProperties.getDatabase().getPassword());
//        props.setProperty("dataSource.cachePrepStmts", angularProperties.getDatabase().getCachePrepStmts());
//        props.setProperty("dataSource.prepStmtCacheSize", angularProperties.getDatabase().getPrepStmtCacheSize());
//        props.setProperty("dataSource.prepStmtCacheSqlLimit", angularProperties.getDatabase().getPrepStmtCacheSqlLimit());
//        props.setProperty("connectionTestQuery", "");
//        props.setProperty("minimumIdle", "");
//        props.setProperty("maximumPoolSize", "");
//        props.setProperty("poolName", "");
//
//
//        HikariConfig config = new HikariConfig(props);
//        HikariDataSource ds = new HikariDataSource(config);
//
//        return ds;
//
//    }


}