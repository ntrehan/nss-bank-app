package com.nss.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nss_ed_institute")
public class EducationInstitute {

    @Id
    @Column(name = "universityid", length = 10, nullable = false)
    private String universityId;

    @Column(name = "universityname", length = 80, nullable = false)
    private String universityName;

    @Column(name = "street", length = 20, nullable = false)
    private String street;

    @Column(name = "state", length = 2, nullable = false)
    private String state;

    @Column(name = "city", length = 20, nullable = false)
    private String city;

    @Column(name = "zipcode", nullable = false)
    private int zipCode;

    // Getters and Setters
    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
