package com.project.loginregistersystem.controller;

import com.project.loginregistersystem.Model.Account;
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
    public ResponseEntity<?> saveAccount(@RequestBody Account account) {
        try {
            ResponseEntity<?> response = validatePassword(account);
            if (response != null) {
                return response;
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
    public ResponseEntity<?> login(@RequestBody Account account) {
        if (accountService.loginAccount(account) == 1) {
            return ResponseEntity.ok("Accepted");
        }
        return ResponseEntity.status(500).body("Not Accepted");
    }

    private ResponseEntity<?> validatePassword(Account account) {
        if (account.getPassword().length() < 8) {
            return ResponseEntity.status(400).body("Password must be at least 8 characters");
        }
        return null;

    }

}
