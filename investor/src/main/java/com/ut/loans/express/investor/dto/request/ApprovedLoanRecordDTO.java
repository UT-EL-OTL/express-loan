package com.ut.loans.express.investor.dto.request;


import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ApprovedLoanRecordDTO implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "applicationID", required = true)
    private String applicationID;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "applicantID", required = true)
    private Long applicantID;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "loanID", required = true)
    private String loanID;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "applicantName", required = true)
    private String applicantName;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "loanAmount", required = true)
    private Double loanAmount;


    public static long getSerialversionuid() {
        return serialVersionUID;
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

    
}