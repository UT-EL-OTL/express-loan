package com.ut.loans.express.investor.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAPIResponse {
    
    @JsonProperty(value = "code", required = true)
    private int code;

    @JsonProperty(value = "message", required = true)
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}