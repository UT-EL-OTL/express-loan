package com.ut.loans.express.investor.services;

import java.util.Date;
import java.util.List;

import com.ut.loans.express.investor.dto.request.FundLoanDTO;
import com.ut.loans.express.investor.exceptions.CustomerNotFoundException;
import com.ut.loans.express.investor.model.ApplicationStatus;
import com.ut.loans.express.investor.model.ApprovedLoans;
import com.ut.loans.express.investor.model.InvestorFundedLoans;
import com.ut.loans.express.investor.model.Investors;
import com.ut.loans.express.investor.model.LoanStatus;
import com.ut.loans.express.investor.repositories.IGenericDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanFundingService {

    IGenericDao<InvestorFundedLoans> investorFundedLoansDAO;
    IGenericDao<ApprovedLoans> approvedLoanDAO;
    IGenericDao<Investors> investorsDAO;

    @Autowired
    DigitalDocumentService digitalDocumentService;

    @Autowired
    public void setApprovedLoanDAO(IGenericDao<ApprovedLoans> approvedLoanDAO){
        this.approvedLoanDAO=approvedLoanDAO;
        this.approvedLoanDAO.setClazz(ApprovedLoans.class);
    }

    @Autowired
    public void setInvestorFundedLoansDAO(IGenericDao<InvestorFundedLoans> investorFundedLoansDAO){
        this.investorFundedLoansDAO=investorFundedLoansDAO;
        this.investorFundedLoansDAO.setClazz(InvestorFundedLoans.class);
    }

    @Autowired
    public void setInvestorsDAO(IGenericDao<Investors> investorsDAO){
        this.investorsDAO=investorsDAO;
        this.investorsDAO.setClazz(Investors.class);
    }

    public String fundLoan(FundLoanDTO jsonFile){
        List<Investors> investors=investorsDAO.findValueByColumn("investorEmailID", jsonFile.getInvestorEmail());
        List<ApprovedLoans> loans=approvedLoanDAO.findValueByColumn("loanID", jsonFile.getLoanID());
        if(investors.isEmpty())
            throw new CustomerNotFoundException("Investor Not Found Exception");
        else if(loans.isEmpty())
            throw new CustomerNotFoundException("Customer Not Found Exception");
        InvestorFundedLoans investorFundedLoans=new InvestorFundedLoans();
        investorFundedLoans.setApplicationID(jsonFile.getApplicationID());
        investorFundedLoans.setInvestorID(investors.get(0).getInvestorID());
        investorFundedLoans.setLoanAmount(jsonFile.getLoanAmount());
        investorFundedLoans.setLoanID(jsonFile.getLoanID());
        investorFundedLoans.setLoanStatus(LoanStatus.Funded);
        ApprovedLoans loan=loans.get(0);
        loan.setApplicationStatus(ApplicationStatus.Funded);
        loan.setFundedAt(new Date());
        approvedLoanDAO.update(loan);
        investorFundedLoansDAO.save(investorFundedLoans);
        digitalDocumentService.generateDocument(investors.get(0).getInvestorID(),jsonFile.getLoanID(),jsonFile.getLoanAmount());
        return "Success";
    }
}