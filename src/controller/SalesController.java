package controller;

import java.util.ArrayList;

import entity.accidentHistory.AccidentHistory;
import entity.contract.ContractList;
import entity.counsel.Counsel;
import entity.counsel.CounselList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.customer.Gender;
import entity.diseaseHistory.DiseaseHistory;
import entity.diseaseHistory.DiseaseHistoryList;
import entity.employee.Employee;
import entity.employee.EmployeeList;
import entity.employee.Sales;
import entity.insurance.Insurance;
import entity.loan.Loan;
import entity.product.Product;
import entity.product.ProductList;
import entity.surgeryHistory.SurgeryHistory;
import exception.AlreadyProcessedException;
import exception.NotExistException;
import model.sales.SalesModel;

public class SalesController {
	private SalesModel salesModel;
	public SalesController() {
		salesModel = new SalesModel();
	}
	public void evaluateSalesPerformance(int evaluate, Sales sales, EmployeeList employeeList) throws NotExistException{
		salesModel.evaluateSalesPerformance(evaluate, sales, employeeList);
	}

	public void handleInsuranceConsultation(Counsel counsel, CounselList counselList) throws NotExistException, AlreadyProcessedException{
		salesModel.handleInsuranceConsultation(counsel, counselList);
	}

	public Customer induceInsuranceProduct(String name, String address, String bankAccount, String bankName, String phoneNumber,
			String job, long property, String residentRegistrationNumber, int age, Gender gender,
			ArrayList<DiseaseHistory> diseaseHistoryList, ArrayList<SurgeryHistory> surgeryHistoryList,
			ArrayList<AccidentHistory> accidentHistoryList, Product product, CustomerList customerList, ContractList contractList) { 
		return salesModel.induceInsuranceProduct(name, address, bankAccount, bankName, phoneNumber, job, property, residentRegistrationNumber, 
				age, gender, diseaseHistoryList, surgeryHistoryList, accidentHistoryList, product, customerList, contractList);
	}

	public Insurance getInsuranceProduct(ProductList productList, int id) throws NotExistException {
		return salesModel.getInsuranceProduct(productList, id);
	}

	public Customer induceLoanProduct(String name, String address, String bankAccount, String bankName, String phoneNumber, 
			String job, long property, String residentRegistrationNumber, int age, Gender gender,
			ArrayList<DiseaseHistory> diseaseHistoryList, ArrayList<SurgeryHistory> surgeryHistoryList,
			ArrayList<AccidentHistory> accidentHistoryList, Product product, CustomerList customerList, ContractList contractList) {
		return salesModel.induceLoanProduct(name, address, bankAccount, bankName, phoneNumber, job, property, 
				residentRegistrationNumber, age, gender, diseaseHistoryList, surgeryHistoryList, 
				accidentHistoryList, product, customerList, contractList);
	}
	public Loan getLoanProduct(ProductList productList, int id) throws NotExistException {
		return salesModel.getLoanProduct(productList, id);
	}
	public ArrayList<Employee> getAll(EmployeeList employeeList){
		return salesModel.getAll(employeeList);
	}
	public Employee get(EmployeeList employeeList, int id) throws NotExistException {
		return salesModel.get(employeeList, id);
	}
	public Sales getSales(EmployeeList employeeList, int id) throws NotExistException {
		return salesModel.getSales(employeeList, id);
	}
	public ArrayList<Counsel> getAll(CounselList counselList){
		return salesModel.getAll(counselList);
	}
	public Counsel get(CounselList counselList, int id) throws NotExistException {
		return salesModel.get(counselList, id);
	}
	public ArrayList<Product> getAll(ProductList productList){
		return salesModel.getAll(productList);
	}
	public void add(DiseaseHistoryList diseaseHistoryList, DiseaseHistory diseaseHistory){
		salesModel.add(diseaseHistoryList, diseaseHistory);
	}
	public void update(EmployeeList employeeList, Sales sales) throws NotExistException {
		salesModel.update(employeeList, sales);
	}
	public ArrayList<Insurance> getAllDiseaseInsurance(ProductList productList){
		return salesModel.getAllDiseaseInsurance(productList);
	}
	public ArrayList<Insurance> getAllInjuryInsurance(ProductList productList){
		return salesModel.getAllInjuryInsurance(productList);
	}
	public ArrayList<Insurance> getAllAutomobileInsurance(ProductList productList){
		return salesModel.getAllAutomobileInsurance(productList);
	}
	public ArrayList<Loan> getAllCollateralLoan(ProductList productList){
		return salesModel.getAllCollateralLoan(productList);
	}
	public ArrayList<Loan> getAllFixedDepositLoan(ProductList productList){
		return salesModel.getAllFixedDepositLoan(productList);
	}
	public ArrayList<Loan> getAllInsuranceContractLoan(ProductList productList){
		return salesModel.getAllInsuranceContractLoan(productList);
	}
	public Sales getSalesContractCount(EmployeeList employeeList, int id) throws NotExistException {
		return salesModel.getSalesContractCount(employeeList, id);
	}
}
