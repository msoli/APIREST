package com.mikeio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by SISTEMAS03-PC on 03/01/2017.
 */
@ConfigurationProperties(prefix = "mikeio", ignoreUnknownFields = false)
public class AngularProperties {

    private final Database database = new Database();
    private final Hibernate hibernate = new Hibernate();

    public Hibernate getHibernate() {
        return hibernate;
    }

    public Database getDatabase() {
        return database;
    }

    public static class Database {

        private String url;
        private String username;
        private String password;
        private String driverClassName;
        private String dataSourceClassName;
        private String cachePrepStmts;
        private String prepStmtCacheSize;
        private String prepStmtCacheSqlLimit;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }

        public String getDataSourceClassName() {
            return dataSourceClassName;
        }

        public void setDataSourceClassName(String dataSourceClassName) {
            this.dataSourceClassName = dataSourceClassName;
        }

        public String getCachePrepStmts() {
            return cachePrepStmts;
        }

        public void setCachePrepStmts(String cachePrepStmts) {
            this.cachePrepStmts = cachePrepStmts;
        }

        public String getPrepStmtCacheSize() {
            return prepStmtCacheSize;
        }

        public void setPrepStmtCacheSize(String prepStmtCacheSize) {
            this.prepStmtCacheSize = prepStmtCacheSize;
        }

        public String getPrepStmtCacheSqlLimit() {
            return prepStmtCacheSqlLimit;
        }

        public void setPrepStmtCacheSqlLimit(String prepStmtCacheSqlLimit) {
            this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
        }
    }


    public static class Hibernate {

        private String dialect;
        private String showSql;
        private String formatSql;

        public String getDialect() {
            return dialect;
        }

        public void setDialect(String dialect) {
            this.dialect = dialect;
        }

        public String getShowSql() {
            return showSql;
        }

        public void setShowSql(String showSql) {
            this.showSql = showSql;
        }

        public String getFormatSql() {
            return formatSql;
        }

        public void setFormatSql(String formatSql) {
            this.formatSql = formatSql;
        }
    }
}