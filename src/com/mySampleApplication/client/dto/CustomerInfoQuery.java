package com.mySampleApplication.client.dto;

import java.io.Serializable;


public class CustomerInfoQuery implements Serializable {
	private String customerCode;
	private String customerName;
	private String mnemonicCode;

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

	@Override
	public String toString() {
		return "CustomerInfoQuery{" +
				"customerCode='" + customerCode + '\'' +
				", customerName='" + customerName + '\'' +
				", mnemonicCode='" + mnemonicCode + '\'' +
				'}';
	}
}
