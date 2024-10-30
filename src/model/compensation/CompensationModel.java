package model.compensation;

import java.util.ArrayList;

import entity.accident.AccidentList;
import entity.complaint.Complaint;
import entity.complaint.ComplaintList;
import entity.contract.Contract;
import entity.contract.ContractList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.insuranceMoney.InsuranceMoney;
import entity.insuranceMoney.InsuranceMoneyList;
import entity.insuranceMoney.InsuranceMoneyStatus;
import entity.paymentDetail.PaymentDetail;
import entity.paymentDetail.PaymentDetailList;
import entity.paymentDetail.PaymentType;
import entity.report.Report;
import entity.report.ReportList;
import entity.report.ReportProcessStatus;
import exception.AlreadyProcessedException;
import exception.NotExistContractException;
import exception.NotExistException;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 占쏙옙占쏙옙 4:40:40
 */
//2024-06-06 源����쁽
public class CompensationModel {

	public void requestCompensation(String accountHolder, String bank, String bankAccount, int money,
			PaymentType paymentType, int contractId, PaymentDetailList paymentDetailList, Report report, ReportList reportList, AccidentList accidentList)
					throws NotExistException, AlreadyProcessedException{
		if (report.getProcessStatus() == ReportProcessStatus.Completed) {
			throw new AlreadyProcessedException();
		}
		PaymentDetail payment = new PaymentDetail(accountHolder, bank, bankAccount, money, paymentType, contractId);
		paymentDetailList.add(payment);
		report.setProcessStatus(ReportProcessStatus.Completed);
		reportList.update(report);
		report.getAccident().complete();
		accidentList.update(report.getAccident());
	}
	
	public void requestInsuranceMoney(Customer customer, int money, InsuranceMoney insuranceMoney, InsuranceMoneyList insuranceMoneyList,
			PaymentType paymentType, int contractId, PaymentDetailList paymentDetailList) throws NotExistException, AlreadyProcessedException{
		if (insuranceMoney.getProcessStatus() == InsuranceMoneyStatus.Completed) {
			throw new AlreadyProcessedException();
		}
		PaymentDetail payment = new PaymentDetail(customer.getName(), customer.getBankName(), customer.getBankAccount(), money, paymentType, contractId);
		paymentDetailList.add(payment);
		insuranceMoney.setProcessStatus(InsuranceMoneyStatus.Completed);
		insuranceMoney.handle();
		insuranceMoneyList.update(insuranceMoney);
	}
	// 메소드는 아래에 적어주셔유! (MVC 적용)

	public ArrayList<InsuranceMoney> getAll(InsuranceMoneyList insuranceMoneyList) {
		return insuranceMoneyList.getAll();
	}

	public ArrayList<InsuranceMoney> getAllUnprocessed(InsuranceMoneyList insuranceMoneyList) {
		return insuranceMoneyList.getAllUnprocessed();
	}

	public ArrayList<InsuranceMoney> getAllProcessed(InsuranceMoneyList insuranceMoneyList) {
		return insuranceMoneyList.getAllProcessed();
	}

	public InsuranceMoney get(InsuranceMoneyList insuranceMoneyList, int id) throws NotExistException {
		return insuranceMoneyList.get(id);
	}

	public Contract get(ContractList contractList, int contractId) throws NotExistContractException {
		return contractList.get(contractId);
	}

	public Customer get(CustomerList customerList, int customerID) throws NotExistException {
		return customerList.get(customerID);
	}

	public ArrayList<Report> getAll(ReportList reportList) {
		return reportList.getAll();
	}

	public Report get(ReportList reportList, int id) throws NotExistException {
		return reportList.get(id);
	}

	public ArrayList<Report> getAllUnprocessedReport(ReportList reportList) {
		return reportList.getAllUnprocessedReport();
	}

	public ArrayList<Report> getAllCompletedReport(ReportList reportList) {
		return reportList.getAllCompletedReport();
	}

	public Contract getAutomobileByMember(ContractList contractList, int customerID) throws NotExistContractException {
		return contractList.getAutomobileByMember(customerID);
	}
}