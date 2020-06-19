package com.ut.loans.express.processing.model;

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
@Table(name = "EngineAnalysisHistory")
public class EngineAnalysisHistory implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Column(name = "applicationID")
    private String applicationID;

    @Column(name = "applicantID")
    private Long applicantID;

    @Column(name = "loanID")
    private String loanID;

    @Column(name = "creStatus")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus creStatus;

    @Column(name = "dedupStatus")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus dedupStatus;

    @Column(name = "utfcStatus")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus utfcStatus;

    @Column(name = "coverageStatus")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus coverageStatus;

    @Column(name = "ivrStatus")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus ivrStatus;

    @Column(name = "ivrScore")
    private Double ivrScore;
    
    @Column(name = "creScore")
    private Double creScore;

    @Column(name = "dedupScore")
    private Double dedupScore;

    @Column(name = "utfcScore")
    private Double utfcScore;
    
    @Column(name = "coverageScore")
    private Double coverageScore;
    
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

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public Long getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Long applicantID) {
        this.applicantID = applicantID;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public ApplicationStatus getCreStatus() {
        return creStatus;
    }

    public void setCreStatus(ApplicationStatus creStatus) {
        this.creStatus = creStatus;
    }

    public ApplicationStatus getDedupStatus() {
        return dedupStatus;
    }

    public void setDedupStatus(ApplicationStatus dedupStatus) {
        this.dedupStatus = dedupStatus;
    }

    public ApplicationStatus getUtfcStatus() {
        return utfcStatus;
    }

    public void setUtfcStatus(ApplicationStatus utfcStatus) {
        this.utfcStatus = utfcStatus;
    }

    public ApplicationStatus getCoverageStatus() {
        return coverageStatus;
    }

    public void setCoverageStatus(ApplicationStatus coverageStatus) {
        this.coverageStatus = coverageStatus;
    }

    public Double getCreScore() {
        return creScore;
    }

    public void setCreScore(Double creScore) {
        this.creScore = creScore;
    }

    public Double getDedupScore() {
        return dedupScore;
    }

    public void setDedupScore(Double dedupScore) {
        this.dedupScore = dedupScore;
    }

    public Double getUtfcScore() {
        return utfcScore;
    }

    public void setUtfcScore(Double utfcScore) {
        this.utfcScore = utfcScore;
    }

    public Double getCoverageScore() {
        return coverageScore;
    }

    public void setCoverageScore(Double coverageScore) {
        this.coverageScore = coverageScore;
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

    public ApplicationStatus getIvrStatus() {
        return ivrStatus;
    }

    public void setIvrStatus(ApplicationStatus ivrStatus) {
        this.ivrStatus = ivrStatus;
    }

    public Double getIvrScore() {
        return ivrScore;
    }

    public void setIvrScore(Double ivrScore) {
        this.ivrScore = ivrScore;
    }
        
}