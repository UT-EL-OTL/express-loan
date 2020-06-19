package com.ut.loans.express.processing.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

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
@Table(name = "InvestorVAPayment")
@JsonIgnoreProperties(value = {"CreatedAt, updatedAt"}, allowGetters = true)
public class InvestorVAPayment implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "applicationID")
    private String applicationID;

    @Column(name = "loanID")
    private String loanID;

    @Column(name="loanStatus")
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    @Column(name = "investorID")
    private Integer investorID;

    @Column(name = "vaID")
    private Integer vaID;

    @Column(name="vaAmount")
    private Double vaAmount;

    @Column(name="vaStatus")
    @Enumerated(EnumType.STRING)
    private PaymentStatus vaStatus;

    @Column(name="loanAmount")
    private Double loanAmount;

    @Column(name="CreatedAt",nullable = false)
    @CreationTimestamp
    private Date CreatedAt;

    @Column(name="updatedAt",nullable = false)
    @CreationTimestamp
    private Date updatedAt;

    @Column(name = "investorBank")
    private InvestorBanks investorBank;

    @Column(name = "applicationAccountNo")
    private String applicationAccountNo;

    @Column(name = "vaComments")
    private String vaComments;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
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

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
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

    public String getApplicationAccountNo() {
        return applicationAccountNo;
    }

    public void setApplicationAccountNo(String applicationAccountNo) {
        this.applicationAccountNo = applicationAccountNo;
    }

    public String getVaComments() {
        return vaComments;
    }

    public void setVaComments(String vaComments) {
        this.vaComments = vaComments;
    }
}