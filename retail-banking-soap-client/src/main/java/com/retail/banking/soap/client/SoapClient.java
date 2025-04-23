package com.retail.banking.soap.client;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public interface SoapClient {
    <T> T sendAndReceive(String url, Object request, String soapAction, Class<T> responseType);
    WebServiceTemplate getWebServiceTemplate();
    SoapActionCallback getSoapActionCallback();
} 