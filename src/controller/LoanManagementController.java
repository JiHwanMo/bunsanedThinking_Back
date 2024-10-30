package controller;

import java.util.ArrayList;

import entity.compensationDetail.CompensationDetailList;
import entity.contract.Contract;
import entity.contract.ContractList;
import entity.customer.Customer;
import entity.loan.Collateral;
import entity.loan.CollateralType;
import entity.loan.Loan;
import entity.loan.LoanType;
import entity.paymentDetail.PaymentDetailList;
import entity.paymentDetail.PaymentType;
import entity.product.Product;
import entity.product.ProductList;
import exception.AlreadyProcessedException;
import exception.DuplicateLoanException;
import exception.NotExistContractException;
import exception.NotExistException;
import model.loanManagement.LoanManagementModel;

public class LoanManagementController {
	private LoanManagementModel loanManagementModel;
	public LoanManagementController() {
		loanManagementModel = new LoanManagementModel();
	}
	public void addLoanProduct(LoanType loanType, String name, int interestRate, int limit, int minimumAsset,
			CollateralType collateralType, int minimumValue, ProductList productList) throws DuplicateLoanException {
		loanManagementModel.addLoanProduct(loanType, name, interestRate, limit, minimumAsset, collateralType, minimumValue, productList);
	}

	public void addLoanProduct(LoanType loanType, String name, int interestRate, int limit, int minimumAsset,
			int parameter, ProductList productList) throws DuplicateLoanException {
		loanManagementModel.addLoanProduct(loanType, name, interestRate, limit, minimumAsset, parameter, productList);
	}

	public Loan getLoanProduct(ProductList productList, int id) throws NotExistException {
		return loanManagementModel.getLoanProduct(productList, id);
	}

	public boolean collectLoanPrincipalInterest() {
		return loanManagementModel.collectLoanPrincipalInterest();
	}

	public void requestLoan(Contract contract, Customer customer, int money, PaymentType paymentType, boolean result,
			ContractList contractList, PaymentDetailList paymentDetailList, CompensationDetailList compensationDetailList) throws AlreadyProcessedException, NotExistContractException {
		loanManagementModel.requestLoan(contract, customer, money, paymentType, 
				result, contractList, paymentDetailList, compensationDetailList);
	}

	public void updateLoanProduct(int index, String input, Collateral collateralLoan, ProductList productList)
			throws DuplicateLoanException, NotExistException {
		loanManagementModel.updateLoanProduct(index, input, collateralLoan, productList);
	}

	public void updateLoanProduct(int index, String input, Loan loan, ProductList productList)
			throws DuplicateLoanException, NotExistException {
		loanManagementModel.updateLoanProduct(index, input, loan, productList);
	}
	public void deleteLoanProduct(ProductList productList, int id) throws NotExistException {
		loanManagementModel.deleteLoanProduct(productList, id);
	}
	public ArrayList<Product> getAll(ProductList productList) {
		return loanManagementModel.getAll(productList);
	}
}
