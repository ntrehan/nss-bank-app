package com.nss.bank.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "nss_accounts")
public abstract class Account {

    @Id
    @Column(name = "accountnumber", length = 15, nullable = false)
    private String accountNumber;

    @Column(name = "street", length = 20, nullable = false)
    private String street;

    @Column(name = "accounttype", length = 10, nullable = false)
    private String accountType;

    @Column(name = "opendate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date openDate;

    @ManyToOne
    @JoinColumn(name = "customerid", nullable = false)
    private Customer customerId;

    @Column(name = "city", length = 20, nullable = false)
    private String city;

    @Column(name = "state", length = 2, nullable = false)
    private String state;

    @Column(name = "zipcode", nullable = false)
    private int zipCode;

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

//    public Customer getCustomerId() {
//        return this.customerId.;
//    }
//
//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
