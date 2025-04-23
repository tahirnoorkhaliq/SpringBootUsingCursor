package com.retail.banking.number.service;

import com.retail.banking.soap.client.NumberConversionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberConversionService {
    private final NumberConversionClient numberConversionClient;

    public String convertToWords(long number) {
        return numberConversionClient.numberToWords(number);
    }

    public String convertToDollars(double number) {
        return numberConversionClient.numberToDollars(number);
    }
} 