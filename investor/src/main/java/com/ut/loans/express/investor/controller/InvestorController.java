package com.ut.loans.express.investor.controller;

import com.ut.loans.express.investor.dto.request.ApprovedLoanRecordDTO;
import com.ut.loans.express.investor.dto.request.JsonFile;
import com.ut.loans.express.investor.services.TemporaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/express-loan/investor")    
public class InvestorController {

    @Autowired
    TemporaryService temporaryService;
    
    @PostMapping(path = "/test")
    public ResponseEntity<Object> test(){
        return new ResponseEntity<Object>(temporaryService.test(), HttpStatus.OK);
    }

    @PostMapping(path = "/insertApprovedLoanRecord",consumes="application/json")
    public ResponseEntity<Object> insertApprovedLoanRecord(@RequestBody JsonFile<ApprovedLoanRecordDTO> jsonFile){
        System.out.println(jsonFile);
        return new ResponseEntity<Object>(temporaryService.insertApprovedLoanRecord(jsonFile.getJSONFile()), HttpStatus.OK);
    }
}