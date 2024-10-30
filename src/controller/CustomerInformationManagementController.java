package controller;

import java.util.ArrayList;

import entity.accidentHistory.AccidentHistory;
import entity.accidentHistory.AccidentHistoryList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.customer.Gender;
import entity.diseaseHistory.DiseaseHistory;
import entity.diseaseHistory.DiseaseHistoryList;
import entity.surgeryHistory.SurgeryHistory;
import entity.surgeryHistory.SurgeryHistoryList;
import exception.DuplicateResidentRegistrationNumberException;
import exception.NotExistException;
import model.customerInformationManagement.CustomerInformationManagementModel;

public class CustomerInformationManagementController {
	private CustomerInformationManagementModel customerInformationManagementModel;
	public CustomerInformationManagementController() {
		customerInformationManagementModel = new CustomerInformationManagementModel();
	}
	public void addCustomerInformation(String name, String phoneNumber, String job, int age, Gender gender, 
			String residentRegistrationNumber, String address, long property, ArrayList<AccidentHistory> tempAccidentHistoryList, 
			ArrayList<SurgeryHistory> tempSurgeryHistoryList, ArrayList<DiseaseHistory> tempDiseaseHistoryList, String bankName, 
			String bankAccount, CustomerList customerList, AccidentHistoryList accidentHistoryList, 
			SurgeryHistoryList surgeryHistoryList, DiseaseHistoryList diseaseHistoryList) throws DuplicateResidentRegistrationNumberException{
		customerInformationManagementModel.addCustomerInformation(name, phoneNumber, job, age, gender, 
				residentRegistrationNumber, address, property, tempAccidentHistoryList, tempSurgeryHistoryList, 
				tempDiseaseHistoryList, bankName, bankAccount, customerList, accidentHistoryList, 
				surgeryHistoryList, diseaseHistoryList);
	}

	public void deleteCustomerInformation(CustomerList customerList, int id) throws NotExistException{
		customerInformationManagementModel.deleteCustomerInformation(customerList, id);
	}
	public Customer getCustomerInformation(CustomerList customerList, int id) throws NotExistException{
		return customerInformationManagementModel.getCustomerInformation(customerList, id);
	}
	public void updateCustomerInformation(int index, String input, Customer customer, CustomerList customerList) throws DuplicateResidentRegistrationNumberException, NotExistException{
		customerInformationManagementModel.updateCustomerInformation(index, input, customer, customerList);
	}
	public ArrayList<Customer> getAll(CustomerList customerList) {
		return customerInformationManagementModel.getAll(customerList);
	}
}
