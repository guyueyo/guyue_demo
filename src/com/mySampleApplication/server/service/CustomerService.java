package com.mySampleApplication.server.service;

import com.mySampleApplication.client.dto.*;
import com.mySampleApplication.client.model.CustomerInfo;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import java.util.List;


public interface CustomerService {
	String deleteCustomerInfo(CustomerInfoDelete request);

	String updateCustomerInfo(CustomerInfoUpdate customerInfo);

	CustomerInfoSaveDTO saveCustomerInfo(CustomerInfoSave request);

	List<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery);

	PageInfoDTO<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery,PageInfoDTO<CustomerInfoQueryDTO> pageInfoDTO);

	PagingLoadResult<CustomerInfo> listCustomerInfoLimit(CustomerInfoQuery customerInfoQuery,PagingLoadConfig pagingLoadConfig);

	PagingLoadResult<com.mySampleApplication.client.model.CustomerInfo> listCustomerInfo(int offset,int limit);

//	PageInfoDTO<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery, PageInfo<CustomerInfoQueryDTO> pageInfo);
}
