package com.nss.bank.controller;

import com.nss.bank.entity.Employee;
import com.nss.bank.entity.RequestModel;
import com.nss.bank.entity.Role;
import com.nss.bank.service.AuthService;
import com.nss.bank.service.CustomerService;
import com.nss.bank.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public String signup(@RequestParam String name, @RequestParam String password, @RequestParam String email, @RequestParam Role role) {
        employeeService.saveEmployee(name, password, email, role);
        return "Oh yess!!";
    }

    @PostMapping("/add/customer")
    public String addCustomer(@RequestParam String name,
                              @RequestParam String street, @RequestParam String city,
                              @RequestParam String state, @RequestParam int zipCode) {
        customerService.saveCustomer(name, street, city, state,zipCode);
        return "Hell Yeah";
    }

    @PostMapping("/login")
    public String login() throws Exception {
        try {
            return authService.login("989211", "password");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());        }
    }


    @PostMapping("/add/register")
    public String register(@RequestBody RequestModel requestModel) {
        return authService.register(requestModel);
    }
}
