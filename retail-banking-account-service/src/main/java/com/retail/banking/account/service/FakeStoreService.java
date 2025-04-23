package com.retail.banking.account.service;

import com.retail.banking.httpclient.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class FakeStoreService {

    private final HttpClientService httpClientService;
    private static final String FAKE_STORE_API_URL = "https://fakestoreapi.com";

    @Autowired
    public FakeStoreService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    public List<Map<String, Object>> getAllProducts() throws IOException {
        return httpClientService.get(FAKE_STORE_API_URL + "/products", List.class);
    }

    public Map<String, Object> getProductById(Long id) throws IOException {
        return httpClientService.get(FAKE_STORE_API_URL + "/products/" + id, Map.class);
    }

    public List<Map<String, Object>> getProductsByCategory(String category) throws IOException {
        return httpClientService.get(FAKE_STORE_API_URL + "/products/category/" + category, List.class);
    }
} 