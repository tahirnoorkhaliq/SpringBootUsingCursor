package com.retail.banking.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String accountNumber;

    @NotNull
    private String accountType;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private String currency;

    private String status;

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String customerId;
} 