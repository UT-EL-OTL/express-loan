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
@Table(name = "InvestorBanks")
public class InvestorBanks implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Column(name = "investorID")
    private Integer investorID;

    @Column(name = "banName")
    private String bankName;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "activeStatus")
    private ActiveStatus activeStatus;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getInvestorID() {
        return investorID;
    }

    public void setInvestorID(Integer investorID) {
        this.investorID = investorID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

}