package model.contractManagement;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import entity.contract.Contract;
import entity.contract.ContractList;
import entity.contract.ContractStatus;
import entity.customer.Customer;
import entity.depositDetail.DepositDetail;
import entity.endorsment.Endorsement;
import entity.endorsment.EndorsementStatus;
import entity.insurance.Insurance;
import entity.paymentDetail.PaymentDetail;
import entity.paymentDetail.PaymentDetailList;
import entity.paymentDetail.PaymentType;
import entity.recontract.Recontract;
import entity.recontract.RecontractStatus;
import entity.revival.Revival;
import entity.revival.RevivalStatus;
import entity.temination.Termination;
import entity.temination.TerminationStatus;
import exception.AlreadyProcessedException;
import exception.NotExistContractException;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 占쏙옙占쏙옙 4:40:41
 */

public class ContractManagementModel {

	public boolean requestTerminationFee(Termination tercontract, Customer customer,
			PaymentDetailList paymentDetailList, ContractList contractList) throws NotExistContractException, AlreadyProcessedException {
		if (tercontract.getTerminationStatus() == TerminationStatus.Completed) {
			throw new AlreadyProcessedException();
		}
		ArrayList<DepositDetail> depositDetailList = tercontract.getDepositDetailList();
		int totalMoney = 0;
		for (DepositDetail depositDetail : depositDetailList) {
			totalMoney += depositDetail.getMoney();
		}
		totalMoney = (int) (totalMoney * 0.3);
		PaymentDetail paymentDetail = new PaymentDetail(customer.getName(), customer.getBankName(),
				customer.getBankAccount(), totalMoney, PaymentType.AccountTransfer, tercontract.getId());
		paymentDetailList.add(paymentDetail);
		Contract contract = tercontract.getOriginalContract();
		tercontract.setTerminationStatus(TerminationStatus.Completed);
		tercontract.setApplyDate(new Date());
		contract.setTerminationDate(tercontract.getApplyDate());
		contract.setContractStatus(ContractStatus.Terminating);
		contractList.update(contract);
		return true;
	}

	public boolean reviewEndorsement(Endorsement encontract, Customer customer, int index) {
		if (index == 1) {
			encontract.setPaymentDate(encontract.getPaymentDate());
			encontract.setEndorsementStatus(EndorsementStatus.Completed);
		} else if (index == 2) {
			encontract.setEndorsementStatus(EndorsementStatus.Unprocessed);
		}
		return true;
	}

	public boolean reviewRecontract(ContractList contractList, Recontract recontract, Customer customer, int index) throws NotExistContractException {
		if (index == 1) { // �듅�씤
			Contract contract = recontract.getOriginalContract().clone();
			Insurance product = (Insurance) recontract.getOriginalContract().getProduct();
			contract.setContractStatus(ContractStatus.Maintaining);
			contract.setDate(new Date());

			LocalDate currentDate = LocalDate.now();
			LocalDate expirationDate = currentDate.plusYears(product.getContractPeriod());
			contract.setExpirationDate(Date.from(expirationDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			contractList.update(contract);
			recontract.setRecontractStatus(RecontractStatus.Completed);
		} else if (index == 2) { // 嫄곗젅
			recontract.setRecontractStatus(RecontractStatus.Unprocessed);
		}
		return true;
	}

	public boolean reviewRevival(ContractList contractList, Revival revivalcontract, Customer customer, int index) {
		if (index == 1) {
			Contract contract = revivalcontract.getOriginalContract().clone();
			contract.setContractStatus(ContractStatus.Maintaining);
			contract.setDate(new Date());
			try {
				contractList.update(contract);
			} catch (NotExistContractException e) {
				e.printStackTrace();
			}
			revivalcontract.setRevivalStatus(RevivalStatus.Completed);
		} else if (index == 2) {
			revivalcontract.setRevivalStatus(RevivalStatus.Unprocessed);
		}
		return true;
	}
	// 메소드는 아래에 적어주셔유! (MVC 적용)
}