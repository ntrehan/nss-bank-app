package com.nss.bank.service;

import com.nss.bank.entity.StudentLoanAccount;
import com.nss.bank.repository.StudentLoanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentLoanAccountService {

    @Autowired
    private StudentLoanAccountRepository studentLoanAccountRepository;

    public List<StudentLoanAccount> getAllStudentLoanAccounts() {
        return studentLoanAccountRepository.findAll();
    }

    public Optional<StudentLoanAccount> getStudentLoanAccountById(String accountNumber) {
        return studentLoanAccountRepository.findById(accountNumber);
    }

    public StudentLoanAccount saveStudentLoanAccount(StudentLoanAccount account) {
        return studentLoanAccountRepository.save(account);
    }

    public void deleteStudentLoanAccount(String accountNumber) {
        studentLoanAccountRepository.deleteById(accountNumber);
    }
}
