package com.emphr_hr.repository;

import com.emphr_hr.entity.BankAccountInfo;

public interface BankRepository {

	void save(BankAccountInfo bank_account_info, String employee_id);
	
	BankAccountInfo findById(String employee_id);

}