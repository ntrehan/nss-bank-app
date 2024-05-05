package com.nss.bank.service;

import com.nss.bank.entity.Customer;
import com.nss.bank.entity.Role;
import com.nss.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String customerId) {
        return customerRepository.findById(customerId);
    }

    public String saveCustomer(String name, String street, String city, String state, int zipcode) {
        try {
            Customer customer = Customer.builder()
                    .customerId(generateCustomerId(name))
                    .role(Role.USER)
                    .street(street)
                    .zipCode(zipcode)
                    .city(city)
                    .name(name)
                    .password(passwordEncoder.encode(name+zipcode+city))
                    .state(state).build();

            customerRepository.save(customer);
            return "Ho agya";
        } catch (UnsupportedEncodingException ex) {
            return "Something went wrong";
        }
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private String generateCustomerId(String name) throws UnsupportedEncodingException {
        String source = "CUST" + name + System.currentTimeMillis();
        byte[] bytes = source.getBytes("UTF-8");
        UUID uuid = UUID.nameUUIDFromBytes(bytes);
        return uuid.toString().replace("-","").substring(0, 13);
    }

}
