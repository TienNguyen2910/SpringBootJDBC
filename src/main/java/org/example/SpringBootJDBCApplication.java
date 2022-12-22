package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class SpringBootJDBCApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJDBCApplication.class,args);
    }
}