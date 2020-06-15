package com.mySampleApplication.server.dao;

import com.mySampleApplication.server.model.CustomerInfo;

import java.util.List;
import java.util.Map;


public interface CustomerDao {
	public void deleteByPrimarykey(List<Integer> ids);

	public void updateByPrimaryKey(CustomerInfo customerInfo);

	CustomerInfo save(CustomerInfo customerInfo);

	List<CustomerInfo> listByCustomerInfoOr(CustomerInfo customerInfo);

	Map<String,Object> listByCustomerInfoOr(CustomerInfo customerInfo, int pageSize, int pageNum);



}
