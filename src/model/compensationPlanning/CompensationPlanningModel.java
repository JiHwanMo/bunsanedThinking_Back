package model.compensationPlanning;

import entity.partnerCompany.PartnerCompany;
import entity.partnerCompany.PartnerCompanyList;
import entity.partnerCompany.PartnerCompanyType;
import exception.DuplicatePartnerCompanyException;
import exception.NotExistException;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 占쏙옙占쏙옙 4:40:40
 */

//2024-06-04 源����쁽
//2024-06-06 源����쁽
public class CompensationPlanningModel {

	public void addPartnerCompany(String name, String phoneNumber, PartnerCompanyType partnerCompanyType, String headName,String headPhoneNumber, PartnerCompanyList partnerCompanyList) throws DuplicatePartnerCompanyException{
		for (PartnerCompany partnerCompany : partnerCompanyList.getAll()) {
			if (partnerCompany.getName().equals(name)) {
				throw new DuplicatePartnerCompanyException();
			}
		}
		
		PartnerCompany PartnerCompany = new PartnerCompany(name, phoneNumber, partnerCompanyType, headName, headPhoneNumber);
		partnerCompanyList.add(PartnerCompany);
	}


	public void evaluatePartnerCompany(int evaluate, PartnerCompany partnerCompany, PartnerCompanyList partnerCompanyList) throws NotExistException{
		partnerCompany.setEvaluation(evaluate);
		partnerCompanyList.update(partnerCompany);
	}

	public PartnerCompany getPartnerCompany(PartnerCompanyList partnerCompanyList, int id) throws NotExistException{
		try {
			return partnerCompanyList.get(id);
		} catch (NotExistException e) {
			throw new NotExistException("해당하는 협력 업체 정보가 존재하지 않습니다.");
		}
	}

	public void updatePartnerCompany(int index, String input, PartnerCompany partnerCompany, PartnerCompanyList partnerCompanyList) throws DuplicatePartnerCompanyException, NotExistException{
		switch (index) {
		case 1:
			for (PartnerCompany e : partnerCompanyList.getAll()) {
				if (e.getName().equals(input)) {
					throw new DuplicatePartnerCompanyException();
				}
			}
			partnerCompany.setName(input);
			partnerCompanyList.update(partnerCompany);
			break;
		case 2:
			partnerCompany.setPhoneNumber(input);
			partnerCompanyList.update(partnerCompany);
			break;
		case 3:
			partnerCompany.setHeadName(input);
			partnerCompanyList.update(partnerCompany);
			break;
		case 4:
			partnerCompany.setHeadPhoneNumber(input);
			partnerCompanyList.update(partnerCompany);
			break;
		default:
			break;
		}
	}

	public void deletePartnerCompany(PartnerCompanyList partnerCompanyList, int id) throws NotExistException {
		partnerCompanyList.delete(id);
	}
	// 메소드는 아래에 적어주셔유! (MVC 적용)
}