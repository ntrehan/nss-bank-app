package com.nss.bank.service;

import com.nss.bank.entity.Customer;
import com.nss.bank.entity.RequestModel;
import com.nss.bank.entity.Role;
import com.nss.bank.repository.CustomerRepository;
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

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    public String login(String id, String pwd) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        "989211",
                        "password"
                )
        );

        var user = customerRepository.findByCustomerId(id)
                .orElseThrow(() -> new EntityNotFoundException("User " + id + " Not Found"));

        return jwtService.generateToken(user);
    }


    public String register(RequestModel requestModel) {
        Customer customer = Customer.builder()
                .customerId("989211")
                .role(Role.USER)
                .street(requestModel.getStreet())
                .zipCode(requestModel.getZipcode())
                .city(requestModel.getCity())
                .name(requestModel.getName())
                .password(passwordEncoder.encode("password"))
                .state(requestModel.getState()).build();

        customerRepository.save(customer);
        return "Ho agya";
    }


    private boolean isEmailOrPhoneAlreadyExists(String id) {
        return customerRepository.existsByCustomerId(id);
    }


}
