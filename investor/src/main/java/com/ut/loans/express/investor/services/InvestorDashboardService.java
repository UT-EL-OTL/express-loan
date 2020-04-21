package com.ut.loans.express.investor.services;

import java.util.ArrayList;
import java.util.List;

import com.ut.loans.express.investor.dto.response.AvailableLoansDTO;
import com.ut.loans.express.investor.model.ApplicationStatus;
import com.ut.loans.express.investor.model.ApprovedLoans;
import com.ut.loans.express.investor.repositories.IGenericDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestorDashboardService {

    IGenericDao<ApprovedLoans> approvedLoanDAO;

    @Autowired
    public void setApprovedLoanDAO(IGenericDao<ApprovedLoans> approvedLoanDAO){
        this.approvedLoanDAO=approvedLoanDAO;
        this.approvedLoanDAO.setClazz(ApprovedLoans.class);
    }

    public List<AvailableLoansDTO> getAvailableLoans(){
        List<AvailableLoansDTO> response = new ArrayList<>();
        List<ApprovedLoans> loans=approvedLoanDAO.findValueByColumn("applicationStatus", ApplicationStatus.Approved.toString());
        if(!loans.isEmpty())
            for(ApprovedLoans loan:loans){
                AvailableLoansDTO row=new AvailableLoansDTO();
                row.setApplicationID(loan.getApplicationID());
                row.setApplicationName(loan.getApplicantName());
                row.setApprovedDate(loan.getCreatedAt());
                row.setLoanAmount(loan.getLoanAmount());
                row.setLoanID(loan.getLoanID());
                response.add(row);
            }
        return response;
    }

}