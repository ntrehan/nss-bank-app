package com.nss.bank.service;

import com.nss.bank.entity.Customer;
import com.nss.bank.entity.Role;
import com.nss.bank.entity.User;
import com.nss.bank.repository.CustomerRepository;
import com.nss.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(String username, String password, Role role, String customerId,
                           String customerName, String street, String city, String state, int zipCode) {
        Customer customer = new Customer(customerId,
                customerName, street, city, state, zipCode);
        customerRepository.save(customer);

        User user = User
                .builder()
                .username(username)
                .customerId(customer)
                .password(passwordEncoder.encode(password))
                .role(role).build();

        userRepository.save(user);
    }

    public boolean validateUserCredentials(String username, String rawPassword) {
        User user = userRepository.findByUsername(username).orElse(null);
        return user != null && passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
