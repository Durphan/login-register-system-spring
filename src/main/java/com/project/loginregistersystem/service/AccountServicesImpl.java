package com.project.loginregistersystem.service;

import com.project.loginregistersystem.Model.Account;
import com.project.loginregistersystem.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServicesImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServicesImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;

    }

    @Override
    public void saveAccount(Account account) {
        verifyPassword(account.getPassword());
        accountRepository.saveAccount(account.getUsername(), account.getPassword());
    }

    @Override
    public int loginAccount(Account account) {
        return accountRepository.loginAccount(account.getUsername(), account.getPassword());
    }

    private void verifyPassword(String password) {
        if (password.length() < 8)
            throw new IllegalArgumentException("Password must be at least 8 characters");
    }
}
