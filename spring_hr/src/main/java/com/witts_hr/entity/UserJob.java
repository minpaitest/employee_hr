package com.emphr_hr.entity;

import java.io.Serializable;
import java.util.Date;

public class UserJob implements Serializable {

	private static final long serialVersionUID = 1L;

	private String jobId;
	private String jobTitle;
	private String jobContent;
	private String departmentId;
	private Date startDate;

	public UserJob() {
		super();
	}

	public UserJob(String jobTitle, String jobContent, String departmentId, Date startDate, String jobId) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobContent = jobContent;
		this.departmentId = departmentId;
		this.startDate = startDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobContent() {
		return jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserJob [jobId=" + jobId + ", jobTitle=" + jobTitle + ", jobContent=" + jobContent + ", departmentId="
				+ departmentId + ", startDate=" + startDate + "]";
	}
}
