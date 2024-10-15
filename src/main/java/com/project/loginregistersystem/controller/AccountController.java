package com.project.loginregistersystem.controller;

import com.project.loginregistersystem.model.Account;
import com.project.loginregistersystem.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/acccounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("register")
    public ResponseEntity<Object> saveAccount(@RequestBody Account account) {
        try {
            ResponseEntity<Object> validation = validatePassword(account);
            if (validation != null) {
                return validation;
            }
            accountService.saveAccount(account);
            return ResponseEntity.ok("Account created");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody Account account) {
        if (Boolean.TRUE.equals(accountService.loginAccount(account))) {
            return ResponseEntity.ok("Accepted");
        }
        return ResponseEntity.status(500).body("Not Accepted");
    }

    private ResponseEntity<Object> validatePassword(Account account) {
        if (account.getPassword().length() < 8) {
            return ResponseEntity.status(400).body("Password must be at least 8 characters");
        }
        return null;
    }
}
