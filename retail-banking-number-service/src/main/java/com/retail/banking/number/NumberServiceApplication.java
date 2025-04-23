package com.retail.banking.number;

import com.retail.banking.soap.client.config.EnableSoapClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSoapClient
public class NumberServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NumberServiceApplication.class, args);
    }
} 