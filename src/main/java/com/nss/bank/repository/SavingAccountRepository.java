package com.nss.bank.repository;

import com.nss.bank.entity.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, String> {
    // Additional custom query methods if required
}
