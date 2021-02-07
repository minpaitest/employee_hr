package com.emphr_hr.repository;

import java.util.List;
import com.emphr_hr.entity.Employee;

public interface EmployeeRepository {
	void save(String employee_id, Employee employee);

	Employee findByemployeeId(String employee_id);

	List<Employee> findAll();

	void deleteById(String employee_id);
	
	List<Employee> findByEmployeeId(String employee_id);

}
