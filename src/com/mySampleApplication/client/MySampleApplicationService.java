package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mySampleApplication.client.dto.*;

import java.util.List;

@RemoteServiceRelativePath("MySampleApplicationService")
public interface MySampleApplicationService extends RemoteService {
	String deleteCustomerInfo(CustomerInfoDelete request);

	String updateCustomerInfo(CustomerInfoUpdate request);

	List<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery request);

	PageInfoDTO<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery, PageInfoDTO<CustomerInfoQueryDTO> pageInfo);

	CustomerInfoSaveDTO saveCustomerInfo(CustomerInfoSave request);

	SystemAdminInfoQueryDTO querySystemAdminInfo(SystemAdminInfoQuery systemAdminInfoQuery);

	Boolean creatSystemAdminInfo(SystemAdminInfoSave systemAdminInfoSave);

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
