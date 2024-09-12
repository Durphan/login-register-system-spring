package com.project.loginregistersystem.service;

import com.project.loginregistersystem.Model.Account;

public interface AccountService {
    void saveAccount(Account account);

    int loginAccount(Account account);
}
