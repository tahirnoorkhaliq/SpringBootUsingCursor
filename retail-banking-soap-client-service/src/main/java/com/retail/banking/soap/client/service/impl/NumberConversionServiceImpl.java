package com.retail.banking.soap.client.service.impl;

import com.retail.banking.soap.client.service.NumberConversionService;
import com.retail.banking.soap.client.wsdl.NumberToDollars;
import com.retail.banking.soap.client.wsdl.NumberToDollarsResponse;
import com.retail.banking.soap.client.wsdl.NumberToWords;
import com.retail.banking.soap.client.wsdl.NumberToWordsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class NumberConversionServiceImpl implements NumberConversionService {

    private final WebServiceTemplate webServiceTemplate;
    private static final String ENDPOINT_URL = "http://www.dataaccess.com/webservicesserver/numberconversion.wso";

    @Autowired
    public NumberConversionServiceImpl(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    @Override
    public String numberToWords(BigInteger number) {
        NumberToWords request = new NumberToWords();
        request.setUbiNum(number);

        NumberToWordsResponse response = (NumberToWordsResponse) webServiceTemplate
                .marshalSendAndReceive(ENDPOINT_URL, request);

        return response.getNumberToWordsResult();
    }

    @Override
    public String numberToDollars(BigDecimal number) {
        NumberToDollars request = new NumberToDollars();
        request.setDNum(number);

        NumberToDollarsResponse response = (NumberToDollarsResponse) webServiceTemplate
                .marshalSendAndReceive(ENDPOINT_URL, request);

        return response.getNumberToDollarsResult();
    }
} 