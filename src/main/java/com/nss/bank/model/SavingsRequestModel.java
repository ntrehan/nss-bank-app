package com.nss.bank.model;

import lombok.Data;

import java.util.Date;

@Data
public class SavingsRequestModel {
    private String street;
    private Date openDate;
    private String customerId;
    private String city;
    private String state;
    private int zipcode;
    private double interestRate;

}
