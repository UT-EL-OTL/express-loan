package com.ut.loans.express.investor.controller;

import com.ut.loans.express.investor.dto.request.ApprovedLoanRecordDTO;
import com.ut.loans.express.investor.dto.request.DisbursedLoansDTO;
import com.ut.loans.express.investor.dto.request.FundLoanDTO;
import com.ut.loans.express.investor.dto.request.FundedHistoryDTO;
import com.ut.loans.express.investor.dto.request.InvestorVAPaymentRecordDTO;
import com.ut.loans.express.investor.dto.request.JsonFile;
import com.ut.loans.express.investor.services.InvestorDashboardService;
import com.ut.loans.express.investor.services.LoanFundingService;
import com.ut.loans.express.investor.services.TemporaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    LoanFundingService loanFundingService;

    @Autowired
    InvestorDashboardService investorDashboardService;

    @PostMapping(path = "/test")
    public ResponseEntity<Object> test() {
        return new ResponseEntity<Object>(temporaryService.test(), HttpStatus.OK);
    }

    @PostMapping(path = "/insertApprovedLoanRecord", consumes = "application/json")
    public ResponseEntity<Object> insertApprovedLoanRecord(@RequestBody JsonFile<ApprovedLoanRecordDTO> jsonFile) {
        System.out.println(jsonFile);
        return new ResponseEntity<Object>(temporaryService.insertApprovedLoanRecord(jsonFile.getJSONFile()),
                HttpStatus.OK);
    }

    @GetMapping(path = "/getAvailableLoans", consumes = "application/json")
    public ResponseEntity<Object> getAvailableLoans() {
        return new ResponseEntity<Object>(investorDashboardService.getAvailableLoans(), HttpStatus.OK);
    }

    @PostMapping(path = "/fundLoan", consumes = "application/json")
    public ResponseEntity<Object> fundLoan(@RequestBody JsonFile<FundLoanDTO> jsonFile) {
        System.out.println(jsonFile);
        return new ResponseEntity<Object>(loanFundingService.fundLoan(jsonFile.getJSONFile()), HttpStatus.OK);
    }

    @GetMapping(path = "/fundingHistory", consumes = "application/json")
    public ResponseEntity<Object> fundingHistory(@RequestBody JsonFile<FundedHistoryDTO> jsonFile) throws Exception {
            return new ResponseEntity<Object>(investorDashboardService.fundingHistory(jsonFile.getJSONFile()), HttpStatus.OK);
    }

    @PostMapping(path = "/insertInvestorVAPaymentRecord",consumes="application/json")
    public ResponseEntity<Object> insertDisbursedLoanRecord(@RequestBody JsonFile<InvestorVAPaymentRecordDTO> jsonFile){
        System.out.println(jsonFile);
        return new ResponseEntity<Object>(temporaryService.insertInvestorVAPaymentRecord(jsonFile.getJSONFile()), HttpStatus.OK);
    }
    
}