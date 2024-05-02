package com.nss.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nss_customer")
public class Customer {

    @Id
    @Column(name = "customerid", length = 10, nullable = false)
    private String customerId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "street", length = 20, nullable = false)
    private String street;

    @Column(name = "city", length = 20, nullable = false)
    private String city;

    @Column(name = "state", length = 2, nullable = false)
    private String state;

    @Column(name = "zipcode", nullable = false)
    private int zipCode;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

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
