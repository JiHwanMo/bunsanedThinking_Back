package model.customerSupport;

import entity.accident.Accident;
import entity.accident.AccidentProcessStatus;
import entity.complaint.Complaint;
import entity.complaint.ComplaintList;
import entity.complaint.ComplaintProcessStatus;
import entity.partnerCompany.PartnerCompany;
import entity.report.Report;
import entity.report.ReportList;
import exception.AlreadyProcessedException;
import exception.NotExistException;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 占쏙옙占쏙옙 4:40:41
 */
//2024-06-06 源����쁽
public class CustomerSupportModel {

	public void handleComplaint(String employeeName, Complaint complaint, String result, ComplaintList complaintList) throws NotExistException, AlreadyProcessedException{
		if (complaint.getProcessStatus() == ComplaintProcessStatus.Completed) {
			throw new AlreadyProcessedException("이미 민원 처리가 완료되었습니다.");
		}
		// 로그인한 직원 이름이 여기 드감
		complaint.handle(employeeName, result);
		complaintList.update(complaint);
	}

	public void handleAccident(Accident accident, PartnerCompany damageAssessmentCompany,
			PartnerCompany roadsideAssistanceCompany, ReportList reportList) throws AlreadyProcessedException {
		if (accident.getProcessStatus() == AccidentProcessStatus.Completed) {
			throw new AlreadyProcessedException("이미 신고 처리가 완료되었습니다.");
		} else if (accident.getProcessStatus() == AccidentProcessStatus.Processing) {
			throw new AlreadyProcessedException("신고 처리 중입니다.");
		}
		accident.processing();
		Report report = new Report(accident, damageAssessmentCompany, roadsideAssistanceCompany);
		reportList.add(report);
	}
	// 메소드는 아래에 적어주셔유! (MVC 적용)
}