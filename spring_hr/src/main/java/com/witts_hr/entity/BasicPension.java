package com.emphr_hr.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "basicpensions")
public class BasicPension implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "employee_id", length = 11)
	private String employee_id;

	@Column(name = "basic_pension_id", length = 11)
	private String basic_pension_id;

	@Column(name = "acquisition_date")
	private Date acquisition_date;

	@Column(name = "expired_date")
	private Date expired_date;

	public BasicPension(String employee_id, String basic_pension_id, Date acquisition_date, Date expired_date) {
		super();
		this.employee_id = employee_id;
		this.basic_pension_id = basic_pension_id;
		this.acquisition_date = acquisition_date;
		this.expired_date = expired_date;
	}

	public BasicPension() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getBasic_pension_id() {
		return basic_pension_id;
	}

	public void setBasic_pension_id(String basic_pension_id) {
		this.basic_pension_id = basic_pension_id;
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

	@Override
	public String toString() {
		return "BasicPension [employee_id=" + employee_id + ", basic_pension_id=" + basic_pension_id
				+ ", acquisition_date=" + acquisition_date + ", expired_date=" + expired_date + "]";
	}

}
