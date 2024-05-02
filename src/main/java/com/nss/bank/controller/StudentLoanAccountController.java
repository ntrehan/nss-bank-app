package com.nss.bank.controller;

import com.nss.bank.entity.StudentLoanAccount;
import com.nss.bank.service.StudentLoanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student-loan-accounts")
public class StudentLoanAccountController {

    @Autowired
    private StudentLoanAccountService studentLoanAccountService;

    @GetMapping
    public List<StudentLoanAccount> getAllStudentLoanAccounts() {
        return studentLoanAccountService.getAllStudentLoanAccounts();
    }

    @GetMapping("/{id}")
    public Optional<StudentLoanAccount> getStudentLoanAccountById(@PathVariable String id) {
        return studentLoanAccountService.getStudentLoanAccountById(id);
    }

    @PostMapping
    public StudentLoanAccount createStudentLoanAccount(@RequestBody StudentLoanAccount account) {
        return studentLoanAccountService.saveStudentLoanAccount(account);
    }

    @PutMapping("/{id}")
    public StudentLoanAccount updateStudentLoanAccount(@PathVariable String id, @RequestBody StudentLoanAccount account) {
        account.setAccountNumber(id);
        return studentLoanAccountService.saveStudentLoanAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentLoanAccount(@PathVariable String id) {
        studentLoanAccountService.deleteStudentLoanAccount(id);
    }
}
