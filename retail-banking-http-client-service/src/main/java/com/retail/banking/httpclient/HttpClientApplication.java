package com.retail.banking.httpclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.retail.banking.httpclient")
public class HttpClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HttpClientApplication.class, args);
    }
} 