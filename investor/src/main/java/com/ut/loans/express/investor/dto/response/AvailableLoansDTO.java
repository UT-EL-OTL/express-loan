package com.ut.loans.express.investor.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class AvailableLoansDTO {

    private static final long serialVersionUID = 1L;


    @JsonProperty(value = "applicationID", required = true)
    private String applicationID;

    @JsonProperty(value = "applicantName", required = true)
    private String applicationName;

    @JsonProperty(value = "loanAmount", required = true)
    private Double loanAmount;

    @JsonProperty(value = "loanID", required = true)
    private String loanID;

    @JsonProperty(value = "approvedDate", required = true)
    private Date approvedDate;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
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

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    // @JsonProperty(value = "Details", required = true)
    // private List<String> details;

}