package com.ut.loans.express.investor.model;

import java.io.Serializable;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "EscrowAccountHistory")
public class EscrowAccountHistory implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "transactionID")
    private int transactionID;

    @Column(name = "transactionType")
    @Enumerated(EnumType.STRING)
    private TransactionTypes transactionType;

    @Column(name = "beneficiaryAccountNo")
    private String beneficiaryAccountNo;

    @Column(name = "transactionAmount")
    private Double transactionAmount;

    @Column(name = "transactionStatus")
    private PaymentStatus transactionStatus;

    @Column(name = "comments")
    private String comments;
    
    @Column(name="CreatedAt",nullable = false)
    @CreationTimestamp
    private Date CreatedAt;

    @Column(name="updatedAt",nullable = false)
    @CreationTimestamp
    private Date updatedAt;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypes transactionType) {
        this.transactionType = transactionType;
    }

    public String getBeneficiaryAccountNo() {
        return beneficiaryAccountNo;
    }

    public void setBeneficiaryAccountNo(String beneficiaryAccountNo) {
        this.beneficiaryAccountNo = beneficiaryAccountNo;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public PaymentStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(PaymentStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}