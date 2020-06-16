package com.mySampleApplication.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.mySampleApplication.client.dto.CustomerInfoQuery;
import com.mySampleApplication.client.dto.CustomerInfoQueryDTO;
import com.mySampleApplication.client.dto.PageInfoDTO;
import com.mySampleApplication.client.model.style.CssStyleChange;
import com.mySampleApplication.client.view.customer.creat.SystemAdminCreatView;
import com.mySampleApplication.client.view.customer.login.SystemAdminLoginView;
import com.mySampleApplication.client.view.customer.save.SaveCustomerInfoView;
import com.mySampleApplication.client.view.customer.read.QueryCustomerInfoView;
import com.mySampleApplication.client.view.customer.update.UpdateCustomerInfoView;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CardLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

	public static List<CssStyleChange> cssList = new ArrayList<>();
	public static CardLayoutContainer cardLayout ;
	private static VerticalLayoutContainer verticalLtSaveCustomerInfoView;
	private static VerticalLayoutContainer verticalLtUpdateCustomerInfoView;
	private static BorderLayoutContainer borderLtQueryCustomerInfoView;
	private static CenterLayoutContainer centerLtSystemAdminLogin;
	public static TabPanel tPanel = new TabPanel();
	private static  CenterLayoutContainer centerLtCreatSystemAdmin ;



	public static PageInfoDTO<CustomerInfoQueryDTO> pageInfoDTO = new PageInfoDTO<>();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
//		{
//			CustomerInfoQuery request = new CustomerInfoQuery();
//			MySampleApplicationService.App.getInstance().listCustomerInfo(request, pageInfoDTO,new QueryCustomerInfoView.CustomerQueryWithPageLimitAsyncCallBack());
//		}
		cardLayout = new CardLayoutContainer();
		borderLtQueryCustomerInfoView = new QueryCustomerInfoView().getBorderLtWidget();
		verticalLtSaveCustomerInfoView = new SaveCustomerInfoView().getVerticalLtWidget();
		verticalLtUpdateCustomerInfoView = new UpdateCustomerInfoView().getVerticalLtWidget();
        centerLtSystemAdminLogin = new SystemAdminLoginView().getCenterLtWidget();
        centerLtCreatSystemAdmin = new SystemAdminCreatView().getCenterLtWidget();
//        cardLayout.add(borderLtQueryCustomerInfoView);

		cardLayout.add(centerLtSystemAdminLogin);
		cardLayout.add(centerLtCreatSystemAdmin);
        cardLayout.add(borderLtQueryCustomerInfoView);
		cardLayout.add(verticalLtSaveCustomerInfoView);
		cardLayout.add(verticalLtUpdateCustomerInfoView);
		cardLayout.setHeight(700);
		TabItemConfig tabItemConfig = new TabItemConfig("用户查询管理");
        tPanel.add(cardLayout,tabItemConfig);
		RootPanel.get().add(tPanel);
		changeCssStyle();
	}

	public static void creatSystemAdmin(){cardLayout.setActiveWidget(centerLtCreatSystemAdmin);}
	public static void loginSystemAdmin() {cardLayout.setActiveWidget(centerLtSystemAdminLogin);}
	public static void back(){
		cardLayout.setActiveWidget(borderLtQueryCustomerInfoView);
	}
	public static void save(){
		cardLayout.setActiveWidget(verticalLtSaveCustomerInfoView);
	}
	public static void update(){
		cardLayout.setActiveWidget(verticalLtUpdateCustomerInfoView);
	}

	private static void changeCssStyle(){
		for (CssStyleChange model : cssList) {
			try {
				DOM.getElementById(model.getElementId()).getFirstChildElement().setClassName(model.getCssName());
			}catch (Exception ignored){
			}
		}

	}
}
