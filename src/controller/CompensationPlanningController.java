package controller;

import java.util.ArrayList;

import entity.partnerCompany.PartnerCompany;
import entity.partnerCompany.PartnerCompanyList;
import entity.partnerCompany.PartnerCompanyType;
import exception.DuplicatePartnerCompanyException;
import exception.NotExistException;
import model.compensationPlanning.CompensationPlanningModel;

public class CompensationPlanningController {
	private CompensationPlanningModel compensationPlanningModel;
	public CompensationPlanningController() {
		compensationPlanningModel = new CompensationPlanningModel();
	}
	public void addPartnerCompany(String name, String phoneNumber, PartnerCompanyType partnerCompanyType, String headName,String headPhoneNumber, PartnerCompanyList partnerCompanyList) throws DuplicatePartnerCompanyException{
		compensationPlanningModel.addPartnerCompany(name, phoneNumber, partnerCompanyType, headName, headPhoneNumber, partnerCompanyList);
	}
	public void evaluatePartnerCompany(int evaluate, PartnerCompany partnerCompany, PartnerCompanyList partnerCompanyList) throws NotExistException{
		compensationPlanningModel.evaluatePartnerCompany(evaluate, partnerCompany, partnerCompanyList);
	}
	public PartnerCompany getPartnerCompany(PartnerCompanyList partnerCompanyList, int id) throws NotExistException{
		return compensationPlanningModel.getPartnerCompany(partnerCompanyList, id);
	}
	public void updatePartnerCompany(int index, String input, PartnerCompany partnerCompany, PartnerCompanyList partnerCompanyList) throws DuplicatePartnerCompanyException, NotExistException{
		compensationPlanningModel.updatePartnerCompany(index, input, partnerCompany, partnerCompanyList);
	}
	public void deletePartnerCompany(PartnerCompanyList partnerCompanyList, int id) throws NotExistException {
		compensationPlanningModel.deletePartnerCompany(partnerCompanyList, id);
	}
	public ArrayList<PartnerCompany> getAll(PartnerCompanyList partnerCompanyList) {
		return compensationPlanningModel.getAll(partnerCompanyList);
	}
}
