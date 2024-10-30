package model.loanManagement;

import java.util.ArrayList;

import entity.compensationDetail.CompensationDetail;
import entity.compensationDetail.CompensationDetailList;
import entity.contract.Contract;
import entity.contract.ContractList;
import entity.contract.ContractStatus;
import entity.customer.Customer;
import entity.loan.Collateral;
import entity.loan.CollateralType;
import entity.loan.FixedDeposit;
import entity.loan.InsuranceContract;
import entity.loan.Loan;
import entity.loan.LoanType;
import entity.paymentDetail.PaymentDetail;
import entity.paymentDetail.PaymentDetailList;
import entity.paymentDetail.PaymentType;
import entity.product.Product;
import entity.product.ProductList;
import exception.AlreadyProcessedException;
import exception.DuplicateLoanException;
import exception.NotExistContractException;
import exception.NotExistException;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 占쏙옙占쏙옙 4:40:42
 */
//2024-06-02 源����쁽
//2024-06-06 源����쁽
public class LoanManagementModel {

	public void addLoanProduct(LoanType loanType, String name, int interestRate, int limit, int minimumAsset,
			CollateralType collateralType, int minimumValue, ProductList productList) throws DuplicateLoanException {
		for (Product product : productList.getAll()) {
			if (product.getName().equals(name)) {
				throw new DuplicateLoanException();
			}
		}
		Collateral collateralLoan = new Collateral(loanType, name, interestRate, limit, minimumAsset, collateralType,
				minimumValue);
		productList.add(collateralLoan);
	}

	public void addLoanProduct(LoanType loanType, String name, int interestRate, int limit, int minimumAsset,
			int parameter, ProductList productList) throws DuplicateLoanException {
		if (loanType == LoanType.FixedDeposit) {
			for (Product product : productList.getAll()) {
				if (product.getName().equals(name)) {
					throw new DuplicateLoanException();
				}
			}
			FixedDeposit fixedDepositLoan = new FixedDeposit(loanType, name, interestRate, limit, minimumAsset,
					parameter);
			productList.add(fixedDepositLoan);
		} else if (loanType == LoanType.InsuranceContract) {
			for (Product product : productList.getAll()) {
				if (product.getName().equals(name)) {
					throw new DuplicateLoanException();
				}
			}
			InsuranceContract insuranceContractLoan = new InsuranceContract(loanType, name, interestRate, limit,
					minimumAsset, parameter);
			productList.add(insuranceContractLoan);
		}
	}

	public Loan getLoanProduct(ProductList productList, int id) throws NotExistException {
		try {
			return (Loan) productList.get(id);
		} catch (NotExistException e) {
			throw new NotExistException("해당하는 대출 상품 정보가 존재하지 않습니다.");
		}
	}

	public boolean collectLoanPrincipalInterest() {
		return true;
	}

	public void requestLoan(Contract contract, Customer customer, int money, PaymentType paymentType, boolean result,
			ContractList contractList, PaymentDetailList paymentDetailList, CompensationDetailList compensationDetailList) throws AlreadyProcessedException, NotExistContractException {
		if (contract.getContractStatus() != ContractStatus.ContractRequesting) {
			throw new AlreadyProcessedException();
		}
		contract.review(result, contractList);
		if(!result) {
			return;
		}
		PaymentDetail paymentDetail = new PaymentDetail(customer.getName(), customer.getBankName(),
				customer.getBankAccount(), money, paymentType, contract.getId());
		paymentDetailList.add(paymentDetail);
		CompensationDetail compensationDetail = new CompensationDetail(contract.getId(), money);
		compensationDetailList.add(compensationDetail);
		contract.addCompensationDetail(compensationDetail);
	}

	public void updateLoanProduct(int index, String input, Collateral collateralLoan, ProductList productList)
			throws DuplicateLoanException, NotExistException {
		switch (index) {
		case 1:
			for (Product product : productList.getAll()) {
				if (product.getName().equals(input)) {
					throw new DuplicateLoanException();
				}
			}
			collateralLoan.setName(input);
			productList.update(collateralLoan);
			break;
		case 2:
			collateralLoan.setInterestRate(Integer.parseInt(input));
			productList.update(collateralLoan);
			break;
		case 3:
			collateralLoan.setLimit(Integer.parseInt(input));
			productList.update(collateralLoan);
			break;
		case 4:
			collateralLoan.setMinimumAsset(Integer.parseInt(input));
			productList.update(collateralLoan);
			break;
		case 5:
			if (CollateralType.RealEstate.ordinal() == (Integer.parseInt(input) - 1)) {
				collateralLoan.setCollateralType(CollateralType.RealEstate);
			} else if (CollateralType.Car.ordinal() == (Integer.parseInt(input) - 1)) {
				collateralLoan.setCollateralType(CollateralType.Car);
			}
			productList.update(collateralLoan);
			break;
		case 6:
			collateralLoan.setMinimumValue(Integer.parseInt(input));
			productList.update(collateralLoan);
			break;
		default:
			break;
		}
	}

	public void updateLoanProduct(int index, String input, Loan loan, ProductList productList)
			throws DuplicateLoanException, NotExistException {
		if (loan instanceof FixedDeposit) {
			FixedDeposit fixedDepositLoan = (FixedDeposit) loan;
			switch (index) {
			case 1:
				for (Product product : productList.getAll()) {
					if (product.getName().equals(input)) {
						throw new DuplicateLoanException();
					}
				}
				fixedDepositLoan.setName(input);
				productList.update(fixedDepositLoan);
				break;
			case 2:
				fixedDepositLoan.setInterestRate(Integer.parseInt(input));
				productList.update(fixedDepositLoan);
				break;
			case 3:
				fixedDepositLoan.setLimit(Integer.parseInt(input));
				productList.update(fixedDepositLoan);
				break;
			case 4:
				fixedDepositLoan.setMinimumAsset(Integer.parseInt(input));
				productList.update(fixedDepositLoan);
				break;
			case 5:
				fixedDepositLoan.setMinimumAmount(Integer.parseInt(input));
				productList.update(fixedDepositLoan);
				break;
			default:
				break;
			}

		} else if (loan instanceof InsuranceContract) {
			InsuranceContract lnsuranceContractLoan = (InsuranceContract) loan;
			switch (index) {
			case 1:
				for (Product product : productList.getAll()) {
					if (product.getName().equals(input)) {
						throw new DuplicateLoanException();
					}
				}
				lnsuranceContractLoan.setName(input);
				productList.update(lnsuranceContractLoan);
				break;
			case 2:
				lnsuranceContractLoan.setInterestRate(Integer.parseInt(input));
				productList.update(lnsuranceContractLoan);
				break;
			case 3:
				lnsuranceContractLoan.setLimit(Integer.parseInt(input));
				productList.update(lnsuranceContractLoan);
				break;
			case 4:
				lnsuranceContractLoan.setMinimumAsset(Integer.parseInt(input));
				productList.update(lnsuranceContractLoan);
				break;
			case 5:
				lnsuranceContractLoan.setProductID(Integer.parseInt(input));
				productList.update(lnsuranceContractLoan);
				break;
			default:
				break;
			}
		}

	}

	public void deleteLoanProduct(ProductList productList, int id) throws NotExistException {
		productList.delete(id);
	}

	// 메소드는 아래에 적어주셔유! (MVC 적용)
	public ArrayList<Product> getAll(ProductList productList) {
		return productList.getAll();
	}

}