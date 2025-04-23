package com.retail.banking.soap.client;

import com.retail.banking.soap.client.wsdl.NumberToDollars;
import com.retail.banking.soap.client.wsdl.NumberToDollarsResponse;
import com.retail.banking.soap.client.wsdl.NumberToWords;
import com.retail.banking.soap.client.wsdl.NumberToWordsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;

@Slf4j
@Component
public class NumberConversionClient extends BaseSoapClient {
    private static final String NUMBER_TO_WORDS_ACTION = "http://www.dataaccess.com/webservicesserver/NumberToWords";
    private static final String NUMBER_TO_DOLLARS_ACTION = "http://www.dataaccess.com/webservicesserver/NumberToDollars";

    private String currentAction = NUMBER_TO_WORDS_ACTION;

    public NumberConversionClient(
        WebServiceTemplate webServiceTemplate,
        @Value("${soap.service.url}") String serviceUrl
    ) {
        super(webServiceTemplate, serviceUrl);
    }

    public String numberToWords(long number) {
        log.info("Converting number {} to words", number);
        currentAction = NUMBER_TO_WORDS_ACTION;
        NumberToWords request = new NumberToWords();
        request.setUbiNum(BigInteger.valueOf(number));
        NumberToWordsResponse response = callWebService(request, NumberToWordsResponse.class);
        return response.getNumberToWordsResult();
    }

    public String numberToDollars(double number) {
        log.info("Converting number {} to dollars", number);
        currentAction = NUMBER_TO_DOLLARS_ACTION;
        NumberToDollars request = new NumberToDollars();
        request.setDNum(BigDecimal.valueOf(number));
        NumberToDollarsResponse response = callWebService(request, NumberToDollarsResponse.class);
        return response.getNumberToDollarsResult();
    }

    @Override
    protected String getDefaultSoapAction() {
        return currentAction;
    }
} 