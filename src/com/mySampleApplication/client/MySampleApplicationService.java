package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mySampleApplication.client.dto.*;
import com.mySampleApplication.client.model.CustomerInfo;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import java.util.List;

@RemoteServiceRelativePath("MySampleApplicationService")
public interface MySampleApplicationService extends RemoteService {
	String deleteCustomerInfo(CustomerInfoDelete request);

	String updateCustomerInfo(CustomerInfoUpdate request);

	List<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery request);

	PageInfoDTO<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery, PageInfoDTO<CustomerInfoQueryDTO> pageInfo);

	CustomerInfoSaveDTO saveCustomerInfo(CustomerInfoSave request);

	PagingLoadResult<CustomerInfo> listCustomerInfoLimit(CustomerInfoQuery customerInfoQuery,PagingLoadConfig request);

	SystemAdminInfoQueryDTO readSystemAdminInfo(SystemAdminInfoQuery systemAdminInfoQuery);

	Boolean saveSystemAdminInfo(SystemAdminInfoSave systemAdminInfoSave);

    PagingLoadResult<CustomerInfo> listCustomerInfo(int offset,int limit);


	/**
	 * Utility/Convenience class.
	 * Use MySampleApplicationService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
	 */
	public static class App {
		private static MySampleApplicationServiceAsync ourInstance = GWT.create(MySampleApplicationService.class);

		public static synchronized MySampleApplicationServiceAsync getInstance() {
			return ourInstance;
		}
	}
}
