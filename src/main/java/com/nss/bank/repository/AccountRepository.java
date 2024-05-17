package com.nss.bank.repository;

import com.nss.bank.entity.Account;
import com.nss.bank.entity.CheckingAccount;
import com.nss.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findAllByCustomerId(Customer customerId);
}
