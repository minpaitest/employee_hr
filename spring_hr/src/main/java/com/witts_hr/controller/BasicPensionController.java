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

import com.emphr_hr.entity.BasicPension;
import com.emphr_hr.repository.BasicPensionRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class BasicPensionController {
	@Autowired
	private BasicPensionRepository basicpensionRepository;

	// @PostMapping("/employee/register/pension")
	@PostMapping("/employee/register/{id}/{employee_id}/pension")
	public ResponseEntity<Void> createBasicPension(@RequestBody BasicPension basicpension,
			@PathVariable String employee_id, @PathVariable String id) {

		// basicpension.setEmployee_id(123);
		basicpension.setEmployee_id(employee_id);
		System.out.println(employee_id);
		basicpensionRepository.save(basicpension, id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/pension/{employee_id}")
	public BasicPension getPension(@PathVariable String employee_id) {
		return basicpensionRepository.findById(employee_id);

	}

}
