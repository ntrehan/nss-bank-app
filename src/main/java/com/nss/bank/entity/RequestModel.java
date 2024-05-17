package com.nss.bank.entity;

import lombok.Data;

@Data
public class RequestModel {

    private String name;
    private String street;
    private String city;
    private String state;
    private String password;
    private String email;
    private int zipcode;
}
