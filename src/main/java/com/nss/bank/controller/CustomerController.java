package com.nss.bank.controller;

import com.nss.bank.cache.CacheStore;
import com.nss.bank.entity.*;
import com.nss.bank.security.JwtService;
import com.nss.bank.service.AuthService;
import com.nss.bank.service.CustomerService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthService authService;

    @Autowired
    private CacheStore<Customer> customerCacheStore;

    @Autowired
    private CacheStore<String> userNameStore;


    @GetMapping
    public List<Customer> getAllCustomers(@RequestHeader (name="Authorization") String token) {
        String jwt = token.substring(7);

        String employeeId = jwtService.extractUsername(jwt);

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(employeeId);

        if(!((User) userDetails).getRole().equals(Role.ADMIN)) throw new RuntimeException("Something went wrong!");
        return customerService.getAllCustomers();
    }

    @GetMapping("/info")
    public Optional<Customer> getCustomerById(@PathParam("customerId") String customerId , @RequestHeader (name="Authorization") String token) {
        if(!validateUser(customerId, token)) throw new RuntimeException("Something went wrong!");
        Customer cachedCustomer = customerCacheStore.get(customerId);
        if (cachedCustomer != null) {
            System.out.println("Customer record found in cache: " + cachedCustomer.getCustomerId() + " " + cachedCustomer.getName());
            return Optional.of(cachedCustomer);
        }
        Optional<Customer> customerInfo =  customerService.getCustomerById(customerId);
        customerCacheStore.add(customerId, customerInfo.get());
        return customerInfo;
    }

    @GetMapping("/accounts")
    public List<Account> getAccountsByCustomerId(@PathParam("customerId") String customerId , @RequestHeader (name="Authorization") String token) {
        if(!validateUser(customerId, token)) throw new RuntimeException("Something went wrong!");
        return customerService.getAccountsByCustomerId(customerId);
    }

    private boolean validateUser(String id, String token) {
        String jwt = token.substring(7);

        String customerId = jwtService.extractUsername(jwt);

        return id.equals(customerId);
    }

    @PostMapping("/login")
    public String login(@RequestParam String customerId, @RequestParam String password) throws Exception {
        try {
            return authService.login(customerId, password);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());        }
    }

    @PostMapping("/signup")
    public String addCustomer(@RequestBody RequestModel requestModel) {
        return customerService.saveCustomer(requestModel);
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }
}
