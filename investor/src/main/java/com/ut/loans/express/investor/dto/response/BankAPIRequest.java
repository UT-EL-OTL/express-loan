package com.ut.loans.express.investor.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAPIRequest {

    @JsonProperty(value = "accountNo", required = true)
    private String accountNo;

    @JsonProperty(value = "loanAmount", required = true)
    private Double loanAmount;
    
    @JsonProperty(value = "vaID", required = true)
    private int vaID;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getVaID() {
        return vaID;
    }

    public void setVaID(int vaID) {
        this.vaID = vaID;
    }
    


}