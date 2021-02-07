package com.emphr_hr.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * @Id
	 *
	 * @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
	 */
	@Id
	@Column(name = "employee_id", unique = true, length = 11)
	private String employee_id;

	@Column(name = "employee_profile")
	private String employee_profile;

	@Column(name = "employee_name", length = 40)
	private String employee_name;

	@Column(name = "employee_furigana_name", length = 40)
	private String employee_furigana_name;

	@Column(name = "employee_english_name", length = 40)
	private String employee_english_name;

	@Column(name = "gender", length = 10)
	private String gender;

	@Column(name = "country_name")
	private String country_name;

	@Column(name = "birthdate")
	private Date birthdate;

	@Column(name = "joining_date")
	private Date joining_date;

	@Column(name = "position")
	private String position;

	@Column(name = "department", length = 10)
	private String department;

	@Column(name = "employee_status", length = 10)
	private String employee_status;

	@Column(name = "file_path")
	private String file_path;

	@Column(name = "nearest_station", length = 40)
	private String nearest_station;

	@Column(name = "japan_postal_code", length = 8)
	private String japan_postal_code;

	@Column(name = "address", length = 100)
	private String address;

	@Column(name = "phone_no", length = 11)
	private String phone_no;

	@Column(name = "mail_address", length = 30)
	private String mail_address;

	@Column(name = "landing_date")
	private Date landing_date;

	@Column(name = "status_of_residence")
	private String status_of_residence;

	@Column(name = "residence_number", length = 15)
	private String residence_number;

	@Column(name = "residenceCard_expired_date")
	private Date residenceCard_expired_date;

	@Column(name = "passport_type", length = 5)
	private String passport_type;

	@Column(name = "passport_number", length = 15)
	private String passport_number;

	@Column(name = "passport_expiredate")
	private Date passport_expiredate;

	public Employee(Long id, String employee_profile, String employee_id, String employee_name,
			String employee_furigana_name, String employee_english_name, Boolean active_status, String gender,
			String country_name, Date birthdate, Date joining_date, String position, String department,
			String employee_status, String file_path, String nearest_station, String japan_postal_code, String address,
			String phone_no, String mail_address, Date landing_date, String status_of_residence,
			String residence_number, Date residenceCard_expired_date, String passport_type, String passport_number,
			Date passport_expiredate) {
		super();
		this.employee_profile = employee_profile;
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_furigana_name = employee_furigana_name;
		this.employee_english_name = employee_english_name;
		this.gender = gender;
		this.country_name = country_name;
		this.birthdate = birthdate;
		this.joining_date = joining_date;
		this.position = position;
		this.department = department;
		this.employee_status = employee_status;
		this.file_path = file_path;
		this.nearest_station = nearest_station;
		this.japan_postal_code = japan_postal_code;
		this.address = address;
		this.phone_no = phone_no;
		this.mail_address = mail_address;
		this.landing_date = landing_date;
		this.status_of_residence = status_of_residence;
		this.residence_number = residence_number;
		this.residenceCard_expired_date = residenceCard_expired_date;
		this.passport_type = passport_type;
		this.passport_number = passport_number;
		this.passport_expiredate = passport_expiredate;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmployee_profile() {
		return employee_profile;
	}

	public void setEmployee_profile(String employee_profile) {
		this.employee_profile = employee_profile;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_furigana_name() {
		return employee_furigana_name;
	}

	public void setEmployee_furigana_name(String employee_furigana_name) {
		this.employee_furigana_name = employee_furigana_name;
	}

	public String getEmployee_english_name() {
		return employee_english_name;
	}

	public void setEmployee_english_name(String employee_english_name) {
		this.employee_english_name = employee_english_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getNearest_station() {
		return nearest_station;
	}

	public void setNearest_station(String nearest_station) {
		this.nearest_station = nearest_station;
	}

	public String getJapan_postal_code() {
		return japan_postal_code;
	}

	public void setJapan_postal_code(String japan_postal_code) {
		this.japan_postal_code = japan_postal_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	public Date getLanding_date() {
		return landing_date;
	}

	public void setLanding_date(Date landing_date) {
		this.landing_date = landing_date;
	}

	public String getStatus_of_residence() {
		return status_of_residence;
	}

	public void setStatus_of_residence(String status_of_residence) {
		this.status_of_residence = status_of_residence;
	}

	public String getResidence_number() {
		return residence_number;
	}

	public void setResidence_number(String residence_number) {
		this.residence_number = residence_number;
	}

	public Date getResidenceCard_expired_date() {
		return residenceCard_expired_date;
	}

	public void setResidenceCard_expired_date(Date residenceCard_expired_date) {
		this.residenceCard_expired_date = residenceCard_expired_date;
	}

	public String getPassport_type() {
		return passport_type;
	}

	public void setPassport_type(String passport_type) {
		this.passport_type = passport_type;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	public Date getPassport_expiredate() {
		return passport_expiredate;
	}

	public void setPassport_expiredate(Date passport_expiredate) {
		this.passport_expiredate = passport_expiredate;
	}

	@Override
	public String toString() {
		return "Employee [employee_profile=" + employee_profile + ", employee_id=" + employee_id + ", employee_name="
				+ employee_name + ", employee_furigana_name=" + employee_furigana_name + ", employee_english_name="
				+ employee_english_name + ", gender=" + gender + ", country_name=" + country_name + ", birthdate="
				+ birthdate + ", joining_date=" + joining_date + ", position=" + position + ", department=" + department
				+ ", employee_status=" + employee_status + ", file_path=" + file_path + ", nearest_station="
				+ nearest_station + ", japan_postal_code=" + japan_postal_code + ", address=" + address + ", phone_no="
				+ phone_no + ", mail_address=" + mail_address + ", landing_date=" + landing_date
				+ ", status_of_residence=" + status_of_residence + ", residence_number=" + residence_number
				+ ", residenceCard_expired_date=" + residenceCard_expired_date + ", passport_type=" + passport_type
				+ ", passport_number=" + passport_number + ", passport_expiredate=" + passport_expiredate + "]";
	}

}
