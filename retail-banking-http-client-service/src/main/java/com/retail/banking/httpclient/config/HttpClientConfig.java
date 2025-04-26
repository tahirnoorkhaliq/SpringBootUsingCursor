package com.retail.banking.httpclient.config;

import com.retail.banking.httpclient.service.HttpClientService;
import com.retail.banking.httpclient.service.impl.HttpClientServiceImpl;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class HttpClientConfig {
    
    @Bean
    @DependsOn("httpClient")
    public HttpClientService httpClientService(CloseableHttpClient httpClient) {
        return new HttpClientServiceImpl(httpClient);
    }
} 