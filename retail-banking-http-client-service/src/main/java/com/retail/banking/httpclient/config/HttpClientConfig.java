package com.retail.banking.httpclient.config;

import com.retail.banking.httpclient.service.HttpClientService;
import com.retail.banking.httpclient.service.impl.HttpClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig {
    
    @Bean
    public HttpClientService httpClientService() {
        return new HttpClientServiceImpl();
    }
} 