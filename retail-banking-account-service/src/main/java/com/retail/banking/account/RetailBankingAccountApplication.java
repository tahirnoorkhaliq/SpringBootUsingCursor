package com.retail.banking.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.retail.banking.account", "com.retail.banking.httpclient"})
public class RetailBankingAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetailBankingAccountApplication.class, args);
    }
} 