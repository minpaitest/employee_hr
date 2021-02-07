package com.emphr_hr.repository;

import org.springframework.stereotype.Repository;


import com.emphr_hr.entity.HealthInsurance;

@Repository
public interface HealthInsuranceRepository {
	HealthInsurance findById(String employee_id);
	
	void save(HealthInsurance healthInsurance,String id);

}
