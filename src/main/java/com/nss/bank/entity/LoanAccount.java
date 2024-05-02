package com.nss.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nss_loan")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class LoanAccount extends Account {

    @Column(name = "loanrate", nullable = false)
    private double loanRate;

    @Column(name = "loanamount", nullable = false)
    private double loanAmount;

    @Column(name = "loanmonths", nullable = false)
    private int loanMonths;

    @Column(name = "loanpayment", length = 20, nullable = false)
    private String loanPayment;

    @Column(name = "loantype", length = 20, nullable = false)
    private String loanType;

    public double getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(double loanRate) {
        this.loanRate = loanRate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanMonths() {
        return loanMonths;
    }

    public void setLoanMonths(int loanMonths) {
        this.loanMonths = loanMonths;
    }

    public String getLoanPayment() {
        return loanPayment;
    }

    public void setLoanPayment(String loanPayment) {
        this.loanPayment = loanPayment;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
}