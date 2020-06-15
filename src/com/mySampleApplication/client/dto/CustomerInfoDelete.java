package com.mySampleApplication.client.dto;

import java.io.Serializable;
import java.util.List;


public class CustomerInfoDelete  implements Serializable {
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "CustomerInfoDelete{" +
				"ids=" + ids +
				'}';
	}
}
