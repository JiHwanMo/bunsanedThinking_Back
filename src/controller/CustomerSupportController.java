package controller;

import java.util.ArrayList;

import entity.accident.Accident;
import entity.accident.AccidentList;
import entity.complaint.Complaint;
import entity.complaint.ComplaintList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.partnerCompany.PartnerCompany;
import entity.partnerCompany.PartnerCompanyList;
import entity.report.ReportList;
import exception.AlreadyProcessedException;
import exception.NotExistException;
import model.customerSupport.CustomerSupportModel;

public class CustomerSupportController {
	private CustomerSupportModel customerSupportModel;
	public CustomerSupportController() {
		customerSupportModel = new CustomerSupportModel();
	}
	public void handleComplaint(String employeeName, Complaint complaint, String result, ComplaintList complaintList) throws NotExistException, AlreadyProcessedException{
		customerSupportModel.handleComplaint(employeeName, complaint, result, complaintList);
	}

	public void handleAccident(Accident accident, PartnerCompany damageAssessmentCompany,
			PartnerCompany roadsideAssistanceCompany, ReportList reportList) throws AlreadyProcessedException {
		customerSupportModel.handleAccident(accident, damageAssessmentCompany, roadsideAssistanceCompany, reportList);
	}
	public ArrayList<Complaint> getAll(ComplaintList complaintList) {
		return customerSupportModel.getAll(complaintList);
	}
	public ArrayList<Complaint> getAllUnprocessedComplaint(ComplaintList complaintList) {
		return customerSupportModel.getAllUnprocessedComplaint(complaintList);
	}
	public ArrayList<Complaint> getAllProcessedComplant(ComplaintList complaintList) {
		return customerSupportModel.getAllProcessedComplant(complaintList);
	}
	public Complaint get(ComplaintList complaintList, int id) throws NotExistException {
		return customerSupportModel.get(complaintList, id);
	}
	public Customer get(CustomerList customerList, int customerID) throws NotExistException {
		return customerSupportModel.get(customerList, customerID);
	}
	public ArrayList<Accident> getAll(AccidentList accidentList) {
		return customerSupportModel.getAll(accidentList);
	}
	public ArrayList<Accident> getAllUnprocessedReport(AccidentList accidentList) {
		return customerSupportModel.getAllUnprocessedReport(accidentList);
	}
	public ArrayList<Accident> getAllCompletedReport(AccidentList accidentList) {
		return customerSupportModel.getAllCompletedReport(accidentList);
	}
	public Accident get(AccidentList accidentList, int id) throws NotExistException {
		return customerSupportModel.get(accidentList, id);
	}
	public ArrayList<PartnerCompany> getAllRoadAssistanceCompany(PartnerCompanyList partnerCompanyList) {
		return customerSupportModel.getAllRoadAssistanceCompany(partnerCompanyList);
	}
	public PartnerCompany getRoadAssistanceCompany(PartnerCompanyList partnerCompanyList, int id) throws NotExistException {
		return customerSupportModel.getRoadAssistanceCompany(partnerCompanyList, id);
	}
	public ArrayList<PartnerCompany> getAllDamageAssessmentCompany(PartnerCompanyList partnerCompanyList) {
		return customerSupportModel.getAllDamageAssessmentCompany(partnerCompanyList);
	}
	public PartnerCompany getDamageAssessmentCompany(PartnerCompanyList partnerCompanyList, int id) throws NotExistException {
		return customerSupportModel.getDamageAssessmentCompany(partnerCompanyList, id);
	}
}
