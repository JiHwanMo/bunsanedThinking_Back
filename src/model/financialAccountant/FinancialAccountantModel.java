package model.financialAccountant;

import java.util.ArrayList;

import entity.contract.Contract;
import entity.contract.ContractList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.depositDetail.DepositDetail;
import entity.depositDetail.DepositDetailList;
import entity.paymentDetail.PaymentDetail;
import entity.paymentDetail.PaymentDetailList;
import entity.paymentDetail.PaymentProcessStatus;
import exception.AlreadyProcessedException;
import exception.NotExistContractException;
import exception.NotExistException;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 占쏙옙占쏙옙 4:40:42
 */
//2024-06-06 源����쁽
public class FinancialAccountantModel {

	public DepositDetail getDepositDetail(DepositDetailList depositDetailList, int id) throws NotExistException{
		return depositDetailList.get(id);
	}

	public void getTaxPaymentDetail(){

	}
	public void handlePayment(PaymentDetail paymentDetail, PaymentDetailList paymentDetailList) throws NotExistException, AlreadyProcessedException{
		// if문 - 보험사 운영시간이 아닙니다. 다른 시간에 다시 이용해주세요 - 데코레이터 추가
		if (paymentDetail.getProcessStatus() == PaymentProcessStatus.Completed) {
			throw new AlreadyProcessedException("이미 지급이 완료되었습니다.");
		}
		paymentDetail.handle();
		paymentDetailList.update(paymentDetail);
	}
	// 메소드는 아래에 적어주셔유! (MVC 적용)
	public ArrayList<PaymentDetail> getAllPaymentDetail(PaymentDetailList paymentDetailList) {
		return paymentDetailList.getAllPaymentDetail();
	}
	public ArrayList<PaymentDetail> getAllUnprocessedPaymentDetail(PaymentDetailList paymentDetailList) {
		return paymentDetailList.getAllUnprocessedPaymentDetail();
	}
	public ArrayList<PaymentDetail> getAllCompletedPaymentDetail(PaymentDetailList paymentDetailList) {
		return paymentDetailList.getAllCompletedPaymentDetail();
	}
	public PaymentDetail get(PaymentDetailList paymentDetailList, int index) throws NotExistException {
		return paymentDetailList.get(index);
	}
	public Contract get(ContractList contractList, int id) throws NotExistContractException {
		return contractList.get(id);
	}
	public Customer get(CustomerList customerList, int id) throws NotExistException {
		return customerList.get(id);
	}
	public ArrayList<DepositDetail> getAllDepositDetail(DepositDetailList depositDetailList) {
		return depositDetailList.getAllDepositDetail();
	}
}