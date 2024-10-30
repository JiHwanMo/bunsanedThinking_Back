package controller;

import java.util.ArrayList;

import entity.partnerCompany.PartnerCompany;
import entity.partnerCompany.PartnerCompanyList;
import entity.report.Report;
import entity.report.ReportList;
import exception.NotExistException;
import model.partnerCompany.PartnerCompanyModel;

public class PartnerCompanyController {
	private PartnerCompanyModel partnerCompanyModel;
	public PartnerCompanyController() {
		partnerCompanyModel = new PartnerCompanyModel();
	}
	public PartnerCompany get(PartnerCompanyList partnerCompanyList, int id) throws NotExistException {
		return partnerCompanyModel.get(partnerCompanyList, id);
	}
	public ArrayList<Report> getAllReportByDamageAssessmentCompanyID(ReportList reportList, int id) {
		return partnerCompanyModel.getAllReportByDamageAssessmentCompanyID(reportList, id);
	}
	public Report get(ReportList reportList, int id) throws NotExistException {
		return partnerCompanyModel.get(reportList, id);
	}
	public void update(ReportList reportList, Report report) throws NotExistException {
		partnerCompanyModel.update(reportList, report);
	}
}
