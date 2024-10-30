package controller;

import java.util.ArrayList;

import entity.contract.Contract;
import entity.contract.ContractList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import exception.AlreadyProcessedException;
import exception.NotExistContractException;
import exception.NotExistException;
import model.underwriting.UnderwritingModel;

public class UnderwritingController {
	private UnderwritingModel underwritingModel;
	public UnderwritingController() {
		underwritingModel = new UnderwritingModel();
	}
	public void applyCoperation() {
		underwritingModel.applyCoperation();
	}

	public void applyReinsurance() {
		underwritingModel.applyReinsurance();
	}

	public boolean reviewAcquisition(Contract contract, boolean result, ContractList contractList)
			throws AlreadyProcessedException, NotExistContractException {
		return underwritingModel.reviewAcquisition(contract, result, contractList);
	}
	public ArrayList<Contract> getAllRequestingInsurance(ContractList contractList){
		return underwritingModel.getAllRequestingInsurance(contractList);
	}
	public Customer get(CustomerList customerList, int id) throws NotExistException {
		return underwritingModel.get(customerList, id);
	}
	public Contract get(ContractList contractList, int id) throws NotExistContractException {
		return underwritingModel.get(contractList, id);
	}
	public ArrayList<Contract> getAllNotRequestingInsurance(ContractList contractList){
		return underwritingModel.getAllNotRequestingInsurance(contractList);
	}
}
