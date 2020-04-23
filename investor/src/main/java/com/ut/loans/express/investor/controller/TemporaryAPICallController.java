package com.ut.loans.express.investor.controller;

import com.ut.loans.express.investor.services.TemporaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/express-loan/temp")
public class TemporaryAPICallController {
    
    @Autowired
    TemporaryService temporaryService;

    @PostMapping(path = "/investorVAPaymentBankAPIRequest")
    public ResponseEntity<String> test(){
        System.out.println("API call initated!!!");
        return new ResponseEntity<String>(temporaryService.randomAPIStatus(), HttpStatus.OK);
    }

}