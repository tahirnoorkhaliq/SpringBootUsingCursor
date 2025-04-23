package com.retail.banking.number.controller;

import com.retail.banking.number.service.NumberConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/numbers")
@RequiredArgsConstructor
public class NumberConversionController {
    private final NumberConversionService numberConversionService;

    @GetMapping("/words/{number}")
    public ResponseEntity<String> convertToWords(@PathVariable long number) {
        return ResponseEntity.ok(numberConversionService.convertToWords(number));
    }

    @GetMapping("/dollars/{number}")
    public ResponseEntity<String> convertToDollars(@PathVariable double number) {
        return ResponseEntity.ok(numberConversionService.convertToDollars(number));
    }
} 