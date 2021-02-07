package com.emphr_hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emphr_hr.entity.BankAccountInfo;
import com.emphr_hr.entity.EmployeeInsurance;
import com.emphr_hr.repository.BankRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class BankController {
	@Autowired
	private BankRepository bankRepository;

	// @PostMapping("/employee/register/bank")
	@PostMapping("/employee/register/bank/{employee_id}")
	public ResponseEntity<Void> createBank(@RequestBody BankAccountInfo bank_account_info, @PathVariable String employee_id) {

		bank_account_info.setEmployee_id(employee_id);
		bankRepository.save(bank_account_info,employee_id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/bank/{employee_id}")
	public BankAccountInfo getBank(@PathVariable String employee_id) {
		return bankRepository.findById(employee_id);

	}

}