package com.nss.bank.controller;

import com.nss.bank.entity.Customer;
import com.nss.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

//    @PostMapping
//    public Customer createCustomer(@RequestBody Customer customer) {
//        return customerService.saveCustomer(customer);
//    }
//
//    @PutMapping("/{id}")
//    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
////        customer.setCustomerId(id);
//        return customerService.saveCustomer(customer);
//    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }
}
