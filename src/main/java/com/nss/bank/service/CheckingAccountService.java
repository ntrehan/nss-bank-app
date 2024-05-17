package com.nss.bank.service;

import com.nss.bank.entity.CheckingAccount;
import com.nss.bank.entity.Customer;
import com.nss.bank.entity.SavingAccount;
import com.nss.bank.model.CheckingRequestModel;
import com.nss.bank.repository.CheckingAccountRepository;
import com.nss.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CheckingAccountService {

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<CheckingAccount> getAllCheckingAccounts() {
        return checkingAccountRepository.findAll();
    }

    public Optional<CheckingAccount> getCheckingAccountById(String accountNumber) {
        return checkingAccountRepository.findById(accountNumber);
    }

    public CheckingAccount saveCheckingAccount(CheckingRequestModel checkingRequestModel) throws UnsupportedEncodingException {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findByCustomerId(checkingRequestModel.getCustomerId()).orElseThrow(() -> new RuntimeException("Something went wrong!")));
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setAccountNumber(generateAccountNumber(checkingRequestModel.getCustomerId()+checkingRequestModel.getOpenDate()));
        checkingAccount.setAccountType("Checking");
        checkingAccount.setCity(checkingRequestModel.getCity());
        checkingAccount.setState(checkingRequestModel.getState());
        checkingAccount.setServiceCharge(checkingRequestModel.getServiceCharge());
        checkingAccount.setZipCode(checkingRequestModel.getZipcode());
        checkingAccount.setOpenDate(checkingRequestModel.getOpenDate());
        checkingAccount.setCustomerId(customer.get());
        checkingAccount.setStreet(checkingRequestModel.getStreet());


        return checkingAccountRepository.save(checkingAccount);
//        return checkingAccountRepository.save(account);
    }

    public void deleteCheckingAccount(String accountNumber) {
        checkingAccountRepository.deleteById(accountNumber);
    }
    private String generateAccountNumber(String name) throws UnsupportedEncodingException {
        String source = "CHE" + name + System.currentTimeMillis();
        byte[] bytes = source.getBytes("UTF-8");
        UUID uuid = UUID.nameUUIDFromBytes(bytes);
        return uuid.toString().replace("-","").substring(0, 13);
    }

}
