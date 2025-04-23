package com.retail.banking.account.exception;

import com.retail.banking.exception.handler.GlobalExceptionHandler;
import com.retail.banking.exception.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AccountServiceExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(AccountServiceException.class)
    public ResponseEntity<ErrorResponse> handleAccountServiceException(AccountServiceException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Account Service Error")
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
} 