package com.mySampleApplication.server.dao;

import com.mySampleApplication.client.dto.CustomerInfoQuery;
import com.mySampleApplication.server.model.CustomerInfo;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;

import java.util.List;
import java.util.Map;


public interface CustomerDao {
	public void deleteByPrimarykey(List<Integer> ids);

	public void updateByPrimaryKey(CustomerInfo customerInfo);

	CustomerInfo save(CustomerInfo customerInfo);

	List<CustomerInfo> listByCustomerInfoOr(CustomerInfo customerInfo);

	Map<String,Object> listByCustomerInfoOr(CustomerInfo customerInfo, int pageSize, int pageNum);

	List<CustomerInfo> listByCustomerInfo(CustomerInfo customerInfo, PagingLoadConfig pagingLoadConfig);

	int countListByCustomer(CustomerInfo customerInfo);
}
