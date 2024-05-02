package com.nss.bank.service;

import com.nss.bank.entity.CheckingAccount;
import com.nss.bank.repository.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckingAccountService {

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    public List<CheckingAccount> getAllCheckingAccounts() {
        return checkingAccountRepository.findAll();
    }

    public Optional<CheckingAccount> getCheckingAccountById(String accountNumber) {
        return checkingAccountRepository.findById(accountNumber);
    }

    public CheckingAccount saveCheckingAccount(CheckingAccount account) {
        return checkingAccountRepository.save(account);
    }

    public void deleteCheckingAccount(String accountNumber) {
        checkingAccountRepository.deleteById(accountNumber);
    }
}
