package com.nss.bank.controller;

import com.nss.bank.entity.CheckingAccount;
import com.nss.bank.service.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/checking-accounts")
public class CheckingAccountController {

    @Autowired
    private CheckingAccountService checkingAccountService;

    @GetMapping
    public List<CheckingAccount> getAllCheckingAccounts() {
        return checkingAccountService.getAllCheckingAccounts();
    }

    @GetMapping("/{id}")
    public Optional<CheckingAccount> getCheckingAccountById(@PathVariable String id) {
        return checkingAccountService.getCheckingAccountById(id);
    }

    @PostMapping
    public CheckingAccount createCheckingAccount(@RequestBody CheckingAccount account) {
        return checkingAccountService.saveCheckingAccount(account);
    }

    @PutMapping("/{id}")
    public CheckingAccount updateCheckingAccount(@PathVariable String id, @RequestBody CheckingAccount account) {
        account.setAccountNumber(id);
        return checkingAccountService.saveCheckingAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteCheckingAccount(@PathVariable String id) {
        checkingAccountService.deleteCheckingAccount(id);
    }
}
