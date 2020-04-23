package com.ut.loans.express.investor.services;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ut.loans.express.investor.dto.response.AvailableLoansDTO;
import com.ut.loans.express.investor.dto.request.FundedHistoryDTO;
import com.ut.loans.express.investor.dto.response.FundedHistoryResponseDTO;
import com.ut.loans.express.investor.exceptions.CustomerNotFoundException;
import com.ut.loans.express.investor.model.ApplicationStatus;
import com.ut.loans.express.investor.model.ApprovedLoans;
import com.ut.loans.express.investor.model.InvestorFundedLoans;
import com.ut.loans.express.investor.model.Investors;
import com.ut.loans.express.investor.repositories.IGenericDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestorDashboardService {

    IGenericDao<InvestorFundedLoans> investorFundedLoansDAO;
    IGenericDao<ApprovedLoans> approvedLoanDAO;
    IGenericDao<Investors> investorsDAO;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    public void setApprovedLoanDAO(IGenericDao<ApprovedLoans> approvedLoanDAO) {
        this.approvedLoanDAO = approvedLoanDAO;
        this.approvedLoanDAO.setClazz(ApprovedLoans.class);
    }

    @Autowired
    public void setInvestorFundedLoansDAO(IGenericDao<InvestorFundedLoans> investorFundedLoansDAO) {
        this.investorFundedLoansDAO = investorFundedLoansDAO;
        this.investorFundedLoansDAO.setClazz(InvestorFundedLoans.class);
    }

    @Autowired
    public void setInvestorsDAO(IGenericDao<Investors> investorsDAO) {
        this.investorsDAO = investorsDAO;
        this.investorsDAO.setClazz(Investors.class);
    }

    public List<AvailableLoansDTO> getAvailableLoans() {
        List<AvailableLoansDTO> response = new ArrayList<>();
        List<ApprovedLoans> loans = approvedLoanDAO.findValueByColumn("applicationStatus",
                ApplicationStatus.Approved.toString());
        if (!loans.isEmpty())
            for (ApprovedLoans loan : loans) {
                AvailableLoansDTO row = new AvailableLoansDTO();
                row.setApplicationID(loan.getApplicationID());
                row.setApplicationName(loan.getApplicantName());
                row.setApprovedDate(loan.getCreatedAt());
                row.setLoanAmount(loan.getLoanAmount());
                row.setLoanID(loan.getLoanID());
                response.add(row);
            }
        return response;
    }

    public List<FundedHistoryResponseDTO> fundingHistory(FundedHistoryDTO param){
        List<FundedHistoryResponseDTO> response=new ArrayList<>();
        List<Investors> investors=investorsDAO.findValueByColumn("investorEmailID",param.getInvestorEmail());
        if(investors.isEmpty())
            throw new CustomerNotFoundException("Investor Not Found Exception");
        Investors investor=investors.get(0);
        List<InvestorFundedLoans> loans=investorFundedLoansDAO.findValueByColumn("investorID", String.valueOf(investor.getInvestorID()));
        if(!loans.isEmpty())
            for(InvestorFundedLoans loan:loans){
                FundedHistoryResponseDTO row=new FundedHistoryResponseDTO();
                row.setApplicationID(loan.getApplicationID());
                row.setFundedAt(loan.getCreatedAt());
                row.setLoanAmount(loan.getLoanAmount());
                row.setLoanID(loan.getLoanID());
                row.setLoanStatus(loan.getLoanStatus().toString());
                response.add(row);
            }
		return response;
	}

}