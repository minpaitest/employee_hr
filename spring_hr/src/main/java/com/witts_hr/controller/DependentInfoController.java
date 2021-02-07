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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emphr_hr.entity.DependentInfo;
import com.emphr_hr.entity.Employee;
import com.emphr_hr.entity.Qualification;
import com.emphr_hr.repository.DependentInfoRepository;
// import com.emphr_hr.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class DependentInfoController {

  @Autowired
  private DependentInfoRepository dependentInfoRepository;
  

  @PostMapping("/employee/register/{employee_id}/dependentInfo/save")
  public ResponseEntity<Void> saveDepenedentInfo(@RequestBody DependentInfo dependentInfo,
    @PathVariable String employee_id) {
    // basicpension.setEmployee_id(123);
    dependentInfo.setEmployee_id(employee_id);
    dependentInfoRepository.save(dependentInfo);
    System.out.println("********************saveDepenedentInfo******************");
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
  
  
  @CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/employee/dependentInfo/{employee_id}")
	public List<DependentInfo> getQualification(@PathVariable String employee_id) {
		return dependentInfoRepository.findByemployeeId(employee_id);
	}
  
  
  @DeleteMapping("/dependentInfo/{dependentInfo_id}/delete")
	public ResponseEntity<Void> deleteDependentInfo(@PathVariable long dependentInfo_id) {

		dependentInfoRepository.deleteById(dependentInfo_id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
  
  
	@PostMapping("/employee/register/{employee_id}/dependentInfo/{dependentInfo_id}")
	public ResponseEntity<Void> updateDependentInfo(@RequestBody DependentInfo dependentInfo,
			@PathVariable String employee_id, @PathVariable long dependentInfo_id) {

		// basicpension.setEmployee_id(123);	
        dependentInfo.setEmployee_id(employee_id);		
		dependentInfo.setDependentInfo_id(dependentInfo_id);
		System.out.println("DependentInfoController...........................");
		dependentInfoRepository.update(dependentInfo, dependentInfo_id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/dependentInfo/{dependentInfo_id}")
	public DependentInfo getDependentInfoById(@PathVariable long dependentInfo_id) {
		return dependentInfoRepository.findBydependentInfoId(dependentInfo_id);
	}


}
