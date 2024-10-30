package model.managementPlanning;

import entity.department.Department;
import entity.department.DepartmentList;
import exception.DuplicateDepartmentException;
import exception.NotExistException;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 占쏙옙占쏙옙 4:40:43
 */
//2024-06-02 源����쁽
//2024-06-06 源����쁽
public class ManagementPlanningModel {

	public void addDepartment(String name, String task, String purpose, String headName, DepartmentList departmentList) throws DuplicateDepartmentException{
		for (Department department : departmentList.getAll()) {
			if (department.getName().equals(name)) {
				throw new DuplicateDepartmentException();
			}
		}
		Department department = new Department(name, task, purpose, headName);
		departmentList.add(department);
	}

	public void deleteDepartment(DepartmentList departmentList, int id) throws NotExistException{
		try {
			departmentList.delete(id);
		} catch (NotExistException e) {
			throw new NotExistException("해당하는 부서 정보가 존재하지 않습니다."); 
		}
	}

	public Department getDepartment(DepartmentList departmentList, int id) throws NotExistException{
		try {
			return departmentList.get(id);
		} catch (NotExistException e) {
			throw new NotExistException("해당하는 부서 정보가 존재하지 않습니다.");
		}
	}

	public void updateDepartment(int index, String input, Department department, DepartmentList departmentList) throws DuplicateDepartmentException, NotExistException{
		try {
			switch (index) {
			case 1:
				for (Department e : departmentList.getAll()) {
					if (e.getName().equals(input)) {
						throw new DuplicateDepartmentException();
					}
				}
				department.setName(input);
				departmentList.update(department);
				break;
			case 2:
				department.setTask(input);
				departmentList.update(department);
				break;
			case 3:
				department.setPurpose(input);
				departmentList.update(department);
				break;
			case 4:
				department.setHeadName(input);
				departmentList.update(department);
				break;
			default:
				break;
			}
		} catch (NotExistException e) {
			throw new NotExistException("해당하는 부서 정보가 존재하지 않습니다.");
		}
	}
	// 메소드는 아래에 적어주셔유! (MVC 적용)
}