package com.nss.bank.controller;

import com.nss.bank.entity.HomeLoanAccount;
import com.nss.bank.service.HomeLoanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/home-loan-accounts")
public class HomeLoanAccountController {

    @Autowired
    private HomeLoanAccountService homeLoanAccountService;

    @GetMapping
    public List<HomeLoanAccount> getAllHomeLoanAccounts() {
        return homeLoanAccountService.getAllHomeLoanAccounts();
    }

    @GetMapping("/{id}")
    public Optional<HomeLoanAccount> getHomeLoanAccountById(@PathVariable String id) {
        return homeLoanAccountService.getHomeLoanAccountById(id);
    }

    @PostMapping
    public HomeLoanAccount createHomeLoanAccount(@RequestBody HomeLoanAccount account) {
        return homeLoanAccountService.saveHomeLoanAccount(account);
    }

    @PutMapping("/{id}")
    public HomeLoanAccount updateHomeLoanAccount(@PathVariable String id, @RequestBody HomeLoanAccount account) {
        account.setAccountNumber(id);
        return homeLoanAccountService.saveHomeLoanAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteHomeLoanAccount(@PathVariable String id) {
        homeLoanAccountService.deleteHomeLoanAccount(id);
    }
}
