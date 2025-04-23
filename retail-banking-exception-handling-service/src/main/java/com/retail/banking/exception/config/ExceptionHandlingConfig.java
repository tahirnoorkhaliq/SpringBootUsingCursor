package com.retail.banking.exception.config;

import com.retail.banking.exception.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GlobalExceptionHandler.class)
public class ExceptionHandlingConfig {
} 