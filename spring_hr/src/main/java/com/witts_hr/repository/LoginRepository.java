package com.emphr_hr.repository;

import com.emphr_hr.entity.Login;

public interface LoginRepository {

	Login findByEmployeeId(String user_id, String password);

}