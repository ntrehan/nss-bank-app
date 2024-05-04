package com.nss.bank.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nss_customer")
public class Customer {

    @Id
    @Getter
    @Column(name = "customerid", length = 10, nullable = false)
    private String customerId;

    @Getter
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "street", length = 20, nullable = false)
    private String street;

    @Getter
    @Setter
    @Column(name = "city", length = 20, nullable = false)
    private String city;

    @Getter
    @Setter
    @Column(name = "state", length = 2, nullable = false)
    private String state;

    @Getter
    @Setter
    @Column(name = "zipcode", nullable = false)
    private int zipCode;

}
