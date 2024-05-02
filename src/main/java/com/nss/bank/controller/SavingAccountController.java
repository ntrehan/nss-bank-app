package com.nss.bank.controller;

import com.nss.bank.entity.SavingAccount;
import com.nss.bank.service.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/saving-accounts")
public class SavingAccountController {

    @Autowired
    private SavingAccountService savingAccountService;

    @GetMapping
    public List<SavingAccount> getAllSavingAccounts() {
        return savingAccountService.getAllSavingAccounts();
    }

    @GetMapping("/{id}")
    public Optional<SavingAccount> getSavingAccountById(@PathVariable String id) {
        return savingAccountService.getSavingAccountById(id);
    }

    @PostMapping
    public SavingAccount createSavingAccount(@RequestBody SavingAccount account) {
        return savingAccountService.saveSavingAccount(account);
    }

    @PutMapping("/{id}")
    public SavingAccount updateSavingAccount(@PathVariable String id, @RequestBody SavingAccount account) {
        account.setAccountNumber(id);
        return savingAccountService.saveSavingAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteSavingAccount(@PathVariable String id) {
        savingAccountService.deleteSavingAccount(id);
    }
}
