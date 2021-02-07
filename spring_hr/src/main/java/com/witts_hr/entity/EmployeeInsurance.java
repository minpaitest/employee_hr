package com.emphr_hr.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_insurances")
public class EmployeeInsurance implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "employee_id", length = 11)
	private String employee_id;

	@Column(name = "employee_insurance_id", length = 13)
	private String employee_insurance_id;

	@Column(name = "acquisition_date")
	private Date acquisition_date;

	@Column(name = "expired_date")
	private Date expired_date;

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_insurance_id() {
		return employee_insurance_id;
	}

	public void setEmployee_insurance_id(String employee_insurance_id) {
		this.employee_insurance_id = employee_insurance_id;
	}

	public Date getAcquisition_date() {
		return acquisition_date;
	}

	public void setAcquisition_date(Date acquisition_date) {
		this.acquisition_date = acquisition_date;
	}

	public Date getExpired_date() {
		return expired_date;
	}

	public void setExpired_date(Date expired_date) {
		this.expired_date = expired_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmployeeInsurance [employee_id=" + employee_id + ", employee_insurance_id=" + employee_insurance_id
				+ ", acquisition_date=" + acquisition_date + ", expired_date=" + expired_date + "]";
	}

	public EmployeeInsurance(String employee_id, String employee_insurance_id, Date acquisition_date,
			Date expired_date) {
		super();
		this.employee_id = employee_id;
		this.employee_insurance_id = employee_insurance_id;
		this.acquisition_date = acquisition_date;
		this.expired_date = expired_date;
	}

	public EmployeeInsurance() {
		super();
	}

}
