package model.compensation;

import entity.accident.AccidentList;
import entity.customer.Customer;
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
}