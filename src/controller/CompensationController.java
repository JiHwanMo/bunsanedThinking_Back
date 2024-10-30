package controller;

import java.util.ArrayList;

import entity.accident.AccidentList;
import entity.contract.Contract;
import entity.contract.ContractList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.insuranceMoney.InsuranceMoney;
import entity.insuranceMoney.InsuranceMoneyList;
import entity.paymentDetail.PaymentDetailList;
import entity.paymentDetail.PaymentType;
import entity.report.Report;
import entity.report.ReportList;
import exception.AlreadyProcessedException;
import exception.NotExistContractException;
import exception.NotExistException;
import model.compensation.CompensationModel;

public class CompensationController {
	private CompensationModel compensationModel;
	public CompensationController() {
		compensationModel = new CompensationModel();
	}
	public void requestCompensation(String accountHolder, String bank, String bankAccount, int money,
			PaymentType paymentType, int contractId, PaymentDetailList paymentDetailList, Report report, ReportList reportList, AccidentList accidentList)
					throws NotExistException, AlreadyProcessedException{
		compensationModel.requestCompensation(accountHolder, bank, bankAccount, money, paymentType, contractId, paymentDetailList, report, reportList, accidentList);
	}
	public void requestInsuranceMoney(Customer customer, int money, InsuranceMoney insuranceMoney, InsuranceMoneyList insuranceMoneyList,
			PaymentType paymentType, int contractId, PaymentDetailList paymentDetailList) throws NotExistException, AlreadyProcessedException{
		compensationModel.requestInsuranceMoney(customer, money, insuranceMoney, insuranceMoneyList, paymentType, contractId, paymentDetailList);
	}
	public ArrayList<InsuranceMoney> getAll(InsuranceMoneyList insuranceMoneyList) {
		return compensationModel.getAll(insuranceMoneyList);
	}
	public ArrayList<InsuranceMoney> getAllUnprocessed(InsuranceMoneyList insuranceMoneyList) {
		return compensationModel.getAllUnprocessed(insuranceMoneyList);
	}
	public ArrayList<InsuranceMoney> getAllProcessed(InsuranceMoneyList insuranceMoneyList) {
		return compensationModel.getAllProcessed(insuranceMoneyList);
	}
	public InsuranceMoney get(InsuranceMoneyList insuranceMoneyList, int id) throws NotExistException {
		return compensationModel.get(insuranceMoneyList, id);
	}
	public Contract get(ContractList contractList, int contractId) throws NotExistContractException {
		return compensationModel.get(contractList, contractId);
	}
	public Customer get(CustomerList customerList, int customerID) throws NotExistException {
		return compensationModel.get(customerList, customerID);
	}
	public ArrayList<Report> getAll(ReportList reportList) {
		return compensationModel.getAll(reportList);
	}
	public Report get(ReportList reportList, int id) throws NotExistException {
		return compensationModel.get(reportList, id);
	}
	public ArrayList<Report> getAllUnprocessedReport(ReportList reportList) {
		return compensationModel.getAllUnprocessedReport(reportList);
	}
	public ArrayList<Report> getAllCompletedReport(ReportList reportList) {
		return compensationModel.getAllCompletedReport(reportList);
	}
	public Contract getAutomobileByMember(ContractList contractList, int customerID) throws NotExistContractException {
		return compensationModel.getAutomobileByMember(contractList, customerID);
	}
}
