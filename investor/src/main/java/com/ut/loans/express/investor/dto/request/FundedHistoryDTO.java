package com.ut.loans.express.investor.dto.request;


import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class FundedHistoryDTO implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "investorEmail", required = true)
    private String investorEmail;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getInvestorEmail() {
        return investorEmail;
    }

    public void setInvestorEmail(String investorEmail) {
        this.investorEmail = investorEmail;
    }

}