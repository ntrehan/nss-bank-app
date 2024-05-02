package com.nss.bank.service;

import com.nss.bank.entity.HomeLoanAccount;
import com.nss.bank.repository.HomeLoanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeLoanAccountService {

    @Autowired
    private HomeLoanAccountRepository homeLoanAccountRepository;

    public List<HomeLoanAccount> getAllHomeLoanAccounts() {
        return homeLoanAccountRepository.findAll();
    }

    public Optional<HomeLoanAccount> getHomeLoanAccountById(String accountNumber) {
        return homeLoanAccountRepository.findById(accountNumber);
    }

    public HomeLoanAccount saveHomeLoanAccount(HomeLoanAccount account) {
        return homeLoanAccountRepository.save(account);
    }

    public void deleteHomeLoanAccount(String accountNumber) {
        homeLoanAccountRepository.deleteById(accountNumber);
    }
}
