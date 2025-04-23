package com.retail.banking.httpclient.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.banking.httpclient.service.HttpClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class HttpClientServiceImpl implements HttpClientService {

    private final CloseableHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public HttpClientServiceImpl() {
        this.httpClient = HttpClients.createDefault();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public <T> T get(String url, Class<T> responseType) throws IOException {
        return get(url, responseType, null);
    }

    @Override
    public <T> T get(String url, Class<T> responseType, Map<String, String> headers) throws IOException {
        HttpGet request = new HttpGet(url);
        addHeaders(request, headers);
        return executeRequest(request, responseType);
    }

    @Override
    public <T> T post(String url, Object requestBody, Class<T> responseType) throws IOException {
        return post(url, requestBody, responseType, null);
    }

    @Override
    public <T> T post(String url, Object requestBody, Class<T> responseType, Map<String, String> headers) throws IOException {
        HttpPost request = new HttpPost(url);
        addHeaders(request, headers);
        StringEntity entity = new StringEntity(objectMapper.writeValueAsString(requestBody), ContentType.APPLICATION_JSON);
        request.setEntity(entity);
        return executeRequest(request, responseType);
    }

    @Override
    public <T> T put(String url, Object requestBody, Class<T> responseType) throws IOException {
        return put(url, requestBody, responseType, null);
    }

    @Override
    public <T> T put(String url, Object requestBody, Class<T> responseType, Map<String, String> headers) throws IOException {
        HttpPut request = new HttpPut(url);
        addHeaders(request, headers);
        StringEntity entity = new StringEntity(objectMapper.writeValueAsString(requestBody), ContentType.APPLICATION_JSON);
        request.setEntity(entity);
        return executeRequest(request, responseType);
    }

    @Override
    public void delete(String url) throws IOException {
        delete(url, null);
    }

    @Override
    public void delete(String url, Map<String, String> headers) throws IOException {
        HttpDelete request = new HttpDelete(url);
        addHeaders(request, headers);
        executeRequest(request, Void.class);
    }

    private void addHeaders(HttpUriRequestBase request, Map<String, String> headers) {
        if (headers != null) {
            headers.forEach(request::addHeader);
        }
    }

    private <T> T executeRequest(HttpUriRequestBase request, Class<T> responseType) throws IOException {
        try {
            return httpClient.execute(request, response -> {
                if (responseType == Void.class) {
                    return null;
                }
                return objectMapper.readValue(response.getEntity().getContent(), responseType);
            });
        } catch (IOException e) {
            log.error("Error executing HTTP request: {}", e.getMessage());
            throw e;
        }
    }
} 