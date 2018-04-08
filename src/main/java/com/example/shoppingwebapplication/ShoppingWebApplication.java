package com.example.shoppingwebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
public class ShoppingWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingWebApplication.class, args);
    }

    /* io.github.jpenren/thymeleaf-spring-data-dialect library is used for pagination */
    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
}
