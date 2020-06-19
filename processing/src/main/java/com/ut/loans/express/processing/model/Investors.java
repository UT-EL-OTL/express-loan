package com.ut.loans.express.processing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Investors")
public class Investors implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer investorID;

    @Column(name = "investorName")
    private String investorName;

    @Column(name = "investorEmail")
    private String investorEmailID;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "investmentAmount")
    private Double investmentAmount;

    @Column(name = "availableAmount")
    private Double availableAmount;

    @Column(name = "outstandingAmount")
    private Double outstandingAmount;

    @Column(name = "disbursedLoans")
    private Integer disbursedLoans;

    @Enumerated(EnumType.STRING)
    @Column(name = "activeStatus")
    private ActiveStatus activeStatus;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getInvestorEmailID() {
        return investorEmailID;
    }

    public void setInvestorEmailID(String investorEmailID) {
        this.investorEmailID = investorEmailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(Double oustandingAmount) {
        this.outstandingAmount = oustandingAmount;
    }

    public Integer getDisbursedLoans() {
        return disbursedLoans;
    }

    public void setDisbursedLoans(Integer disbursedLoans) {
        this.disbursedLoans = disbursedLoans;
    }

    public Integer getInvestorID() {
        return investorID;
    }

    public void setInvestorID(Integer investorID) {
        this.investorID = investorID;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }


}