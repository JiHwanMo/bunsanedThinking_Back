package model.partnerCompany;

import java.util.ArrayList;

import entity.partnerCompany.PartnerCompany;
import entity.partnerCompany.PartnerCompanyList;
import entity.report.Report;
import entity.report.ReportList;
import exception.NotExistException;

public class PartnerCompanyModel {
	// 메소드는 아래에 적어주셔유! (MVC 적용)
	public PartnerCompany get(PartnerCompanyList partnerCompanyList, int id) throws NotExistException {
		return partnerCompanyList.get(id);
	}
	public ArrayList<Report> getAllReportByDamageAssessmentCompanyID(ReportList reportList, int id) {
		return reportList.getAllReportByDamageAssessmentCompanyID(id);
	}
	public Report get(ReportList reportList, int id) throws NotExistException {
		return reportList.get(id);
	}
	public void update(ReportList reportList, Report report) throws NotExistException {
		reportList.update(report);
	}
}
