package com.nss.bank.controller;

import com.nss.bank.entity.Role;
import com.nss.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password, @RequestParam Role role,
                         @RequestParam String customerId, @RequestParam String customerName,
                         @RequestParam String street, @RequestParam String city,
                         @RequestParam String state, @RequestParam int zipCode) {
        userService.createUser(username, password, role, customerId, customerName, street, city, state, zipCode);
        return "User and customer successfully registered";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        boolean isValid = userService.validateUserCredentials(username, password);
//        return isValid ? "Login successful" : "Invalid username or password";
//    }
}
