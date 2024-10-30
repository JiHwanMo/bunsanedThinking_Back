package model.humanResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.department.Department;
import entity.department.DepartmentList;
import entity.employee.Employee;
import entity.employee.EmployeeList;
import entity.employee.EmployeePosition;
import entity.family.Family;
import entity.family.FamilyList;
import exception.DuplicateResidentRegistrationNumberException;
import exception.NotExistException;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 占쏙옙占쏙옙 4:40:42
 */
//2024-06-06 源����쁽
public class HumanResourceModel {

	public void addEmployee(int teamId, String name, EmployeePosition employeePosition, String address, String phoneNumber, String bankName, String bankAccount, String residentRegistrationNumber, int departmentID, int salary, String dateOfemployment, EmployeeList employeeList, ArrayList<Family> tempFamilyList, FamilyList familyList) throws DuplicateResidentRegistrationNumberException{
		for (Employee employee : employeeList.getAll()) {
			if (employee.getResidentRegistrationNumber().equals(residentRegistrationNumber)) {
				throw new DuplicateResidentRegistrationNumberException();
			}
		}
		Date date = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			date = formatter.parse(dateOfemployment);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Employee employee = null;
//		if(teamId ==110) {
//			employee = new FinancialAccountantModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==120) {
//			employee = new AdministrativeModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==130) {
//			employee = new CompensationModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==140) {
//			employee = new CustomerSupportModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==150) {
//			employee = new ManagementPlanningModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==160) {
//			employee = new HumanResourceModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==170) {
//			employee = new CustomerInformationManagementModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==180) {
//			employee = new Sales(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==190) {
//			employee = new ProductManagementModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==200) {
//			employee = new UnderwritingModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==210) {
//			employee = new CompensationPlanningModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==220) {
//			employee = new ContractManagementModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}else if(teamId ==230) {
//			employee = new LoanManagementModel(name, employeePosition,address, phoneNumber, bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
//			employeeList.add(employee);
//		}
		int[] teamIds = {110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230};
		for (int id : teamIds) {
			if (teamId == id) {
				employee = new Employee(name, employeePosition,address, phoneNumber, 
						bankName, bankAccount,residentRegistrationNumber, departmentID, salary,date);
				employeeList.add(employee);
			}
		}
		for(Family e:tempFamilyList) {
			e.setEmployeeID(employee.getId());
			familyList.add(e);
		}
		employee.setFamilyList(tempFamilyList);
	}

	public void deleteEmployee(EmployeeList employeeList, int id) throws NotExistException{
		employeeList.delete(id);
	}

	public Employee getEmployee(EmployeeList employeeList, int id) throws NotExistException{
		try {
			return employeeList.get(id);
		} catch (NotExistException e) {
			throw new NotExistException("해당하는 직원 정보가 존재하지 않습니다.");
		}
	}

	public void requestAdditionalAllowance(){
		System.out.println("Additional Allowance");
	}

	public void requestBenefit(){
		System.out.println("Request Benefit");
	}

	public void updateEmployee(int index, String input, Employee employee, EmployeeList employeeList) throws NotExistException {
		switch (index) {
		case 1:
			employee.setName(input);
			employeeList.update(employee);
			break;
		case 2:
			if (EmployeePosition.Intern.ordinal() == (Integer.parseInt(input) - 1)) {
				employee.setPosition(EmployeePosition.Intern);
			} else if (EmployeePosition.Staff.ordinal() == (Integer.parseInt(input) - 1)) {
				employee.setPosition(EmployeePosition.Staff);
			}else if (EmployeePosition.SeniorStaff.ordinal() == (Integer.parseInt(input) - 1)) {
				employee.setPosition(EmployeePosition.SeniorStaff);
			}else if (EmployeePosition.Manager.ordinal() == (Integer.parseInt(input) - 1)) {
				employee.setPosition(EmployeePosition.Manager);
			}else if (EmployeePosition.DeputyGeneralManager.ordinal() == (Integer.parseInt(input) - 1)) {
				employee.setPosition(EmployeePosition.DeputyGeneralManager);
			}else if (EmployeePosition.GeneralManager.ordinal() == (Integer.parseInt(input) - 1)) {
				employee.setPosition(EmployeePosition.GeneralManager);
			}
			employeeList.update(employee);
			break;
		case 3:
			employee.setAddress(input);
			employeeList.update(employee);
			break;
		case 4:
			employee.setPhoneNumber(input);
			employeeList.update(employee);
			break;
		case 5:
			employee.setBankName(input);
			employeeList.update(employee);
			break;
		case 6:
			employee.setBankAccount(input);
			employeeList.update(employee);
			break;
		case 8:
			employee.setDepartmentID(Integer.parseInt(input));
			employeeList.update(employee);
			break;
		case 9:
			employee.setSalary(Integer.parseInt(input));
			employeeList.update(employee);
			break;
		default:
			break;
		}
	}
	// 메소드는 아래에 적어주셔유! (MVC 적용)

	public ArrayList<Employee> getAll(EmployeeList employeeList) {
		return employeeList.getAll();
	}

	public ArrayList<Department> getAll(DepartmentList departmentList) {
		return departmentList.getAll();
	}

	public Department get(DepartmentList departmentList, int departmentID) throws NotExistException {
		return departmentList.get(departmentID);
	}
}