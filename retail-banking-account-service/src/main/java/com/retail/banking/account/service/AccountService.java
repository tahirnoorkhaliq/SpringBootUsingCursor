package com.retail.banking.account.service;

import com.retail.banking.account.model.Account;
import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(Long id);
    Account getAccountByNumber(String accountNumber);
    List<Account> getAccountsByCustomerId(String customerId);
    Account updateAccount(Account account);
    void deleteAccount(Long id);
    Account deposit(String accountNumber, BigDecimal amount);
    Account withdraw(String accountNumber, BigDecimal amount);
    List<Account> getAllAccounts();
} 