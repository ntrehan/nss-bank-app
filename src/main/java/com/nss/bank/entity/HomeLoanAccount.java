package com.nss.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nss_home_loan")
public class HomeLoanAccount extends LoanAccount {

    @Column(name = "housebuiltyear", nullable = false)
    private int houseBuiltYear;

    @Column(name = "homeinsuranceaccountno", length = 10, nullable = false)
    private String homeInsuranceAccountNo;

    @Column(name = "insurancecompanyname", length = 50, nullable = false)
    private String insuranceCompanyName;

    @Column(name = "yearlyinsurancepremium", nullable = false)
    private double yearlyInsurancePremium;

    // Getters and Setters

    public int getHouseBuiltYear() {
        return houseBuiltYear;
    }

    public void setHouseBuiltYear(int houseBuiltYear) {
        this.houseBuiltYear = houseBuiltYear;
    }

    public String getHomeInsuranceAccountNo() {
        return homeInsuranceAccountNo;
    }

    public void setHomeInsuranceAccountNo(String homeInsuranceAccountNo) {
        this.homeInsuranceAccountNo = homeInsuranceAccountNo;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public double getYearlyInsurancePremium() {
        return yearlyInsurancePremium;
    }

    public void setYearlyInsurancePremium(double yearlyInsurancePremium) {
        this.yearlyInsurancePremium = yearlyInsurancePremium;
    }
}
