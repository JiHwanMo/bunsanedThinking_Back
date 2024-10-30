package model.sales;

import java.util.ArrayList;

import entity.accidentHistory.AccidentHistory;
import entity.contract.Contract;
import entity.contract.ContractList;
import entity.counsel.Counsel;
import entity.counsel.CounselList;
import entity.counsel.CounselProcessStatus;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.customer.Gender;
import entity.diseaseHistory.DiseaseHistory;
import entity.employee.EmployeeList;
import entity.employee.Sales;
import entity.insurance.Insurance;
import entity.loan.Loan;
import entity.product.Product;
import entity.product.ProductList;
import entity.surgeryHistory.SurgeryHistory;
import exception.AlreadyProcessedException;
import exception.NotExistException;

public class SalesModel {
	public void evaluateSalesPerformance(int evaluate, Sales sales, EmployeeList employeeList) throws NotExistException{
		sales.setEvaluate(evaluate);
		employeeList.update(sales);
	}

	public void handleInsuranceConsultation(Counsel counsel, CounselList counselList) throws NotExistException, AlreadyProcessedException{
		if (counsel.getProcessStatus() == CounselProcessStatus.Completed) {
			throw new AlreadyProcessedException();
		}
		counsel.handle();
		counselList.update(counsel);
	}

	public Customer induceInsuranceProduct(String name, String address, String bankAccount, String bankName, String phoneNumber,
			String job, long property, String residentRegistrationNumber, int age, Gender gender,
			ArrayList<DiseaseHistory> diseaseHistoryList, ArrayList<SurgeryHistory> surgeryHistoryList,
			ArrayList<AccidentHistory> accidentHistoryList, Product product, CustomerList customerList, ContractList contractList) { 
		
		Customer customer = new Customer(name, phoneNumber, job, age, gender, residentRegistrationNumber, address, property, bankName, bankAccount);
		customerList.add(customer);
		if(accidentHistoryList != null) {
			for(AccidentHistory e :accidentHistoryList) {
				e.setCustomerID(customer.getId());
				customer.setAccidentHistoryList(accidentHistoryList);
				accidentHistoryList.add(e);
			}
		}
		if(surgeryHistoryList != null) {
			for(SurgeryHistory e :surgeryHistoryList) {
				e.setCustomerID(customer.getId());
				customer.setSurgeryHistoryList(surgeryHistoryList);
				surgeryHistoryList.add(e);
			}
		}
		if(diseaseHistoryList != null) {
			for(DiseaseHistory e :diseaseHistoryList) {
				e.setCustomerID(customer.getId());
				customer.setDiseaseHistoryList(diseaseHistoryList);
				diseaseHistoryList.add(e);
			}
		}

		Contract contract = new Contract(customer.getId(), product);
		contractList.add(contract);

		return customer;
	}

	public Insurance getInsuranceProduct(ProductList productList, int id) throws NotExistException {
		return (Insurance) productList.get(id);

	}

	public Customer induceLoanProduct(String name, String address, String bankAccount, String bankName, String phoneNumber, 
			String job, long property, String residentRegistrationNumber, int age, Gender gender,
			ArrayList<DiseaseHistory> diseaseHistoryList, ArrayList<SurgeryHistory> surgeryHistoryList,
			ArrayList<AccidentHistory> accidentHistoryList, Product product, CustomerList customerList, ContractList contractList) {
		
		Customer customer = new Customer(name, phoneNumber, job, age, gender, residentRegistrationNumber, address, property, bankName, bankAccount);
		customerList.add(customer);
		if(accidentHistoryList != null) {
			for(AccidentHistory e :accidentHistoryList) {
				e.setCustomerID(customer.getId());
				customer.setAccidentHistoryList(accidentHistoryList);
				accidentHistoryList.add(e);
			}
		}
		if(surgeryHistoryList != null) {
			for(SurgeryHistory e :surgeryHistoryList) {
				e.setCustomerID(customer.getId());
				customer.setSurgeryHistoryList(surgeryHistoryList);
				surgeryHistoryList.add(e);
			}
		}
		if(diseaseHistoryList != null) {
			for(DiseaseHistory e :diseaseHistoryList) {
				e.setCustomerID(customer.getId());
				customer.setDiseaseHistoryList(diseaseHistoryList);
				diseaseHistoryList.add(e);
			}
		}

		Contract contract = new Contract(customer.getId(), product);
		contractList.add(contract);

		return customer;

	}
	public Loan getLoanProduct(ProductList productList, int id) throws NotExistException {
		return (Loan) productList.get(id);
	}
	// 메소드는 아래에 적어주셔유! (MVC 적용)
}
