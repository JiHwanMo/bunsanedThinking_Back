package controller;

import entity.department.Department;
import entity.department.DepartmentList;
import exception.DuplicateDepartmentException;
import exception.NotExistException;
import model.managementPlanning.ManagementPlanningModel;

public class ManagementPlanningController {
	private ManagementPlanningModel managementPlanningModel;
	public ManagementPlanningController() {
		managementPlanningModel = new ManagementPlanningModel();
	}
	public void addDepartment(String name, String task, String purpose, String headName, DepartmentList departmentList) throws DuplicateDepartmentException{
		managementPlanningModel.addDepartment(name, task, purpose, headName, departmentList);
	}

	public void deleteDepartment(DepartmentList departmentList, int id) throws NotExistException{
		managementPlanningModel.deleteDepartment(departmentList, id);
	}

	public Department getDepartment(DepartmentList departmentList, int id) throws NotExistException{
		return managementPlanningModel.getDepartment(departmentList, id);
	}

	public void updateDepartment(int index, String input, Department department, DepartmentList departmentList) throws DuplicateDepartmentException, NotExistException{
		managementPlanningModel.updateDepartment(index, input, department, departmentList);
	}
}
