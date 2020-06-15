package com.mySampleApplication.client.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * message customer删除方法封装类
 * creatBy guyue
 * creatTime 2020/6
 */

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
