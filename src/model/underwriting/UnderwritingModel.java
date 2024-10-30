package model.underwriting;

import java.util.ArrayList;

import entity.contract.Contract;
import entity.contract.ContractList;
import entity.contract.ContractStatus;
import entity.customer.Customer;
import entity.customer.CustomerList;
import exception.AlreadyProcessedException;
import exception.NotExistContractException;
import exception.NotExistException;

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
	public ArrayList<Contract> getAllRequestingInsurance(ContractList contractList){
		return contractList.getAllRequestingInsurance();
	}
	public Customer get(CustomerList customerList, int id) throws NotExistException {
		return customerList.get(id);
	}
	public Contract get(ContractList contractList, int id) throws NotExistContractException {
		return contractList.get(id);
	}
	public ArrayList<Contract> getAllNotRequestingInsurance(ContractList contractList){
		return contractList.getAllNotRequestingInsurance();
	}
}