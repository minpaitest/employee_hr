package com.emphr_hr.entity;

import java.io.Serializable;
import java.sql.Date;

public class JobInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long temp_id;
	private String employee_id;
	private String job_id;
	private String job_title;
	private String job_content;
	private String job_technology;
	private String department_name;
	private Date job_histories_start_date;
	private Date job_histories_expiered_date;

	public JobInfo() {
		// TODO Auto-generated constructor stub
		super();
	}

	public JobInfo(long temp_id, String employee_id, String job_id, String job_title, String job_content,
			String job_technology, String department_name, Date job_histories_start_date,
			Date job_histories_expiered_date) {
		super();
		this.temp_id = temp_id;
		this.employee_id = employee_id;
		this.job_id = job_id;
		this.job_title = job_title;
		this.job_content = job_content;
		this.job_technology = job_technology;
		this.department_name = department_name;
		this.job_histories_start_date = job_histories_start_date;
		this.job_histories_expiered_date = job_histories_expiered_date;
	}

	public String getEmployeeId() {
		return employee_id;
	}

	public void setEmployeeId(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getJobId() {
		return job_id;
	}

	public void setJobId(String job_id) {
		this.job_id = job_id;
	}

	public String getJobTitle() {
		return job_title;
	}

	public void setJobTitle(String job_title) {
		this.job_title = job_title;
	}

	public String getJobContent() {
		return job_content;
	}

	public void setJobContent(String job_content) {
		this.job_content = job_content;
	}

	public String getJobTechnology() {
		return job_technology;
	}

	public void setJobTechnology(String job_technology) {
		this.job_technology = job_technology;
	}

	public String getDepartmentName() {
		return department_name;
	}

	public void setDepartmentName(String department_name) {
		this.department_name = department_name;
	}

	public Date getJobHistoriesStartDate() {
		return job_histories_start_date;
	}

	public void setJobHistoriesStartDate(Date job_histories_start_date) {
		this.job_histories_start_date = job_histories_start_date;
	}

	public Date getJobHistoriesExpieredDate() {
		return job_histories_expiered_date;
	}

	public void setJobHistoriesExpieredDate(Date job_histories_expiered_date) {
		this.job_histories_expiered_date = job_histories_expiered_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getTempId() {
		return temp_id;
	}

	public void setTempId(long temp_id) {
		this.temp_id = temp_id;
	}

	@Override
	public String toString() {
		return "JobInfo [temp_id=" + temp_id + ", employee_id=" + employee_id + ", job_id=" + job_id + ", job_title="
				+ job_title + ", job_content=" + job_content + ", job_technology=" + job_technology
				+ ", department_name=" + department_name + ", job_histories_start_date=" + job_histories_start_date
				+ ", job_histories_expiered_date=" + job_histories_expiered_date + "]";
	}
}
