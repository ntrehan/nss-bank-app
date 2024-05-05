package com.nss.bank.controller;

import com.nss.bank.entity.Employee;
import com.nss.bank.entity.Role;
import com.nss.bank.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/signup")
    public String signup(@RequestParam String name, @RequestParam String password, @RequestParam String email, @RequestParam Role role) {
        employeeService.saveEmployee(name, password, email, role);
        return "Oh yess!!";
    }

    @PostMapping("/add/customer")
    public String addCustomer(@RequestParam String username, @RequestParam String password, @RequestParam Role role,
                              @RequestParam String customerId, @RequestParam String customerName,
                              @RequestParam String street, @RequestParam String city,
                              @RequestParam String state, @RequestParam int zipCode) {
        return "Hell Yeah";
    }
}
