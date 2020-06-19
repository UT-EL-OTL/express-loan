package com.ut.loans.express.processing.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ut.loans.express.processing.model.InvestorBanks;
import com.ut.loans.express.processing.model.LoanStatus;
import com.ut.loans.express.processing.model.PaymentStatus;

public class InvestorVAPaymentRecordDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @JsonProperty(value = "loanStatus", required = true)
    private LoanStatus loanStatus;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "investorID", required = true)
    private Integer investorID;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "vaID", required = true)
    private Integer vaID;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "vaAmount", required = true)
    private Double vaAmount;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "vaStatus", required = true)
    private PaymentStatus vaStatus;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "loanAmount", required = true)
    private Double loanAmount;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "investorBank", required = true)
    private InvestorBanks investorBank;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "applicationAccountNo", required = true)
    private String applicationAccountNo;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "vaComments", required = false)
    private String vaComments;

    public static long getSerialversionuid() {
        return serialVersionUID;
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
