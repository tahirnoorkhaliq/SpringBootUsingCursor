package com.retail.banking.soap.client.controller;

import com.retail.banking.soap.client.service.NumberConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1/number-conversion")
public class NumberConversionController {

    private final NumberConversionService numberConversionService;

    @Autowired
    public NumberConversionController(NumberConversionService numberConversionService) {
        this.numberConversionService = numberConversionService;
    }

    @GetMapping("/words/{number}")
    public ResponseEntity<String> convertToWords(@PathVariable BigInteger number) {
        String words = numberConversionService.numberToWords(number);
        return ResponseEntity.ok(words);
    }

    @GetMapping("/dollars/{number}")
    public ResponseEntity<String> convertToDollars(@PathVariable BigDecimal number) {
        String dollars = numberConversionService.numberToDollars(number);
        return ResponseEntity.ok(dollars);
    }
} 