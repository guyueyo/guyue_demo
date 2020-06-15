package com.mySampleApplication.server.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name = "customer_info")
public class CustomerInfo implements Serializable {
	public CustomerInfo() {

	}

	public CustomerInfo(Integer id, String phone, String address, String customerCode, String customerName, String mnemonicCode, String customerType, String fax, String email, Boolean enableTag, String company, Date birth, String postCode, String bankAcount, String bank, String settlementMethod, Date settlementDate, String monthlyDate, String remark) {
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.mnemonicCode = mnemonicCode;
		this.customerType = customerType;
		this.fax = fax;
		this.email = email;
		this.enableTag = enableTag;
		this.company = company;
		this.birth = birth;
		this.postCode = postCode;
		this.bankAcount = bankAcount;
		this.bank = bank;
		this.settlementMethod = settlementMethod;
		this.settlementDate = settlementDate;
		this.monthlyDate = monthlyDate;
		this.remark = remark;
	}

	private Integer id;
	private String phone;
	private String address;
	private String customerCode;
	private String customerName;
	private String mnemonicCode;
	private String customerType;
	private String fax;
	private String email;
	private Boolean enableTag;
	private String company;
	private Date birth;
	private String postCode;
	private String bankAcount;
	private String bank;
	private String settlementMethod;
	private Date settlementDate;
	private String monthlyDate;
	private String remark;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirth() {
		return birth;
	}

	@Column(name = "birth", nullable = true)
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	@Column(name = "phone", nullable = false, length = 15)
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	@Column(name = "address", nullable = false, length = 255)
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	@Column(name = "customer_code", nullable = false, length = 20)
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	@Column(name = "customer_name", nullable = false, length = 255)
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMnemonicCode() {
		return mnemonicCode;
	}

	@Column(name = "mnemonic_code", nullable = false, length = 20)
	public void setMnemonicCode(String mnemonicCode) {
		this.mnemonicCode = mnemonicCode;
	}

	public String getCustomerType() {
		return customerType;
	}

	@Column(name = "customer_type", nullable = false, length = 50)
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getFax() {
		return fax;
	}

	@Column(name = "fax", nullable = true, length = 20)
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	@Column(name = "email", nullable = true, length = 30)
	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnableTag() {
		return enableTag;
	}

	@Column(name = "is_enable_tag", nullable = false, columnDefinition = "BOOLEAN")
	public void setEnableTag(Boolean enableTag) {
		this.enableTag = enableTag;
	}

	public String getCompany() {
		return company;
	}

	@Column(name = "company", nullable = false, length = 255)
	public void setCompany(String company) {
		this.company = company;
	}

	public String getPostCode() {
		return postCode;
	}

	@Column(name = "post_code", nullable = true, length = 6)
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getBankAcount() {
		return bankAcount;
	}

	@Column(name = "bank_acount", nullable = false, length = 40)
	public void setBankAcount(String bankAcount) {
		this.bankAcount = bankAcount;
	}

	public String getBank() {
		return bank;
	}

	@Column(name = "bank", nullable = false, length = 50)
	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getSettlementMethod() {
		return settlementMethod;
	}

	@Column(name = "settlement_method", nullable = false, length = 50)
	public void setSettlementMethod(String settlementMethod) {
		this.settlementMethod = settlementMethod;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	@Column(name = "settlement_date", nullable = true)
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getMonthlyDate() {
		return monthlyDate;
	}

	@Column(name = "monthly_date", nullable = true, length = 2)
	public void setMonthlyDate(String monthlyDate) {
		this.monthlyDate = monthlyDate;
	}

	public String getRemark() {
		return remark;
	}

	@Column(name = "remark", nullable = true, length = 255)
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CustomerInfo{" +
				"id=" + id +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", customerCode='" + customerCode + '\'' +
				", customerName='" + customerName + '\'' +
				", mnemonicCode='" + mnemonicCode + '\'' +
				", customerType='" + customerType + '\'' +
				", fax='" + fax + '\'' +
				", email='" + email + '\'' +
				", enableTag=" + enableTag +
				", company='" + company + '\'' +
				", birth=" + birth +
				", postCode='" + postCode + '\'' +
				", bankAcount='" + bankAcount + '\'' +
				", bank='" + bank + '\'' +
				", settlementMethod='" + settlementMethod + '\'' +
				", settlementDate=" + settlementDate +
				", monthlyDate=" + monthlyDate +
				", remark='" + remark + '\'' +
				'}';
	}
}
