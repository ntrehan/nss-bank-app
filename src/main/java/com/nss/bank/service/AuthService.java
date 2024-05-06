package com.nss.bank.service;

import com.nss.bank.entity.Customer;
import com.nss.bank.entity.RequestModel;
import com.nss.bank.entity.Role;
import com.nss.bank.repository.CustomerRepository;
import com.nss.bank.repository.UserRepository;
import com.nss.bank.security.JwtService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
//GetAllCustomers
//getAccountsByCustomerId
//GetCustomerDetailsById
//GetAllAccountsByType
//GetAllBankAccounts
//GetAlledinst
//Createbankaccount
@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public String login(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User " + username + " Not Found"));

        return jwtService.generateToken(user);
    }


//    public String register(RequestModel requestModel) {
//        Customer customer = Customer.builder()
//                .customerId("989211")
//                .role(Role.USER)
//                .street(requestModel.getStreet())
//                .zipCode(requestModel.getZipcode())
//                .city(requestModel.getCity())
//                .name(requestModel.getName())
//                .password(passwordEncoder.encode("password"))
//                .state(requestModel.getState()).build();
//
//        customerRepository.save(customer);
//        return "Ho agya";
//    }


    private boolean isEmailOrPhoneAlreadyExists(String id) {
        return customerRepository.existsByCustomerId(id);
    }


}
