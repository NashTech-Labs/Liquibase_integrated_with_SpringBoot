package com.knoldus.example.liquibase.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application using Spring Boot
 * To run application run method main or mvn spring-boot:run
 */
@ComponentScan("com.knoldus.example.liquibase")
@EntityScan("com.knoldus.example.liquibase")
@EnableJpaRepositories("com.knoldus.example.liquibase")
@EnableTransactionManagement
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {
    public static void main(final String[] args) {
        SpringApplication.run(WebApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }
}