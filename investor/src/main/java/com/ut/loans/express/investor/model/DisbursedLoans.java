package com.ut.loans.express.investor.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "DisbursedLoans")
@JsonIgnoreProperties(value = {"CreatedAt, updatedAt"}, allowGetters = true)
public class DisbursedLoans implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "investorID")
    private Integer investorID;

    @Column(name = "vaID")
    private Integer vaID;

    @Column(name = "transactionID")
    private Integer transactionID;

    @Column(name="transactionStatus")
    @Enumerated(EnumType.STRING)
    private PaymentStatus transactionStatus;

    @Column(name="vaAmount")
    private Double vaAmount;

    @Column(name="vaStatus")
    @Enumerated(EnumType.STRING)
    private PaymentStatus vaStatus;

    @Column(name="CreatedAt",nullable = false)
    @CreationTimestamp
    private Date CreatedAt;

    @Column(name="updatedAt",nullable = false)
    @CreationTimestamp
    private Date updatedAt;

    @Column(name = "investorBank")
    private InvestorBanks investorBank;

    @Column(name = "comments")
    private String comments;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInvestorID() {
        return investorID;
    }

    public void setInvestorID(Integer investorID) {
        this.investorID = investorID;
    }

    public Integer getVaID() {
        return vaID;
    }

    public void setVaID(Integer vaID) {
        this.vaID = vaID;
    }

    public Double getVaAmount() {
        return vaAmount;
    }

    public void setVaAmount(Double vaAmount) {
        this.vaAmount = vaAmount;
    }

    public PaymentStatus getVaStatus() {
        return vaStatus;
    }

    public void setVaStatus(PaymentStatus vaStatus) {
        this.vaStatus = vaStatus;
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

    public InvestorBanks getInvestorBank() {
        return investorBank;
    }

    public void setInvestorBank(InvestorBanks investorBank) {
        this.investorBank = investorBank;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
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
   
}