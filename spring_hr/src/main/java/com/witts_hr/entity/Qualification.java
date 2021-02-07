package com.emphr_hr.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qualtifications")
public class Qualification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "employee_id")
	private String employee_id;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "qualification_id")
	private long qualification_id;

	@Column(name = "qualification_name")
	private String qualification_name;

	@Column(name = "qualification_acquisition_date")
	private Date qualification_acquisition_date;

	@Column(name = "qualification_expiered_date")
	private Date qualification_expiered_date;

	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Qualification(String employee_id, long qualification_id, String qualification_name,
			Date qualification_acquisition_date, Date qualification_expiered_date) {
		super();
		this.employee_id = employee_id;
		this.qualification_id = qualification_id;
		this.qualification_name = qualification_name;
		this.qualification_acquisition_date = qualification_acquisition_date;
		this.qualification_expiered_date = qualification_expiered_date;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public long getQualification_id() {
		return qualification_id;
	}

	public void setQualification_id(long qualification_id) {
		this.qualification_id = qualification_id;
	}

	public String getQualification_name() {
		return qualification_name;
	}

	public void setQualification_name(String qualification_name) {
		this.qualification_name = qualification_name;
	}

	public Date getQualification_acquisition_date() {
		return qualification_acquisition_date;
	}

	public void setQualification_acquisition_date(Date qualification_acquisition_date) {
		this.qualification_acquisition_date = qualification_acquisition_date;
	}

	public Date getQualification_expiered_date() {
		return qualification_expiered_date;
	}

	public void setQualification_expiered_date(Date qualification_expiered_date) {
		this.qualification_expiered_date = qualification_expiered_date;
	}

	@Override
	public String toString() {
		return "Qualification [employee_id=" + employee_id + ", qualification_id=" + qualification_id
				+ ", qualification_name=" + qualification_name + ", qualification_acquisition_date="
				+ qualification_acquisition_date + ", qualification_expiered_date=" + qualification_expiered_date + "]";
	}

}
