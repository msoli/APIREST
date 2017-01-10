package com.mikeio;

import com.mikeio.config.AngularProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableJpaRepositories
@EnableConfigurationProperties({AngularProperties.class})
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class ApirestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ApirestApplication.class, args);
    }

    /**
     * Used when run as WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApirestApplication.class);
    }

}
