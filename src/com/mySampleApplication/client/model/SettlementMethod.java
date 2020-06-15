package com.mySampleApplication.client.model;


public class SettlementMethod {
	private String name;

	public SettlementMethod() {
	}

	public SettlementMethod(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SettlementMethod{" +
				"name='" + name + '\'' +
				'}';
	}
}
