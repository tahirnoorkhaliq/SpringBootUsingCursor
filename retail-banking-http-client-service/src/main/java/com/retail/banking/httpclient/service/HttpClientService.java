package com.retail.banking.httpclient.service;

import java.io.IOException;
import java.util.Map;

public interface HttpClientService {
    <T> T get(String url, Class<T> responseType) throws IOException;
    <T> T get(String url, Class<T> responseType, Map<String, String> headers) throws IOException;
    <T> T post(String url, Object requestBody, Class<T> responseType) throws IOException;
    <T> T post(String url, Object requestBody, Class<T> responseType, Map<String, String> headers) throws IOException;
    <T> T put(String url, Object requestBody, Class<T> responseType) throws IOException;
    <T> T put(String url, Object requestBody, Class<T> responseType, Map<String, String> headers) throws IOException;
    void delete(String url) throws IOException;
    void delete(String url, Map<String, String> headers) throws IOException;
} 