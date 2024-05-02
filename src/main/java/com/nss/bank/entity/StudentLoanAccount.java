package com.nss.bank.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nss_student_loan")
public class StudentLoanAccount extends LoanAccount {

    @Column(name = "accountnumber", length = 10, nullable = false)
    private String accountNumber;

    @Column(name = "universityid", length = 10, nullable = false)
    private String universityId;

    @Column(name = "studentid", length = 10, nullable = false)
    private String studentId;

    @Column(name = "educationlevel", length = 20, nullable = false)
    private String educationLevel;

    @Column(name = "expectedgraduration", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expectedGraduationDate;

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Date getExpectedGraduationDate() {
        return expectedGraduationDate;
    }

    public void setExpectedGraduationDate(Date expectedGraduationDate) {
        this.expectedGraduationDate = expectedGraduationDate;
    }
}
