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
@Table(name = "InvestorFundedLoans")
@JsonIgnoreProperties(value = {"CreatedAt"}, allowGetters = true)
public class InvestorFundedLoans implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "applicationID")
    private String applicationID;

    @Column(name = "loanID")
    private String loanID;

    @Column(name = "investorID")
    private Integer investorID;

    @Column(name="loanAmount")
    private Double loanAmount;

    @Column(name="CreatedAt",nullable = false)
    @CreationTimestamp
    private Date CreatedAt;

    @Column(name="loanStatus")
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public Integer getInvestorID() {
        return investorID;
    }

    public void setInvestorID(Integer investorID) {
        this.investorID = investorID;
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

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }



}