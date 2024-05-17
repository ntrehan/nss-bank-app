package com.nss.bank.repository;

import com.nss.bank.entity.StudentLoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLoanAccountRepository extends JpaRepository<StudentLoanAccount, String> {
    // Additional custom query methods if required
}
