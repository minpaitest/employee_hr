package com.emphr_hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.emphr_hr.entity.Login;
import com.emphr_hr.repository.LoginRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class LoginController {
	@Autowired
	private LoginRepository loginRepository;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/login/{employee_id}/{password}")
	public Login loginEmployee(@PathVariable String employee_id, @PathVariable String password) {
		return loginRepository.findByEmployeeId(employee_id, password);
	}
}