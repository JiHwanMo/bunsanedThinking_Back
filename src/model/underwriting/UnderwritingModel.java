package model.underwriting;

import entity.contract.Contract;
import entity.contract.ContractList;
import entity.contract.ContractStatus;
import exception.AlreadyProcessedException;
import exception.NotExistContractException;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 4:40:44
 */
//2024-06-06 김대현
public class UnderwritingModel {

	public void applyCoperation() {

	}

	public void applyReinsurance() {

	}

	public boolean reviewAcquisition(Contract contract, boolean result, ContractList contractList)
			throws AlreadyProcessedException, NotExistContractException {
		if (contract.getContractStatus() != ContractStatus.ContractRequesting) {
			throw new AlreadyProcessedException();
		}
		contract.review(result, contractList);
		return result;
	}
	// 메소드는 아래에 적어주셔유! (MVC 적용)
}