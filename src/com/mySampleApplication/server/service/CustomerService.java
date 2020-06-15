package com.mySampleApplication.server.service;

import com.mySampleApplication.client.dto.*;

import java.util.List;


public interface CustomerService {
	String deleteCustomerInfo(CustomerInfoDelete request);

	String updateCustomerInfo(CustomerInfoUpdate customerInfo);

	CustomerInfoSaveDTO saveCustomerInfo(CustomerInfoSave request);

	List<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery);

	PageInfoDTO<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery,PageInfoDTO<CustomerInfoQueryDTO> pageInfoDTO);



//	PageInfoDTO<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery, PageInfo<CustomerInfoQueryDTO> pageInfo);
}
