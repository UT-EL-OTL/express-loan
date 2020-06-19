package com.ut.loans.express.investor.model;

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
@Table(name = "UTEscrowAccounts")
public class UTEscrowAccounts implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Column(name = "accountHolder")
    private Integer accountHolder;

    @Column(name = "banName")
    private String bankName;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "presentAmount")
    private Double presentAmount;

    @Column(name = "noofTransactions")
    private int noofTransactions;

    @Column(name = "activeStatus")
    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(Integer accountHolder) {
        this.accountHolder = accountHolder;
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

    public Double getPresentAmount() {
        return presentAmount;
    }

    public void setPresentAmount(Double presentAmount) {
        this.presentAmount = presentAmount;
    }

    public int getNoofTransactions() {
        return noofTransactions;
    }

    public void setNoofTransactions(int noofTransactions) {
        this.noofTransactions = noofTransactions;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

}