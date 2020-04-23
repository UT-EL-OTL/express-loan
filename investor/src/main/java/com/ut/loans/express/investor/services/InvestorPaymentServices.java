package com.ut.loans.express.investor.services;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import com.ut.loans.express.investor.dto.request.JsonFile;
import com.ut.loans.express.investor.model.ActiveStatus;
import com.ut.loans.express.investor.model.ApprovedLoans;
import com.ut.loans.express.investor.model.DisbursedLoans;
import com.ut.loans.express.investor.model.InvestorBanks;
import com.ut.loans.express.investor.model.InvestorFundedLoans;
import com.ut.loans.express.investor.model.InvestorVAPayment;
import com.ut.loans.express.investor.model.Investors;
import com.ut.loans.express.investor.model.LoanStatus;
import com.ut.loans.express.investor.model.PaymentStatus;
import com.ut.loans.express.investor.repositories.IGenericDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class InvestorPaymentServices {

    IGenericDao<InvestorFundedLoans> investorFundedLoansDAO;
    IGenericDao<ApprovedLoans> approvedLoanDAO;
    IGenericDao<Investors> investorsDAO;
    IGenericDao<InvestorBanks> investorBanksDAO;
    IGenericDao<InvestorVAPayment> investorVAPaymentDAO;
    IGenericDao<DisbursedLoans> disbursedLoanDAO;
    
    @Autowired
    public void setInvestorBanksDAO(IGenericDao<InvestorBanks> investorBanksDAO){
        this.investorBanksDAO=investorBanksDAO;
        this.investorBanksDAO.setClazz(InvestorBanks.class);
    }

    @Autowired
    public void setInvestorVAPaymentDAO(IGenericDao<InvestorVAPayment> investorVAPaymentDAO){
        this.investorVAPaymentDAO=investorVAPaymentDAO;
        this.investorVAPaymentDAO.setClazz(InvestorVAPayment.class);
    }

    @Autowired
    public void setDisbursedLoanDAO(IGenericDao<DisbursedLoans> disbursedLoanDAO){
        this.disbursedLoanDAO=disbursedLoanDAO;
        this.disbursedLoanDAO.setClazz(DisbursedLoans.class);
    }

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

    @Scheduled(cron = "0 */1 * * * *")
    public void groupLoansGenarateVA(){
        System.out.println("cron job Started !!!");
        List<Investors> investors=investorsDAO.findValueByColumn("activeStatus", "Active");
        if(investors.isEmpty()){
            System.out.println("No Investors are in Active");
        }else{
            System.out.println("Investors Fetched!!");
            for (Investors investor : investors) {
                int investorID = investor.getInvestorID();
                System.out.println("FOR INVESTOR"+investorID+"::::");
                List<InvestorVAPayment> loans=investorVAPaymentDAO.findValueByTwoColumns("loanStatus", "AgreementAccepted", "investorID", String.valueOf(investorID));
                if(loans.isEmpty()){
                    System.out.println("No Loans are Active with AgreemntAccepted Status for Investor:"+investorID);
                }else{
                    Double totalAmount=this.calculateLoanAmount(loans);
                    System.out.println("total amount calculated !!!"+totalAmount);
                    TemporaryService temp = new TemporaryService();
                    int vaID = temp.generateVANumber();    
                    System.out.println("VA number generated !!!"+vaID);
                    for (InvestorVAPayment vaUpdate : loans) {
                        vaUpdate.setVaID(vaID);
                        vaUpdate.setVaAmount(totalAmount);
                        vaUpdate.setVaStatus(PaymentStatus.Initiated);
                        investorVAPaymentDAO.update(vaUpdate);
                    }
                    System.out.println("records updated with VA number");
                    String investorAccountNo = investorBanksDAO.findValueByTwoColumns("investorID", String.valueOf(investorID), "activeStatus", "Active").get(0).getAccountNumber(); 
                    String paymentVAStatus = requestBankAPIPaymentService(investorAccountNo, vaID, totalAmount);
                    System.out.println("Bank API called successfully and returned status:::"+paymentVAStatus);
                    if(paymentVAStatus.equals("Success")){
                        for (InvestorVAPayment vaUpdate : loans) {
                            vaUpdate.setVaStatus(PaymentStatus.Success);
                            vaUpdate.setVaComments(paymentVAStatus);
                            vaUpdate.setLoanStatus(LoanStatus.VAPaymentSuccess);
                            investorVAPaymentDAO.update(vaUpdate);
                            System.out.println("Payment Success Details Updated");
                        }
                        investor.setAvailableAmount(investor.getAvailableAmount()-totalAmount);
                        investor.setDisbursedLoans(investor.getDisbursedLoans()+loans.size());
                        investor.setOutstandingAmount(investor.getOutstandingAmount()+totalAmount);
                        investorsDAO.update(investor);    
                        System.out.println("Investor Details updated");
                    }else{
                        System.out.println("Payment Failed !!!");
                        for (InvestorVAPayment vaUpdate : loans) {
                            vaUpdate.setVaStatus(PaymentStatus.Failed);
                            vaUpdate.setVaComments(paymentVAStatus);
                            investorVAPaymentDAO.update(vaUpdate);
                            System.out.println("Payment Failed Details Updated!!");
                        }

                    }
                }        

            }
        }
    }
    public Double calculateLoanAmount(List<InvestorVAPayment> loans){
        Double totalAmount=0.0;
        for (InvestorVAPayment loansAmount : loans) {
            totalAmount+=loansAmount.getLoanAmount().doubleValue();
        }
        return totalAmount;
    }
    public String requestBankAPIPaymentService(String accountNo, int vaID, Double totalAmount){
        String message="Failed";
        final String uri = "http://localhost:9012/express-loan/temp/investorVAPaymentBankAPIRequest";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<String> result = restTemplate.postForEntity(uri, JSONObject.class, String.class, accountNo, vaID, totalAmount);
        System.out.println("API return message :::::"+result);
        message=result.getBody();
        System.out.println("messae::::"+message);
        return message;
    }
}