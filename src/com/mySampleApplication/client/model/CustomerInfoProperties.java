package com.mySampleApplication.client.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;


public interface CustomerInfoProperties extends PropertyAccess<CustomerInfo> {

	@Editor.Path("id")
	ModelKeyProvider<CustomerInfo> key();
	ValueProvider<CustomerInfo, Integer> id();
	ValueProvider<CustomerInfo, String> customerCode();
	ValueProvider<CustomerInfo, String> customerName();
	ValueProvider<CustomerInfo, String> mnemonicCode();
	ValueProvider<CustomerInfo, String> customerType();
	ValueProvider<CustomerInfo, String> phone();
	ValueProvider<CustomerInfo, String> fax();
	ValueProvider<CustomerInfo, String> email();
	ValueProvider<CustomerInfo, Boolean> enableTag();
}
