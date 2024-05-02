package com.nss.bank.repository;

import com.nss.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Custom query methods can be defined here if needed
}
