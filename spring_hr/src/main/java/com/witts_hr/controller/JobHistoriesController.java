package com.emphr_hr.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.emphr_hr.entity.JobHistories;
import com.emphr_hr.entity.JobInfo;
import com.emphr_hr.entity.Jobs;
import com.emphr_hr.entity.Qualification;
import com.emphr_hr.entity.UserJob;
import com.emphr_hr.repository.JobHistoriesRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class JobHistoriesController {
	
	@Autowired
	private JobHistoriesRepository jobHistoryRepository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/employee/jobs/{employee_id}")
	public List<UserJob> getJobHistoriesList(@PathVariable String employee_id) {
		return jobHistoryRepository.getJobHistoriesList(employee_id);
	}

	@PostMapping("/employee/jobs/{employee_id}/insert")
	public ResponseEntity<Void> insertJobInfo(
			@RequestBody Object jobInfoObj,
			@PathVariable String employee_id) {

		ObjectMapper objMapper = new ObjectMapper();
		HashMap<Object, Object> jobInfoMap = objMapper.convertValue(jobInfoObj, HashMap.class);

		Jobs jobs = new Jobs();
		JobHistories jobHistories = new JobHistories();

		if(jobHistoryRepository.getJobHistoriesList(employee_id).isEmpty()) {
			int latestJobId = jobHistoryRepository.getLatestJobId();
			if(latestJobId == -1) {
				jobInfoMap.put("job_id", 0);
			} else {
				latestJobId += 1;
				jobInfoMap.put("job_id", latestJobId);
			}
		}

		/*
		if(StringUtils.isEmpty(jobInfoMap.get("job_id").toString())) {
			jobInfoMap.put("job_id", 0);
		}
		*/

		jobs.setJobId(String.valueOf(Integer.valueOf(jobInfoMap.get("job_id").toString())+1));
		jobs.setJobTitle(jobInfoMap.get("job_title").toString());
		jobHistories.setJobId(String.valueOf(Integer.valueOf(jobInfoMap.get("job_id").toString())+1));
		jobHistories.setStartDate(Date.valueOf(jobInfoMap.get("job_histories_start_date").toString()));

		if(!StringUtils.isEmpty(jobInfoMap.get("job_technology").toString()))
			jobs.setJobTechnology(jobInfoMap.get("job_technology").toString());
		if(!StringUtils.isEmpty(jobInfoMap.get("job_content").toString()))
			jobs.setJobContent(jobInfoMap.get("job_content").toString());
		if(!StringUtils.isEmpty(jobInfoMap.get("employee_id").toString().isEmpty()))
			jobHistories.setEmployeeId(jobInfoMap.get("employee_id").toString());
		if(!StringUtils.isEmpty(jobInfoMap.get("department_name").toString().isEmpty()))
			jobHistories.setDepartmentId(jobInfoMap.get("department_name").toString());
		if(!StringUtils.isEmpty(jobInfoMap.get("job_histories_expiered_date").toString().isEmpty()))
			jobHistories.setEndDate(Date.valueOf(jobInfoMap.get("job_histories_expiered_date").toString()));

		jobHistoryRepository.insertJobInfo(jobs, jobHistories);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/employee/jobs/{job_id}/delete")
	public ResponseEntity<Void> deleteJobInfo(@PathVariable String job_id) {

		jobHistoryRepository.deleteJobInfo(job_id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/employee/jobs/{job_id}/beforeUpdate")
	public JobInfo findJobInfoByJobId(@PathVariable String job_id) {

		return jobHistoryRepository.findJobInfoByJobId(job_id);
	}

	@PostMapping("/employee/jobs/{employee_id}/update")
	public ResponseEntity<Void> updateJobInfo(
			@RequestBody Object jobInfoObj,
			@PathVariable String employee_id) {

		ObjectMapper objMapper = new ObjectMapper();
		HashMap<Object, Object> jobInfoMap = objMapper.convertValue(jobInfoObj, HashMap.class);

		Jobs jobs = new Jobs();
		JobHistories jobHistories = new JobHistories();

		jobs.setJobsTempId(Long.valueOf(jobInfoMap.get("temp_id").toString()));
		jobs.setJobId(jobInfoMap.get("job_id").toString());
		jobs.setJobTitle(jobInfoMap.get("job_title").toString());
		jobHistories.setTempId(Long.valueOf(jobInfoMap.get("temp_id").toString()));
		jobHistories.setJobId(jobInfoMap.get("job_id").toString());
		jobHistories.setStartDate(Date.valueOf(jobInfoMap.get("job_histories_start_date").toString()));

		if(!StringUtils.isEmpty(jobInfoMap.get("job_technology").toString().isEmpty()))
			jobs.setJobTechnology(jobInfoMap.get("job_technology").toString());
		if(!StringUtils.isEmpty(jobInfoMap.get("job_content").toString().isEmpty()))
			jobs.setJobContent(jobInfoMap.get("job_content").toString());
		if(!StringUtils.isEmpty(employee_id))
			jobHistories.setEmployeeId(employee_id);
		if(!StringUtils.isEmpty(jobInfoMap.get("department_name").toString().isEmpty()))
			jobHistories.setDepartmentId(jobInfoMap.get("department_name").toString());
		if(!StringUtils.isEmpty(jobInfoMap.get("job_histories_expiered_date").toString().isEmpty()))
			jobHistories.setEndDate(Date.valueOf(jobInfoMap.get("job_histories_expiered_date").toString()));

		jobHistoryRepository.updateJobInfo(jobs, jobHistories);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
