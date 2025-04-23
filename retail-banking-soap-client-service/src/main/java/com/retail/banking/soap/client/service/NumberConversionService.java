package com.retail.banking.soap.client.service;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface NumberConversionService {
    String numberToWords(BigInteger number);
    String numberToDollars(BigDecimal number);
} 