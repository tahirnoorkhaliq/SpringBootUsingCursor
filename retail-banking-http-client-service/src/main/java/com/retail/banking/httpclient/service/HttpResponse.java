package com.retail.banking.httpclient.service;

import java.util.Map;

public class HttpResponse<T> {
    private final T body;
    private final int statusCode;
    private final Map<String, String> headers;

    public HttpResponse(T body, int statusCode, Map<String, String> headers) {
        this.body = body;
        this.statusCode = statusCode;
        this.headers = headers;
    }

    public T body() {
        return body;
    }

    public int statusCode() {
        return statusCode;
    }

    public Map<String, String> headers() {
        return headers;
    }
} 