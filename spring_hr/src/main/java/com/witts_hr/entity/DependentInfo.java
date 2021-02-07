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
@Table(name = "dependentInfo")
public class DependentInfo implements Serializable{

	private static final long serialVersionUID = 1L;


	@Column(name = "employee_id")
	private String employee_id;

	@Id		
	@Column(name = "dependentInfo_id", unique = true, length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dependentInfo_id;

	@Column(name = "name", length = 15)
	private String name;

	@Column(name = "attribute", length=5)
	private String attribute;

	@Column(name = "birth_date")
	private Date birth_date;

	@Column(name = "occupation" , length =15)
	private String occupation;

	@Column(name = "living_classification", length=5)
	private String living_classification;


	@Column(name = "address", length=100)
	private String address;

	@Column(name = "phone_number", length=20)
	private String phone_number;

	@Column(name="health_insurance", length=5)
	private String health_insurance;

	public DependentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + ((birth_date == null) ? 0 : birth_date.hashCode());
		result = prime * result + (int) (dependentInfo_id ^ (dependentInfo_id >>> 32));
		result = prime * result + ((employee_id == null) ? 0 : employee_id.hashCode());
		result = prime * result + ((health_insurance == null) ? 0 : health_insurance.hashCode());
		result = prime * result + ((living_classification == null) ? 0 : living_classification.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + ((phone_number == null) ? 0 : phone_number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DependentInfo other = (DependentInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (birth_date == null) {
			if (other.birth_date != null)
				return false;
		} else if (!birth_date.equals(other.birth_date))
			return false;
		if (dependentInfo_id != other.dependentInfo_id)
			return false;
		if (employee_id == null) {
			if (other.employee_id != null)
				return false;
		} else if (!employee_id.equals(other.employee_id))
			return false;
		if (health_insurance == null) {
			if (other.health_insurance != null)
				return false;
		} else if (!health_insurance.equals(other.health_insurance))
			return false;
		if (living_classification == null) {
			if (other.living_classification != null)
				return false;
		} else if (!living_classification.equals(other.living_classification))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (phone_number == null) {
			if (other.phone_number != null)
				return false;
		} else if (!phone_number.equals(other.phone_number))
			return false;
		return true;
	}

	public long getDependentInfo_id() {
		return dependentInfo_id;
	}

	public void setDependentInfo_id(long dependentInfo_id) {
		this.dependentInfo_id = dependentInfo_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getLiving_classification() {
		return living_classification;
	}

	public void setLiving_classification(String living_classification) {
		this.living_classification = living_classification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getHealth_insurance() {
		return health_insurance;
	}

	public void setHealth_insurance(String health_insurance) {
		this.health_insurance = health_insurance;
	}

	
	


	

	


}
