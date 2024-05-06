package com.nss.bank.service;

import com.nss.bank.entity.Account;
import com.nss.bank.entity.Customer;
import com.nss.bank.entity.SavingAccount;
import com.nss.bank.model.SavingsRequestModel;
import com.nss.bank.repository.CustomerRepository;
import com.nss.bank.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SavingAccountService {

    @Autowired
    private SavingAccountRepository savingAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<SavingAccount> getAllSavingAccounts() {
        return savingAccountRepository.findAll();
    }

    public Optional<SavingAccount> getSavingAccountById(String accountNumber) {
        return savingAccountRepository.findById(accountNumber);
    }

    public SavingAccount saveSavingAccount(SavingsRequestModel savingsRequestModel) throws UnsupportedEncodingException {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findByCustomerId(savingsRequestModel.getCustomerId()).orElseThrow(() -> new RuntimeException("Something went wrong!")));
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setAccountNumber(generateAccountNumber(savingsRequestModel.getCustomerId()+savingsRequestModel.getOpenDate()));
        savingAccount.setAccountType("Savings");
//        savingAccount.setInterest(4.0);
        savingAccount.setCity(savingsRequestModel.getCity());
        savingAccount.setState(savingsRequestModel.getState());
        savingAccount.setInterest(savingsRequestModel.getInterestRate());
        savingAccount.setZipCode(savingsRequestModel.getZipcode());
        savingAccount.setOpenDate(savingsRequestModel.getOpenDate());
        savingAccount.setCustomerId(customer.get());
        savingAccount.setStreet(savingsRequestModel.getStreet());


        return savingAccountRepository.save(savingAccount);
    }

    public void deleteSavingAccount(String accountNumber) {
        savingAccountRepository.deleteById(accountNumber);
    }

    private String generateAccountNumber(String name) throws UnsupportedEncodingException {
        String source = "ACC" + name + System.currentTimeMillis();
        byte[] bytes = source.getBytes("UTF-8");
        UUID uuid = UUID.nameUUIDFromBytes(bytes);
        return uuid.toString().replace("-","").substring(0, 13);
    }
}
