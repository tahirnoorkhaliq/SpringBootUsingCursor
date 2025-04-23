package com.retail.banking.soap.client;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public abstract class BaseSoapClient {
    protected final WebServiceTemplate webServiceTemplate;
    protected final String serviceUrl;

    protected BaseSoapClient(WebServiceTemplate webServiceTemplate, String serviceUrl) {
        this.webServiceTemplate = webServiceTemplate;
        this.serviceUrl = serviceUrl;
    }

    protected <T> T callWebService(Object request, Class<T> responseType) {
        return (T) webServiceTemplate.marshalSendAndReceive(
            serviceUrl,
            request,
            new SoapActionCallback(getDefaultSoapAction())
        );
    }

    protected abstract String getDefaultSoapAction();
} 