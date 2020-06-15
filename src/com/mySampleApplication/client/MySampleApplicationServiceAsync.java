package com.mySampleApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mySampleApplication.client.dto.*;

import java.util.List;

public interface MySampleApplicationServiceAsync {
	void deleteCustomerInfo(CustomerInfoDelete request, AsyncCallback<String> async);

	void updateCustomerInfo(CustomerInfoUpdate request, AsyncCallback<String> async);

	void listCustomerInfo(CustomerInfoQuery request, AsyncCallback<List<CustomerInfoQueryDTO>> async);

	void saveCustomerInfo(CustomerInfoSave request, AsyncCallback<CustomerInfoSaveDTO> async);

	void listCustomerInfo(CustomerInfoQuery customerInfoQuery, PageInfoDTO<CustomerInfoQueryDTO> pageInfo, AsyncCallback<PageInfoDTO<CustomerInfoQueryDTO>> async);

    void readSystemAdminInfo(SystemAdminInfoQuery systemAdminInfoQuery, AsyncCallback<SystemAdminInfoQueryDTO> async);

    void saveSystemAdminInfo(SystemAdminInfoSave systemAdminInfoSave, AsyncCallback<Boolean> async);

//	void listCustomerInfo(CustomerInfoQuery customerInfoQuery, PageInfoDTO<CustomerInfoQueryDTO> pageInfo, AsyncCallback<PageInfoDTO<CustomerInfoQueryDTO>> async);
}
