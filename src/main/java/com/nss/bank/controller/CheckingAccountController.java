package com.nss.bank.controller;

import com.nss.bank.entity.CheckingAccount;
import com.nss.bank.model.CheckingRequestModel;
import com.nss.bank.security.JwtService;
import com.nss.bank.service.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/checking")
public class CheckingAccountController {

    @Autowired
    private CheckingAccountService checkingAccountService;

    @Autowired
    private JwtService jwtService;

    @GetMapping
    public List<CheckingAccount> getAllCheckingAccounts() {
        return checkingAccountService.getAllCheckingAccounts();
    }

    @GetMapping("/{id}")
    public Optional<CheckingAccount> getCheckingAccountById(@PathVariable String id) {
        return checkingAccountService.getCheckingAccountById(id);
    }

    @PostMapping("/{id}")
    public CheckingAccount createCheckingAccount(@RequestBody CheckingRequestModel checkingRequestModel, @PathVariable String id, @RequestHeader(name="Authorization") String token) throws UnsupportedEncodingException {
        if(!validateUser(id, token)) throw new RuntimeException("Something went wrong!");

        return checkingAccountService.saveCheckingAccount(checkingRequestModel);
    }

//    @PutMapping("/{id}")
//    public CheckingAccount updateCheckingAccount(@PathVariable String id, @RequestBody CheckingAccount account) {
//        account.setAccountNumber(id);
//        return checkingAccountService.saveCheckingAccount(account);
//    }

    @DeleteMapping("/{id}")
    public void deleteCheckingAccount(@PathVariable String id) {
        checkingAccountService.deleteCheckingAccount(id);
    }

    private boolean validateUser(String id, String token) {
        String jwt = token.substring(7);

        String customerId = jwtService.extractUsername(jwt);

        return id.equals(customerId);
    }
}
