package com.emphr_hr.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmergencyContact implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "employee_id", length = 11)
	private String employee_id;

	@Column(name = "emergency_contact_name_01", length = 40)
	private String emergency_contact_name_01;

	@Column(name = "emergency_contact_address_01", length = 100)
	private String emergency_contact_address_01;
	
	@Column(name = "emergency_contact_phoneno_01", length = 20)
	private String emergency_contact_phoneno_01;
	
	@Column(name = "emergency_contact_name_02", length = 40)
	private String emergency_contact_name_02;

	@Column(name = "emergency_contact_address_02", length = 100)
	private String emergency_contact_address_02;
	
	@Column(name = "emergency_contact_phoneno_02", length = 20)
	private String emergency_contact_phoneno_02;

	public EmergencyContact(String employee_id, String emergency_contact_name_01, String emergency_contact_address_01, String emergency_contact_phoneno_01,
			                String emergency_contact_name_02, String emergency_contact_address_02, String emergency_contact_phoneno_02) {
		super();
		this.employee_id = employee_id;
		this.emergency_contact_name_01 = emergency_contact_name_01;
		this.emergency_contact_address_01 = emergency_contact_address_01;
		this.emergency_contact_phoneno_01 = emergency_contact_phoneno_01;
		this.emergency_contact_name_02 = emergency_contact_name_02;
		this.emergency_contact_address_02 = emergency_contact_address_02;
		this.emergency_contact_phoneno_02 = emergency_contact_phoneno_02;
	}

	public EmergencyContact() {
		super();
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id2) {
		this.employee_id = employee_id2;
	}

	public String getEmergency_contact_name_01() {
		return emergency_contact_name_01;
	}

	public void setEmergency_contact_name_01(String emergency_contact_name_01) {
		this.emergency_contact_name_01 = emergency_contact_name_01;
	}
	
	public String getEmergency_contact_address_01() {
		return emergency_contact_address_01;
	}

	public void setEmergency_contact_address_01(String emergency_contact_address_01) {
		this.emergency_contact_address_01 = emergency_contact_address_01;
	}
	
	public String getEmergency_contact_phoneno_01() {
		return emergency_contact_phoneno_01;
	}

	public void setEmergency_contact_phoneno_01(String emergency_contact_phoneno_01) {
		this.emergency_contact_phoneno_01 = emergency_contact_phoneno_01;
	}
	
	public String getEmergency_contact_name_02() {
		return emergency_contact_name_02;
	}

	public void setEmergency_contact_name_02(String emergency_contact_name_02) {
		this.emergency_contact_name_02 = emergency_contact_name_02;
	}
	
	public String getEmergency_contact_address_02() {
		return emergency_contact_address_02;
	}

	public void setEmergency_contact_address_02(String emergency_contact_address_02) {
		this.emergency_contact_address_02 = emergency_contact_address_02;
	}
	
	public String getEmergency_contact_phoneno_02() {
		return emergency_contact_phoneno_02;
	}

	public void setEmergency_contact_phoneno_02(String emergency_contact_phoneno_02) {
		this.emergency_contact_phoneno_02 = emergency_contact_phoneno_02;
	}

	@Override
	public String toString() {
		return "EmergencyContact [employee_id=" + employee_id + ", emergency_contact_name_01=" + emergency_contact_name_01
				+ ", emergency_contact_address_01=" + emergency_contact_address_01 + ", emergency_contact_phoneno_01=" + emergency_contact_phoneno_01
				+ ", emergency_contact_name_02=" + emergency_contact_name_02+", emergency_contact_address_02=" + emergency_contact_address_02 + ", "
				+ "emergency_contact_phoneno_02=" + emergency_contact_phoneno_02+"]";
	}

}