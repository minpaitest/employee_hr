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

import com.emphr_hr.entity.EmergencyContact;
import com.emphr_hr.repository.EmergencyContactRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class EmergencyContactController {
	@Autowired
	private EmergencyContactRepository emergencycontactRepository;

	@PostMapping("/employee/register/contact/{employee_id}")
	public ResponseEntity<Void> createEmergencyContact(@RequestBody EmergencyContact emergencycontact,
			@PathVariable String employee_id) {

		emergencycontact.setEmployee_id(employee_id);
		emergencycontactRepository.save(emergencycontact, employee_id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/contact/{employee_id}")
	public EmergencyContact getContact(@PathVariable String employee_id) {
		return emergencycontactRepository.findById(employee_id);

	}

}
