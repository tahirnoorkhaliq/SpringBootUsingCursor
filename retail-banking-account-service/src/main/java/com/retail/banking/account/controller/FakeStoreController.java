package com.retail.banking.account.controller;

import com.retail.banking.account.exception.AccountServiceException;
import com.retail.banking.account.service.FakeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fakestore")
public class FakeStoreController {

    private final FakeStoreService fakeStoreService;

    @Autowired
    public FakeStoreController(FakeStoreService fakeStoreService) {
        this.fakeStoreService = fakeStoreService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Map<String, Object>>> getAllProducts() {
        try {
            return ResponseEntity.ok(fakeStoreService.getAllProducts());
        } catch (Exception e) {
            throw new AccountServiceException("Failed to fetch products: " + e.getMessage(), e);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Map<String, Object>> getProductById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(fakeStoreService.getProductById(id));
        } catch (Exception e) {
            throw new AccountServiceException("Failed to fetch product with id " + id + ": " + e.getMessage(), e);
        }
    }

    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Map<String, Object>>> getProductsByCategory(@PathVariable String category) {
        try {
            return ResponseEntity.ok(fakeStoreService.getProductsByCategory(category));
        } catch (Exception e) {
            throw new AccountServiceException("Failed to fetch products for category " + category + ": " + e.getMessage(), e);
        }
    }
} 