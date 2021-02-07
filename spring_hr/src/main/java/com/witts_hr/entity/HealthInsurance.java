package com.emphr_hr.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "health_insurance")
public class HealthInsurance implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "employee_id", length = 11)
	private String employee_id;

	@Column(name = "health_insurance_id", length = 8)
	private String health_insurance_id;

	@Column(name = "health_acquisition_date")
	private Date health_acquisition_date;

	@Column(name = "health_expired_date")
	private Date health_expired_date;

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getHealth_insurance_id() {
		return health_insurance_id;
	}

	public void setHealth_insurance_id(String health_insurance_id) {
		this.health_insurance_id = health_insurance_id;
	}

	public Date getHealth_acquisition_date() {
		return health_acquisition_date;
	}

	public void setHealth_acquisition_date(Date health_acquisition_date) {
		this.health_acquisition_date = health_acquisition_date;
	}

	public Date getHealth_expired_date() {
		return health_expired_date;
	}

	public void setHealth_expired_date(Date health_expired_date) {
		this.health_expired_date = health_expired_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "HealthInsurance [employee_id=" + employee_id + ", health_insurance_id=" + health_insurance_id
				+ ", health_acquisition_date=" + health_acquisition_date + ", health_expired_date="
				+ health_expired_date + "]";
	}

	public HealthInsurance(String employee_id, String health_insurance_id, Date health_acquisition_date,
			Date health_expired_date) {
		super();
		this.employee_id = employee_id;
		this.health_insurance_id = health_insurance_id;
		this.health_acquisition_date = health_acquisition_date;
		this.health_expired_date = health_expired_date;
	}

	public HealthInsurance() {
		super();
	}
	
}
