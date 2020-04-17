package com.ut.loans.express.investor.services;

import com.ut.loans.express.investor.dto.request.ApprovedLoanRecordDTO;
import com.ut.loans.express.investor.model.ApplicationStatus;
import com.ut.loans.express.investor.model.ApprovedLoans;
import com.ut.loans.express.investor.repositories.IGenericDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemporaryService {

    IGenericDao<ApprovedLoans> approvedLoanDAO;

    @Autowired
    public void setApprovedLoanDAO(IGenericDao<ApprovedLoans> approvedLoanDAO){
        this.approvedLoanDAO=approvedLoanDAO;
        this.approvedLoanDAO.setClazz(ApprovedLoans.class);
    }

    public String test(){
        return "Successful";
    }

	public String insertApprovedLoanRecord(ApprovedLoanRecordDTO jsonFile) {
        ApprovedLoans loan=new ApprovedLoans();
        loan.setApplicantID(jsonFile.getApplicantID());
        loan.setApplicantName(jsonFile.getApplicantName());
        loan.setApplicationID(jsonFile.getApplicationID());
        loan.setLoanAmount(jsonFile.getLoanAmount());
        loan.setLoanID(jsonFile.getLoanID());
        loan.setApplicationStatus(ApplicationStatus.Approved);
        approvedLoanDAO.save(loan);
		return "Success";
	}
}