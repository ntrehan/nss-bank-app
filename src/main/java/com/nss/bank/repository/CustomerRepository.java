package com.nss.bank.repository;

import com.nss.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findByCustomerId(String customerId);

    boolean existsByCustomerId(String customerId);
    // Custom query methods can be defined here if needed
}
