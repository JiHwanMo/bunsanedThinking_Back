package controller;

import java.util.ArrayList;

import entity.contract.Contract;
import entity.contract.ContractList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.depositDetail.DepositDetail;
import entity.depositDetail.DepositDetailList;
import entity.paymentDetail.PaymentDetail;
import entity.paymentDetail.PaymentDetailList;
import exception.AlreadyProcessedException;
import exception.NotExistContractException;
import exception.NotExistException;
import model.financialAccountant.FinancialAccountantModel;

public class FinancialAccountantController {
	private FinancialAccountantModel financialAccountantModel;
	public FinancialAccountantController() {
		financialAccountantModel = new FinancialAccountantModel();
	}
	public DepositDetail getDepositDetail(DepositDetailList depositDetailList, int id) throws NotExistException{
		return financialAccountantModel.getDepositDetail(depositDetailList, id);
	}
	public void getTaxPaymentDetail(){
		financialAccountantModel.getTaxPaymentDetail();
	}
	public void handlePayment(PaymentDetail paymentDetail, PaymentDetailList paymentDetailList) throws NotExistException, AlreadyProcessedException{
		financialAccountantModel.handlePayment(paymentDetail, paymentDetailList);
	}
	public ArrayList<PaymentDetail> getAllPaymentDetail(PaymentDetailList paymentDetailList) {
		return financialAccountantModel.getAllPaymentDetail(paymentDetailList);
	}
	public ArrayList<PaymentDetail> getAllUnprocessedPaymentDetail(PaymentDetailList paymentDetailList) {
		return financialAccountantModel.getAllUnprocessedPaymentDetail(paymentDetailList);
	}
	public ArrayList<PaymentDetail> getAllCompletedPaymentDetail(PaymentDetailList paymentDetailList) {
		return financialAccountantModel.getAllCompletedPaymentDetail(paymentDetailList);
	}
	public PaymentDetail get(PaymentDetailList paymentDetailList, int index) throws NotExistException {
		return financialAccountantModel.get(paymentDetailList, index);
	}
	public Contract get(ContractList contractList, int id) throws NotExistContractException {
		return financialAccountantModel.get(contractList, id);
	}
	public Customer get(CustomerList customerList, int id) throws NotExistException {
		return financialAccountantModel.get(customerList, id);
	}
	public ArrayList<DepositDetail> getAllDepositDetail(DepositDetailList depositDetailList) {
		return financialAccountantModel.getAllDepositDetail(depositDetailList);
	}
}
