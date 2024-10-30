package controller;

import java.util.ArrayList;

import entity.officeSupply.OfficeSupply;
import entity.officeSupply.OfficeSupplyList;
import exception.DuplicateOfficeSupplyException;
import exception.NotExistException;
import model.administrative.AdministrativeModel;

public class AdministrativeController {
	private AdministrativeModel administrativeModel;
	public AdministrativeController() {
		administrativeModel = new AdministrativeModel();
	}
	public void addOfficeSupply(String name, String explain, int inventory, OfficeSupplyList officeSupplyList) throws DuplicateOfficeSupplyException{
		administrativeModel.addOfficeSupply(name, explain, inventory, officeSupplyList);
	}

	public void deleteOfficeSupply(OfficeSupplyList officeSupplyList, int id) throws NotExistException{
		administrativeModel.deleteOfficeSupply(officeSupplyList, id);
	}
	public OfficeSupply getOfficeSupply(OfficeSupplyList officeSupplyList, int id) throws NotExistException{
		return administrativeModel.getOfficeSupply(officeSupplyList, id);
	}
	public void updateDepartment(int index, String input, OfficeSupply officeSupply,
			OfficeSupplyList officeSupplyList) throws DuplicateOfficeSupplyException, NotExistException {
		administrativeModel.updateDepartment(index, input, officeSupply, officeSupplyList);
	}
	public ArrayList<OfficeSupply> getAll(OfficeSupplyList officeSupplyList) {
		return administrativeModel.getAll(officeSupplyList);
	}
	public int getTotalInventory(OfficeSupplyList officeSupplyList) {
		return administrativeModel.getTotalInventory(officeSupplyList);
	}
}
