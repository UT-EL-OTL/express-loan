package com.ut.loans.express.investor.services;

import java.util.Random;

import com.ut.loans.express.investor.dto.request.ApprovedLoanRecordDTO;
import com.ut.loans.express.investor.dto.request.DisbursedLoansDTO;
import com.ut.loans.express.investor.dto.request.InvestorVAPaymentRecordDTO;
import com.ut.loans.express.investor.model.ApplicationStatus;
import com.ut.loans.express.investor.model.ApprovedLoans;
import com.ut.loans.express.investor.model.DisbursedLoans;
import com.ut.loans.express.investor.model.InvestorVAPayment;
import com.ut.loans.express.investor.repositories.IGenericDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemporaryService {

    IGenericDao<ApprovedLoans> approvedLoanDAO;
    IGenericDao<InvestorVAPayment> investorVAPaymentDAO;

    @Autowired
    public void setApprovedLoanDAO(final IGenericDao<ApprovedLoans> approvedLoanDAO){
        this.approvedLoanDAO=approvedLoanDAO;
        this.approvedLoanDAO.setClazz(ApprovedLoans.class);
    }
    
    @Autowired
    public void setDisbursedLoanDAO(final IGenericDao<InvestorVAPayment> investorVAPaymentDAO){
        this.investorVAPaymentDAO=investorVAPaymentDAO;
        this.investorVAPaymentDAO.setClazz(InvestorVAPayment.class);
    }

    public String test(){
        return "Successful";
    }

	public String insertApprovedLoanRecord(final ApprovedLoanRecordDTO jsonFile) {
        final ApprovedLoans loan=new ApprovedLoans();
        loan.setApplicantID(jsonFile.getApplicantID());
        loan.setApplicantName(jsonFile.getApplicantName());
        loan.setApplicationID(jsonFile.getApplicationID());
        loan.setLoanAmount(jsonFile.getLoanAmount());
        loan.setLoanID(jsonFile.getLoanID());
        loan.setApplicationStatus(ApplicationStatus.Approved);
        approvedLoanDAO.save(loan);
		return "Success";
    }
    
    public String insertInvestorVAPaymentRecord(final InvestorVAPaymentRecordDTO jsonFile) {
        final InvestorVAPayment loan=new InvestorVAPayment();
        loan.setApplicationID(jsonFile.getApplicationID());
        loan.setInvestorID(jsonFile.getInvestorID());
        loan.setLoanID(jsonFile.getLoanID());
        loan.setLoanAmount(jsonFile.getLoanAmount());
        loan.setLoanStatus(jsonFile.getLoanStatus());
        loan.setVaID(jsonFile.getVaID());
        loan.setVaAmount(jsonFile.getVaAmount());
        loan.setVaStatus(jsonFile.getVaStatus());
        investorVAPaymentDAO.save(loan);
		return "Success";
    }

    public Integer generateVANumber(){
        final int min = 100000000;
        final int max = 999999999;
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public String randomAPIStatus(){
         return "Success"; 
        // else return "Failed";
    }

}