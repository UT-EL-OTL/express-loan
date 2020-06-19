package com.ut.loans.express.processing.model;

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
@Table(name = "ProcessingLoans")
@JsonIgnoreProperties(value = {"CreatedAt"}, allowGetters = true)
public class ProcessingLoans implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "applicationID")
    private String applicationID;

    @Column(name = "applicantID")
    private Long applicantID;

    @Column(name = "loanID")
    private String loanID;

    @Column(name = "applicantName", nullable = true)
    private String applicantName;

    @Column(name = "loanAmount", nullable = true)
    private Double loanAmount;

    @Column(name="applicationStatus")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @Column(name="ivrStatus")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus ivrStatus;
    
    @Column(name="telecomScoreStatus")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus telecomScoreStatus;

    @Column(name="engineAcceptanceStatus")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus engineAcceptanceStatus;


    @Column(name="CreatedAt",nullable = false)
    @CreationTimestamp
    private Date CreatedAt;

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

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
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

    public Long getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Long applicantID) {
        this.applicantID = applicantID;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public ApplicationStatus getIvrStatus() {
        return ivrStatus;
    }

    public void setIvrStatus(ApplicationStatus ivrStatus) {
        this.ivrStatus = ivrStatus;
    }

    public ApplicationStatus getTelecomScoreStatus() {
        return telecomScoreStatus;
    }

    public void setTelecomScoreStatus(ApplicationStatus telecomScoreStatus) {
        this.telecomScoreStatus = telecomScoreStatus;
    }

    public ApplicationStatus getEngineAcceptanceStatus() {
        return engineAcceptanceStatus;
    }

    public void setEngineAcceptanceStatus(ApplicationStatus engineAcceptanceStatus) {
        this.engineAcceptanceStatus = engineAcceptanceStatus;
    }

}