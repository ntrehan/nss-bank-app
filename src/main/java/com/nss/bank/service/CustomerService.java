package com.nss.bank.service;

import com.nss.bank.entity.*;
import com.nss.bank.repository.AccountRepository;
import com.nss.bank.repository.CustomerRepository;
import com.nss.bank.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    @Transactional
    public String saveCustomer(RequestModel requestModel) {
        try {
f                    .customerId(generateCustomerId(requestModel.getName()))
                    .role(Role.USER)
                    .street(requestModel.getStreet())
                    .zipCode(requestModel.getZipcode())
                    .city(requestModel.getCity())
                    .name(requestModel.getName())
                    .password(passwordEncoder.encode(requestModel.getPassword()))
                    .email(requestModel.getEmail())
                    .state(requestModel.getState()).build();

            customerRepository.save(customer);

            User user = User.builder()
                    .role(Role.USER)
                    .username(customer.getUsername())
                    .password(customer.getPassword())
                    .build();
            userRepository.save(user);

            return user.getUsername();
        } catch (UnsupportedEncodingException ex) {
            return "Something went wrong";
        }
    }

    public List<Account> getAccountsByCustomerId(String customerId) {
        Customer customer = getCustomerById(customerId).orElseThrow(() -> new RuntimeException("No Customer"));

        return accountRepository.findAllByCustomerId(customer);
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private String generateCustomerId(String name) throws UnsupportedEncodingException {
        String source = "CUST" + name + System.currentTimeMillis();
        byte[] bytes = source.getBytes("UTF-8");
        UUID uuid = UUID.nameUUIDFromBytes(bytes);
        return uuid.toString().replace("-","").substring(0, 13);
    }

}
