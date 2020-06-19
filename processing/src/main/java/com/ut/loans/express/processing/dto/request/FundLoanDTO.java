package com.ut.loans.express.processing.dto.request;


import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class FundLoanDTO implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "investorEmail", required = true)
    private String investorEmail;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "applicationID", required = true)
    private String applicationID;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "loanID", required = true)
    private String loanID;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "loanAmount", required = true)
    private Double loanAmount;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getInvestorEmail() {
        return investorEmail;
    }

    public void setInvestorEmail(String investorEmail) {
        this.investorEmail = investorEmail;
    }

    

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

}