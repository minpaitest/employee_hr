package com.emphr_hr.repository;

import com.emphr_hr.entity.EmergencyContact;

public interface EmergencyContactRepository {

	void save(EmergencyContact emergencycontact, String employee_id);

	EmergencyContact findById(String employee_id);

}