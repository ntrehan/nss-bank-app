package com.nss.bank.controller;

import com.nss.bank.entity.*;
import com.nss.bank.repository.AccountRepository;
import com.nss.bank.security.JwtService;
import com.nss.bank.service.AuthService;
import com.nss.bank.service.CustomerService;
import com.nss.bank.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public String signup(@RequestParam String name, @RequestParam String password, @RequestParam String email, @RequestParam Role role) {
        return employeeService.saveEmployee(name, password, email, role);

    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(@RequestHeader (name="Authorization") String token) {
        String jwt = token.substring(7);

        String employeeId = jwtService.extractUsername(jwt);

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(employeeId);
        if(!((User) userDetails).getRole().equals(Role.ADMIN)) throw new RuntimeException("Something went wrong!");
        return accountRepository.findAll();

    }

    @PostMapping("/login")
    public String login(@RequestParam String employeeId, @RequestParam String password) throws Exception {
        try {
            return authService.login(employeeId, password);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
