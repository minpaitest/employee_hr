package com.emphr_hr.repository;

import org.springframework.stereotype.Repository;
import com.emphr_hr.entity.EmployeeInsurance;

@Repository
public interface EmployeeInsuranceRepository {
	
	EmployeeInsurance findById(String employee_id);

    void save(EmployeeInsurance employeeInsurance,String id);
}
