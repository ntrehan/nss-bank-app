package com.nss.bank.repository;

import com.nss.bank.entity.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, String> {
    // Additional custom query methods if required
}
