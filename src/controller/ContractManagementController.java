package controller;

import java.util.ArrayList;

import entity.contract.Contract;
import entity.contract.ContractList;
import entity.customer.Customer;
import entity.customer.CustomerList;
import entity.endorsment.Endorsement;
import entity.endorsment.EndorsementList;
import entity.paymentDetail.PaymentDetailList;
import entity.recontract.Recontract;
import entity.recontract.RecontractList;
import entity.revival.Revival;
import entity.revival.RevivalList;
import entity.temination.Termination;
import entity.temination.TerminationList;
import exception.AlreadyProcessedException;
import exception.NotExistContractException;
import exception.NotExistException;
import model.contractManagement.ContractManagementModel;

public class ContractManagementController {
	private ContractManagementModel contractManagementModel;
	public ContractManagementController() {
		contractManagementModel = new ContractManagementModel();
	}
	public boolean requestTerminationFee(Termination tercontract, Customer customer,
			PaymentDetailList paymentDetailList, ContractList contractList) throws NotExistContractException, AlreadyProcessedException {
		return contractManagementModel.requestTerminationFee(tercontract, customer, paymentDetailList, contractList);
	}

	public boolean reviewEndorsement(Endorsement encontract, Customer customer, int index) {
		return contractManagementModel.reviewEndorsement(encontract, customer, index);
	}

	public boolean reviewRecontract(ContractList contractList, Recontract recontract, Customer customer, int index) throws NotExistContractException {
		return contractManagementModel.reviewRecontract(contractList, recontract, customer, index);
	}

	public boolean reviewRevival(ContractList contractList, Revival revivalcontract, Customer customer, int index) {
		return contractManagementModel.reviewRevival(contractList, revivalcontract, customer, index);
	}
	public ArrayList<Contract> getAllDefaultContract(ContractList contractList) {
		return contractManagementModel.getAllDefaultContract(contractList);
	}

	public Customer get(CustomerList customerList, Contract contract) throws NotExistException {
		return contractManagementModel.get(customerList, contract);
	}

	public Contract get(ContractList contractList, int id) throws NotExistContractException {
		return contractManagementModel.get(contractList, id);
	}

	public Termination get(TerminationList terminationList, int id) {
		return contractManagementModel.get(terminationList, id);
	}

	public ArrayList<Termination> getAllTerminatingContract(TerminationList terminationList) {
		return contractManagementModel.getAllTerminatingContract(terminationList);
	}

	public Termination getTerminatingContractById(TerminationList terminationList,int id) {
		return contractManagementModel.getTerminatingContractById(terminationList, id);
	}

	public ArrayList<Termination> getAllUnprocessedTerminatingContract(TerminationList terminationList) {
		return contractManagementModel.getAllUnprocessedTerminatingContract(terminationList);
	}

	public ArrayList<Termination> getAllProcessedTerminatingContract(TerminationList terminationList) {
		return contractManagementModel.getAllProcessedTerminatingContract(terminationList);
	}

	public ArrayList<Endorsement> getAllEndorsementContract(EndorsementList endorsementList) {
		return contractManagementModel.getAllEndorsementContract(endorsementList);
	}

	public ArrayList<Endorsement> getAllUnprocessedEndorsementContract(EndorsementList endorsementList) {
		return contractManagementModel.getAllUnprocessedEndorsementContract(endorsementList);
	}

	public ArrayList<Endorsement> getAllProcessedEndorsementContract(EndorsementList endorsementList) {
		return contractManagementModel.getAllProcessedEndorsementContract(endorsementList);
	}

	public Endorsement get(EndorsementList endorsementList, int id) {
		return contractManagementModel.get(endorsementList, id);
	}

	public ArrayList<Recontract> getAllReContract(RecontractList recontractList) {
		return contractManagementModel.getAllReContract(recontractList);
	}

	public ArrayList<Recontract> getAllUnprocessedReContract(RecontractList recontractList) {
		return contractManagementModel.getAllUnprocessedReContract(recontractList);
	}

	public ArrayList<Recontract> getAllProcessedReContract(RecontractList recontractList) {
		return contractManagementModel.getAllProcessedReContract(recontractList);
	}

	public Recontract getReContractById(RecontractList recontractList, int id) {
		return contractManagementModel.getReContractById(recontractList, id);
	}

	public Recontract get(RecontractList recontractList, int id) {
		return contractManagementModel.get(recontractList, id);
	}

	public ArrayList<Revival> getAllRevivalContract(RevivalList revivalList) {
		return contractManagementModel.getAllRevivalContract(revivalList);
	}

	public Revival getRevivalById(RevivalList revivalList, int id) {
		return contractManagementModel.getRevivalById(revivalList, id);
	}

	public ArrayList<Revival> getAllUnprocessedRevival(RevivalList revivalList) {
		return contractManagementModel.getAllUnprocessedRevival(revivalList);
	}

	public ArrayList<Revival> getAllProcessedRevival(RevivalList revivalList) {
		return contractManagementModel.getAllProcessedRevival(revivalList);
	}

	public Revival get(RevivalList revivalList, int id) {
		return contractManagementModel.get(revivalList, id);
	}
}
