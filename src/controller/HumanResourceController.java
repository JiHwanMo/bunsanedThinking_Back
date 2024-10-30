package controller;

import java.util.ArrayList;

import entity.department.Department;
import entity.department.DepartmentList;
import entity.employee.Employee;
import entity.employee.EmployeeList;
import entity.employee.EmployeePosition;
import entity.family.Family;
import entity.family.FamilyList;
import exception.DuplicateResidentRegistrationNumberException;
import exception.NotExistException;
import model.humanResource.HumanResourceModel;

public class HumanResourceController {
	private HumanResourceModel humanResourceModel;
	public HumanResourceController() {
		humanResourceModel = new HumanResourceModel();
	}
	public void addEmployee(int teamId, String name, EmployeePosition employeePosition, String address, String phoneNumber, String bankName, String bankAccount, String residentRegistrationNumber, int departmentID, int salary, String dateOfemployment, EmployeeList employeeList, ArrayList<Family> tempFamilyList, FamilyList familyList) throws DuplicateResidentRegistrationNumberException{
		humanResourceModel.addEmployee(teamId, name, employeePosition, address, phoneNumber, 
				bankName, bankAccount, residentRegistrationNumber, departmentID, salary, 
				dateOfemployment, employeeList, tempFamilyList, familyList);
	}

	public void deleteEmployee(EmployeeList employeeList, int id) throws NotExistException{
		humanResourceModel.deleteEmployee(employeeList, id);
	}

	public Employee getEmployee(EmployeeList employeeList, int id) throws NotExistException{
		return humanResourceModel.getEmployee(employeeList, id);
	}

	public void requestAdditionalAllowance(){
		humanResourceModel.requestAdditionalAllowance();
	}

	public void requestBenefit(){
		humanResourceModel.requestBenefit();
	}

	public void updateEmployee(int index, String input, Employee employee, EmployeeList employeeList) throws NotExistException {
		humanResourceModel.updateEmployee(index, input, employee, employeeList);
	}
	public ArrayList<Employee> getAll(EmployeeList employeeList) {
		return humanResourceModel.getAll(employeeList);
	}
	public ArrayList<Department> getAll(DepartmentList departmentList) {
		return humanResourceModel.getAll(departmentList);
	}
	public Department get(DepartmentList departmentList, int departmentID) throws NotExistException {
		return humanResourceModel.get(departmentList, departmentID);
	}
}
