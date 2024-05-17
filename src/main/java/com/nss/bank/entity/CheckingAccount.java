package com.nss.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nss_checking")
public class CheckingAccount extends Account {

    @Column(name = "servicecharge", nullable = false)
    private double serviceCharge;

    // Getters and Setters
    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
