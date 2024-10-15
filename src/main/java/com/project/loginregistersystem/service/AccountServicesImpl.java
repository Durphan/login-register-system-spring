package com.project.loginregistersystem.service;

import com.project.loginregistersystem.model.Account;
import com.project.loginregistersystem.repository.AccountRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServicesImpl implements AccountService {
    private AccountRepository accountRepository;
    private BCryptPasswordEncoder encoder;

    public AccountServicesImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.encoder = new BCryptPasswordEncoder(15);
    }

    @Override
    public void saveAccount(Account account) {
        verifyPassword(account.getPassword());
        account.setPassword(encoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    @Override
    public Boolean loginAccount(Account account) {
        return accountRepository.existsByUsername(account.getUsername())
                && encoder.matches(account.getPassword(),
                        accountRepository.findByUsername(account.getUsername()).getPassword());
    }

    private void verifyPassword(String password) {
        if (password.length() < 8)
            throw new IllegalArgumentException("Password must be at least 8 characters");
    }
}
