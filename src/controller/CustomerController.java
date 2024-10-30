package controller;

import java.util.ArrayList;

import entity.accident.Accident;
import entity.accident.AccidentList;
import entity.complaint.Complaint;
import entity.complaint.ComplaintList;
import entity.contract.Contract;
import entity.contract.ContractList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.depositDetail.DepositDetailList;
import entity.depositDetail.DepositPath;
import entity.endorsment.EndorsementList;
import entity.insurance.Insurance;
import entity.loan.Loan;
import entity.product.ProductList;
import entity.recontract.RecontractList;
import entity.revival.RevivalList;
import entity.temination.TerminationList;
import exception.NotExistContractException;
import exception.NotExistException;
import exception.NotExistExpiredContract;
import exception.NotExistMaintainedContract;
import exception.NotExistTerminatedContract;
import model.customer.CustomerModel;

public class CustomerController {
	private CustomerModel customerModel;
	public CustomerController() {
		customerModel = new CustomerModel();
	}
	public void applyEndorsement(ContractList contractList, EndorsementList endorsementList, int index,
			Contract contract) throws NotExistContractException {
		customerModel.applyEndorsement(contractList, endorsementList, index, contract);
	}
	public void applyInsuranceRevival(ContractList contractList, RevivalList revivalList, Contract contract,
			Customer customer) throws NotExistContractException, NotExistTerminatedContract {
		customerModel.applyInsuranceRevival(contractList, revivalList, contract, customer);
	}
	public void applyInsuranceTermination(ContractList contractList, TerminationList terminationList, Contract contract,
			Customer customer) throws NotExistContractException, NotExistMaintainedContract {
		customerModel.applyInsuranceTermination(contractList, terminationList, contract, customer);
	}
	public void applyRecontract(ContractList contractList, RecontractList recontractList, Contract contract,
			Customer customer) throws NotExistContractException, NotExistExpiredContract {
		customerModel.applyRecontract(contractList, recontractList, contract, customer);
	}
	public void payInsurancefee(Customer customer, Contract contract, int money, DepositPath path,
			DepositDetailList depositDetailList) {
		customerModel.payInsurancefee(customer, contract, money, path, depositDetailList);
	}
	public Insurance viewInsuranceProductList(ProductList productList, int id) throws NotExistException{
		return customerModel.viewInsuranceProductList(productList, id);
	}
	public Loan viewLoanProductList(ProductList productList, int id) throws NotExistException {
		return customerModel.viewLoanProductList(productList, id);
	}
	public Customer get(CustomerList customerList, int id) throws NotExistException {
		return customerModel.get(customerList, id);
	}
	public ArrayList<Insurance> getAllInsurance(ProductList productList) {
		return customerModel.getAllInsurance(productList);
	}
	public ArrayList<Insurance> getAllDiseaseInsurance(ProductList productList) {
		return customerModel.getAllDiseaseInsurance(productList);
	}
	public ArrayList<Insurance> getAllInjuryInsurance(ProductList productList) {
		return customerModel.getAllInjuryInsurance(productList);
	}
	public ArrayList<Insurance> getAllAutomobileInsurance(ProductList productList) {
		return customerModel.getAllAutomobileInsurance(productList);
	}
	public Insurance get(int id, ProductList productList) throws NotExistException {
		return customerModel.get(id, productList);
	}
	public ArrayList<Loan> getAllLoan(ProductList productList) {
		return customerModel.getAllLoan(productList);
	}
	public ArrayList<Loan> getAllCollateralLoan(ProductList productList) {
		return customerModel.getAllCollateralLoan(productList);
	}
	public ArrayList<Loan> getAllFixedDepositLoan(ProductList productList) {
		return customerModel.getAllFixedDepositLoan(productList);
	}
	public ArrayList<Loan> getAllInsuranceContractLoan(ProductList productList) {
		return customerModel.getAllInsuranceContractLoan(productList);
	}
	public Loan getLoan(ProductList productList, int id) throws NotExistException {
		return customerModel.getLoan(productList, id);
	}
	public ArrayList<Contract> getAllApprovedByCustomer(ContractList contractList, int id) throws NotExistContractException {
		return customerModel.getAllApprovedByCustomer(contractList, id);
	}
	public Insurance getInsurance(ProductList productList, int id) throws NotExistException {
		return customerModel.getInsurance(productList, id);
	}
	public ArrayList<Contract> getAllByCustomer(ContractList contractList, int id) throws NotExistContractException {
		return customerModel.getAllByCustomer(contractList, id);
	}
	public ArrayList<Contract> getAllAutomobileInsuranceContract(ContractList contractList) throws NotExistContractException {
		return customerModel.getAllAutomobileInsuranceContract(contractList);
	}
	public ArrayList<Contract> getAllInjuryInsuranceContract(ContractList contractList) throws NotExistContractException {
		return customerModel.getAllInjuryInsuranceContract(contractList);
	}
	public ArrayList<Contract> getAllDiseaseInsuranceContract(ContractList contractList) throws NotExistContractException {
		return customerModel.getAllDiseaseInsuranceContract(contractList);
	}
	public ArrayList<Contract> getContractByProductId(ContractList contractList, int id) {
		return customerModel.getContractByProductId(contractList, id);
	}
	public Contract get(ContractList contractList, int id) throws NotExistContractException {
		return customerModel.get(contractList, id);
	}
	public Contract getAutomobileByMember(ContractList contractList, int id) throws NotExistContractException {
		return customerModel.getAutomobileByMember(contractList, id);
	}
	public ArrayList<Accident> getAllByCustomer(AccidentList accidentList, int id) {
		return customerModel.getAllByCustomer(accidentList, id);
	}
	public Accident get(AccidentList accidentList, int id) throws NotExistException {
		return customerModel.get(accidentList, id);
	}
	public ArrayList<Complaint> getAllByCustomerId(ComplaintList complaintList, int id) {
		return customerModel.getAllByCustomerId(complaintList, id);
	}
	public Complaint get(ComplaintList complaintList, int id) throws NotExistException {
		return customerModel.get(complaintList, id);
	}
}
