package com.nss.bank.service;

import com.nss.bank.repository.CustomerRepository;
import com.nss.bank.repository.UserRepository;
import com.nss.bank.security.JwtService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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


    private boolean isEmailOrPhoneAlreadyExists(String id) {
        return customerRepository.existsByCustomerId(id);
    }


}
