package com.emphr_hr.repository;
import java.util.List;

import com.emphr_hr.entity.DependentInfo;


public interface DependentInfoRepository {
	void save(DependentInfo dependentInfo);
	
	List<DependentInfo> findByemployeeId(String employee_id);
	
	void update(DependentInfo dependentInfo, long dependentInfo_id);
	
	void deleteById(long dependentInfo_id);
	
	DependentInfo findById(long dependentInfo_id);
	
	DependentInfo findBydependentInfoId(long dependentInfo_id);

}
