
package com.emphr_hr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jobs")
@SequenceGenerator(name="JOBS_SEQ_GEN", sequenceName="JOBS_SEQ_TEMPID", initialValue=1, allocationSize=1)
public class Jobs implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "temp_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "JOBS_SEQ_GEN")
    private long jobsTempId; // Hibernate エラー防止キー

	@Column(name = "job_id")
	@Size(min = 1, max = 10)
	private String jobId; // ジョブID（ジョブ履歴）

	@Column(name = "job_title")
	@Size(max = 15)
	private String jobTitle; // ジョブタイトル

	@Column(name = "job_technology")
	@Size(max = 50)
	private String jobTechnology; // 使用技術

	@Column(name = "job_content")
	@Size(max = 30)
	private String jobContent; // ジョブ内容

	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jobs(long jobsTempId, @Size(min = 1, max = 10) String jobId, @Size(max = 15) String jobTitle,
			@Size(max = 50) String jobTechnology, @Size(max = 30) String jobContent) {
		super();
		this.jobsTempId = jobsTempId;
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobTechnology = jobTechnology;
		this.jobContent = jobContent;
	}

	public long getJobsTempId() {
		return jobsTempId;
	}

	public void setJobsTempId(long jobsTempId) {
		this.jobsTempId = jobsTempId;
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

	public String getJobTechnology() {
		return jobTechnology;
	}

	public void setJobTechnology(String jobTechnology) {
		this.jobTechnology = jobTechnology;
	}

	public String getJobContent() {
		return jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Jobs [jobsTempId=" + jobsTempId + ", jobId=" + jobId + ", jobTitle=" + jobTitle + ", jobTechnology="
				+ jobTechnology + ", jobContent=" + jobContent + "]";
	}
}

