package com.emphr_hr.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "job_histories")
@SequenceGenerator(name="JOBHIS_SEQ_GEN", sequenceName="JOBHIS_SEQ_TEMPID", initialValue=1, allocationSize=1)
public class JobHistories implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "temp_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOBHIS_SEQ_GEN")
    private long tempId; // No identifier specified for entity 防止

	@Column(name = "employee_id")
	@Size(min = 1, max = 11)
	private String employeeId; // 社員番号（社員情報）

	@Column(name = "job_id")
	@Size(max = 10)
	private String job_id; // ジョブID

	@Column(name = "start_date")
	private Date startDate; // 開始日

	@Column(name = "end_date")
	private Date endDate; // 最終日

	@Column(name = "department_id")
	@Size(max = 10)
	private String departmentId; // 所属ID

	public JobHistories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobHistories(long tempId, @Size(min = 1, max = 11) String employeeId, @Size(max = 10) String job_id,
			Date startDate, Date endDate, @Size(max = 10) String departmentId) {
		super();
		this.tempId = tempId;
		this.employeeId = employeeId;
		this.job_id = job_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.departmentId = departmentId;
	}

	public long getTempId() {
		return tempId;
	}

	public void setTempId(long tempId) {
		this.tempId = tempId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getJobId() {
		return job_id;
	}

	public void setJobId(String job_id) {
		this.job_id = job_id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JobHistories [tempId=" + tempId + ", employeeId=" + employeeId + ", job_id=" + job_id + ", startDate="
				+ startDate + ", endDate=" + endDate + ", departmentId=" + departmentId + "]";
	}
}