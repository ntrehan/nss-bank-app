package com.nss.bank.controller;

import com.nss.bank.entity.SavingAccount;
import com.nss.bank.model.SavingsRequestModel;
import com.nss.bank.security.JwtService;
import com.nss.bank.service.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/savings")
public class SavingAccountController {

    @Autowired
    private SavingAccountService savingAccountService;

    @Autowired
    private JwtService jwtService;

    @GetMapping
    public List<SavingAccount> getAllSavingAccounts() {

        return savingAccountService.getAllSavingAccounts();
    }

    @GetMapping("/{id}")
    public Optional<SavingAccount> getSavingAccountById(@PathVariable String id) {
        return savingAccountService.getSavingAccountById(id);
    }

    @PostMapping("/{id}")
    public String createSavingAccount(@RequestBody SavingsRequestModel account, @PathVariable String id, @RequestHeader(name="Authorization") String token) throws UnsupportedEncodingException {
        if(!validateUser(id, token)) throw new RuntimeException("Something went wrong!");

        savingAccountService.saveSavingAccount(account);
        return "hello";
    }

//    @PutMapping("/{id}")
//    public SavingAccount updateSavingAccount(@PathVariable String id, @RequestBody SavingAccount account) {
//        account.setAccountNumber(id);
//        return savingAccountService.saveSavingAccount(account);
//    }

    @DeleteMapping("/{id}")
    public void deleteSavingAccount(@PathVariable String id) {
        savingAccountService.deleteSavingAccount(id);
    }

    private boolean validateUser(String id, String token) {
        String jwt = token.substring(7);

        String customerId = jwtService.extractUsername(jwt);

        return id.equals(customerId);
    }
}
