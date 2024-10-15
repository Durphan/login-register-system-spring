package com.project.loginregistersystem.service;

import com.project.loginregistersystem.model.Account;

public interface AccountService {
    void saveAccount(Account account);

    Boolean loginAccount(Account account);
}
