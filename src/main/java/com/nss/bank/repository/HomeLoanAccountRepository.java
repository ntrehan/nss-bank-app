package com.nss.bank.repository;

import com.nss.bank.entity.HomeLoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeLoanAccountRepository extends JpaRepository<HomeLoanAccount, String> {
    // Additional custom query methods if required
}
