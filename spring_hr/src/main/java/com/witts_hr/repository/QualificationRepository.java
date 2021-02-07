package com.emphr_hr.repository;

import java.util.List;

import com.emphr_hr.entity.Qualification;

public interface QualificationRepository {
	void save(Qualification qualification);

	void update(Qualification qualification, long qualification_id);

	void deleteById(long qualification_id);

	Qualification findById(long qualification_id);

	List<Qualification> findByemployeeId(String employee_id);

	Qualification findByqualificationId(long qualification_id);

}
