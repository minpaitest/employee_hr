package com.emphr_hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account_info")
public class BankAccountInfo {
	@Id
	@Column(name = "employee_id", length = 11)
	private String employee_id;
	
	@Column(name = "bank_acc_financial_institution_code", length = 4)
	private String bank_acc_financial_institution_code;
	
	@Column(name = "bank_branch_name", length = 5)
	private String bank_branch_name;
	
	@Column(name = "bank_account_type", length = 4)
	private String bank_account_type;
	
	@Column(name = "bank_account_number", length = 7)
	private String bank_account_number;
	
	@Column(name = "name_in_bank_account_shimei", length = 40)
	private String name_in_bank_account_shimei;
	
	@Column(name = "name_in_bank_account_katakana", length = 40)
	private String name_in_bank_account_katakana;
	
	@Column(name = "default_account")
	private Boolean default_account;

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getBank_acc_financial_institution_code() {
		return bank_acc_financial_institution_code;
	}

	public void setBank_acc_financial_institution_code(String bank_acc_financial_institution_code) {
		this.bank_acc_financial_institution_code = bank_acc_financial_institution_code;
	}

	public String getBank_branch_name() {
		return bank_branch_name;
	}

	public void setBank_branch_name(String bank_branch_name) {
		this.bank_branch_name = bank_branch_name;
	}

	public String getBank_account_type() {
		return bank_account_type;
	}

	public void setBank_account_type(String bank_account_type) {
		this.bank_account_type = bank_account_type;
	}

	public String getBank_account_number() {
		return bank_account_number;
	}

	public void setBank_account_number(String bank_account_number) {
		this.bank_account_number = bank_account_number;
	}

	public String getName_in_bank_account_shimei() {
		return name_in_bank_account_shimei;
	}

	public void setName_in_bank_account_shimei(String name_in_bank_account_shimei) {
		this.name_in_bank_account_shimei = name_in_bank_account_shimei;
	}

	public String getName_in_bank_account_katakana() {
		return name_in_bank_account_katakana;
	}

	public void setName_in_bank_account_katakana(String name_in_bank_account_katakana) {
		this.name_in_bank_account_katakana = name_in_bank_account_katakana;
	}

	public Boolean getDefault_account() {
		return default_account;
	}

	public void setDefault_account(Boolean default_account) {
		this.default_account = default_account;
	}

	@Override
	public String toString() {
		return "BankAccountInfo [employee_id=" + employee_id + ", bank_acc_financial_institution_code="
				+ bank_acc_financial_institution_code + ", bank_branch_name=" + bank_branch_name
				+ ", bank_account_type=" + bank_account_type + ", bank_account_number=" + bank_account_number
				+ ", name_in_bank_account_shimei=" + name_in_bank_account_shimei + ", name_in_bank_account_katakana="
				+ name_in_bank_account_katakana + ", default_account=" + default_account + "]";
	}

	public BankAccountInfo(String employee_id, String bank_acc_financial_institution_code, String bank_branch_name,
			String bank_account_type, String bank_account_number, String name_in_bank_account_shimei,
			String name_in_bank_account_katakana, Boolean default_account) {
		super();
		this.employee_id = employee_id;
		this.bank_acc_financial_institution_code = bank_acc_financial_institution_code;
		this.bank_branch_name = bank_branch_name;
		this.bank_account_type = bank_account_type;
		this.bank_account_number = bank_account_number;
		this.name_in_bank_account_shimei = name_in_bank_account_shimei;
		this.name_in_bank_account_katakana = name_in_bank_account_katakana;
		this.default_account = default_account;
	}

	public BankAccountInfo() {
		super();
	}
	
}