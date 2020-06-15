package com.mySampleApplication.client.dto;

import java.io.Serializable;
import java.util.Date;


public class CustomerInfoUpdate implements Serializable {
	private Integer id;// 主键id
	private String customerCode;// 客户代码
	private String customerName;// 客户名称
	private String mnemonicCode;// 助记码
	private String customerType;// 客户类型
	private String phone;// 电话
	private String fax;// 传真
	private String email;// 邮箱
	private String address;// 联系地址
	private Boolean enableTag;// 启用标记
	private String company;// 工作单位
	private Date birth;// 出生日期
	private String postCode;// 邮编
	private String bankAcount;// 银行账号
	private String bank;// 银行
	private String settlementMethod;// 结算方式
	private Date settlementDate;// 结账日期
	private String monthlyDate;// 月结日期
	private String remark;// 备注

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMnemonicCode() {
		return mnemonicCode;
	}

	public void setMnemonicCode(String mnemonicCode) {
		this.mnemonicCode = mnemonicCode;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getEnableTag() {
		return enableTag;
	}

	public void setEnableTag(Boolean enableTag) {
		this.enableTag = enableTag;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getBankAcount() {
		return bankAcount;
	}

	public void setBankAcount(String bankAcount) {
		this.bankAcount = bankAcount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getSettlementMethod() {
		return settlementMethod;
	}

	public void setSettlementMethod(String settlementMethod) {
		this.settlementMethod = settlementMethod;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getMonthlyDate() {
		return monthlyDate;
	}

	public void setMonthlyDate(String monthlyDate) {
		this.monthlyDate = monthlyDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CustomerInfoUpdate{" +
				"id=" + id +
				", customerCode='" + customerCode + '\'' +
				", customerName='" + customerName + '\'' +
				", mnemonicCode='" + mnemonicCode + '\'' +
				", customerType='" + customerType + '\'' +
				", phone='" + phone + '\'' +
				", fax='" + fax + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", enableTag=" + enableTag +
				", company='" + company + '\'' +
				", birth=" + birth +
				", postCode='" + postCode + '\'' +
				", bankAcount='" + bankAcount + '\'' +
				", bank='" + bank + '\'' +
				", settlementMethod='" + settlementMethod + '\'' +
				", settlementDate=" + settlementDate +
				", monthlyDate='" + monthlyDate + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
