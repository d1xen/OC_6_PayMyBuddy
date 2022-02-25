package com.example.PayMyBuddy.service;

import com.example.PayMyBuddy.model.Account;
import com.example.PayMyBuddy.model.User;
import com.example.PayMyBuddy.repository.AccountRepository;
import com.example.PayMyBuddy.service.Interface.AccountServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class AccountService implements AccountServiceInterface {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findByUserAccountId(User user) {
        return accountRepository.findByUser(user);
    }

    @Override
    public String save(User user) {
        // Create an account when new user suscribe
        Account account = new Account();
        account.setBalance(new BigDecimal("0"));
        account.setUser(user);
        accountRepository.save(account);
        return "success";
    }
}
