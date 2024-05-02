package com.nss.bank.service;

import com.nss.bank.entity.SavingAccount;
import com.nss.bank.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingAccountService {

    @Autowired
    private SavingAccountRepository savingAccountRepository;

    public List<SavingAccount> getAllSavingAccounts() {
        return savingAccountRepository.findAll();
    }

    public Optional<SavingAccount> getSavingAccountById(String accountNumber) {
        return savingAccountRepository.findById(accountNumber);
    }

    public SavingAccount saveSavingAccount(SavingAccount account) {
        return savingAccountRepository.save(account);
    }

    public void deleteSavingAccount(String accountNumber) {
        savingAccountRepository.deleteById(accountNumber);
    }
}
