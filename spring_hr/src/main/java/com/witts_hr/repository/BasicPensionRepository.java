package com.emphr_hr.repository;

import com.emphr_hr.entity.BasicPension;

public interface BasicPensionRepository {
	void save(BasicPension basicPension, String id);

	BasicPension findById(String employee_id);

}
