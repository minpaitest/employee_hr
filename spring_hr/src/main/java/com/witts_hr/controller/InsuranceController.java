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
import com.emphr_hr.entity.EmployeeInsurance;
import com.emphr_hr.entity.HealthInsurance;
import com.emphr_hr.repository.HealthInsuranceRepository;
import com.emphr_hr.repository.EmployeeInsuranceRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class InsuranceController {

	@Autowired
	private EmployeeInsuranceRepository insuranceRepository;
	@Autowired
	private HealthInsuranceRepository healthRepository;

	// @PostMapping("/employee/register/insurance")
	@PostMapping("/employee/register/{id}/{employee_id}/insurance")
	public ResponseEntity<Void> createInsurance(@RequestBody EmployeeInsurance insurance,
			@PathVariable String employee_id, @PathVariable String id) {

		insurance.setEmployee_id(employee_id);
		insuranceRepository.save(insurance, id);
		System.out.println(insurance);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// @PostMapping("/employee/register/insurance")
	@PostMapping("/employee/register/{id}/{employee_id}/healthinsurance")
	public ResponseEntity<Void> createHealthInsurance(@RequestBody HealthInsurance health,
			@PathVariable String employee_id, @PathVariable String id) {

		health.setEmployee_id(employee_id);
		healthRepository.save(health, id);
        System.out.println(health);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/insurance/{employee_id}")
	public EmployeeInsurance getInsurance(@PathVariable String employee_id) {
		return insuranceRepository.findById(employee_id);

	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/healthinsurance/{employee_id}")
	public HealthInsurance gethealthInsurance(@PathVariable String employee_id) {
		return healthRepository.findById(employee_id);

	}

}
