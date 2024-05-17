package com.nss.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nss_savings")
public class SavingAccount extends Account {

    @Column(name = "interestrate", nullable = false)
    private double interest;

    // Getters and Setters
    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
