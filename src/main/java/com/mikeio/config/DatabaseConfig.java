package com.mikeio.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by SISTEMAS03 on 04/05/2016.
 */
@Configuration
public class DatabaseConfig {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);

    @Inject
    private AngularProperties angularProperties;

    //
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//
//        DataSource ds =DataSourceBuilder.create().build();
//        return ds;
//    }

    @Bean(name = "dataSource", destroyMethod = "close")
    public DataSource getDataSource() {



        Properties props = new Properties();
        props.setProperty("dataSourceClassName", angularProperties.getDatabase().getHikari().getDataSourceClassName());
        props.setProperty("connectionTestQuery", angularProperties.getDatabase().getHikari().getConnectionTestQuery());
        props.setProperty("minimumIdle", angularProperties.getDatabase().getHikari().getMinimumIdle());
        props.setProperty("maximumPoolSize", angularProperties.getDatabase().getHikari().getMaximumPoolSize());
        props.setProperty("poolName", angularProperties.getDatabase().getHikari().getPoolName());

        props.setProperty("dataSource.url", angularProperties.getDatabase().getUrl());
        props.setProperty("dataSource.user", angularProperties.getDatabase().getUsername());
        props.setProperty("dataSource.password", angularProperties.getDatabase().getPassword());
        props.setProperty("dataSource.cachePrepStmts", angularProperties.getDatabase().getCachePrepStmts());
        props.setProperty("dataSource.prepStmtCacheSize", angularProperties.getDatabase().getPrepStmtCacheSize());
        props.setProperty("dataSource.prepStmtCacheSqlLimit", angularProperties.getDatabase().getPrepStmtCacheSqlLimit());


        HikariConfig config = new HikariConfig(props);
        HikariDataSource ds = new HikariDataSource(config);

        return ds;

    }


}