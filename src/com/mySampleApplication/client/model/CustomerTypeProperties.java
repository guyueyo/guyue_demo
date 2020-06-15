package com.mySampleApplication.client.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface CustomerTypeProperties extends PropertyAccess<CustomerType> {

	@Editor.Path("name")
	ModelKeyProvider<CustomerType> key();
	@Editor.Path("name")
	LabelProvider<CustomerType> nameLabel();
	ValueProvider<CustomerType, String> name();
}
