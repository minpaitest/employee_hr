package com.emphr_hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emphr_hr.entity.Qualification;
import com.emphr_hr.repository.QualificationRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class QulificationController {
	@Autowired
	private QualificationRepository qualificationRepository;

	@PostMapping("/employee/register/{employee_id}/qualification")
	public ResponseEntity<Void> createQualification(@RequestBody Qualification qualification,
			@PathVariable String employee_id) {

		// basicpension.setEmployee_id(123);
		qualification.setEmployee_id(employee_id);
		qualificationRepository.save(qualification);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/employee/register/{employee_id}/qualification/{qualification_id}")
	public ResponseEntity<Void> updateQualification(@RequestBody Qualification qualification,
			@PathVariable String employee_id, @PathVariable long qualification_id) {

		// basicpension.setEmployee_id(123);
		qualification.setEmployee_id(employee_id);
		qualification.setQualification_id(qualification_id);
		qualificationRepository.update(qualification, qualification_id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/employee/qualification/{employee_id}")
	public List<Qualification> getQualification(@PathVariable String employee_id) {
		return qualificationRepository.findByemployeeId(employee_id);
	}

	@DeleteMapping("/qualification/{qualification_id}/delete")
	public ResponseEntity<Void> deleteQualification(@PathVariable long qualification_id) {

		qualificationRepository.deleteById(qualification_id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/qualification/{qualification_id}")
	public Qualification getQualificationById(@PathVariable long qualification_id) {
		return qualificationRepository.findByqualificationId(qualification_id);
	}

}
