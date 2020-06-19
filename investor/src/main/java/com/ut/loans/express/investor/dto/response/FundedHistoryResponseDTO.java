package com.ut.loans.express.investor.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class FundedHistoryResponseDTO {

    private static final long serialVersionUID = 1L;


    @JsonProperty(value = "applicationID", required = true)
    private String applicationID;

    @JsonProperty(value = "loanAmount", required = true)
    private Double loanAmount;

    @JsonProperty(value = "loanID", required = true)
    private String loanID;

    @JsonProperty(value = "loanStatus", required = true)
    private String loanStatus;

    @JsonProperty(value = "fundedAt", required = true)
    private Date fundedAt;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Date getFundedAt() {
        return fundedAt;
    }

    public void setFundedAt(Date fundedAt) {
        this.fundedAt = fundedAt;
    }

}