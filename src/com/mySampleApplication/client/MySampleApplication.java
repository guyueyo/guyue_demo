package com.mySampleApplication.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mySampleApplication.client.dto.CustomerInfoQuery;
import com.mySampleApplication.client.dto.CustomerInfoQueryDTO;
import com.mySampleApplication.client.dto.PageInfoDTO;
import com.mySampleApplication.client.model.style.CssStyleChange;
import com.mySampleApplication.client.view.customer.creat.SystemAdminCreatView;
import com.mySampleApplication.client.view.customer.login.SystemAdminLoginView;
import com.mySampleApplication.client.view.customer.save.SaveCustomerInfoView;
import com.mySampleApplication.client.view.customer.read.QueryCustomerInfoView;
import com.mySampleApplication.client.view.customer.update.UpdateCustomerInfoView;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CardLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

	public static List<CssStyleChange> cssList = new ArrayList<>();
	public static CardLayoutContainer cardLayout ;
	private static VerticalLayoutContainer verticalLtSaveCustomerInfoView;
	private static VerticalLayoutContainer verticalLtUpdateCustomerInfoView;
	private static BorderLayoutContainer borderLtQueryCustomerInfoView;
	private static CenterLayoutContainer centerLayoutContainer;
	public static TabPanel panel = new TabPanel();
	private static  CenterLayoutContainer creatSystemAdminLayoutCard ;



	public static PageInfoDTO<CustomerInfoQueryDTO> pageInfoDTO = new PageInfoDTO<>();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		{
			CustomerInfoQuery request = new CustomerInfoQuery();
			MySampleApplicationService.App.getInstance().listCustomerInfo(request, pageInfoDTO,new QueryCustomerInfoView.CustomerQueryWithPageLimitAsyncCallBack());
		}
		cardLayout = new CardLayoutContainer();
		borderLtQueryCustomerInfoView = new QueryCustomerInfoView().getBorderLtWidget();
		verticalLtSaveCustomerInfoView = new SaveCustomerInfoView().getVerticalLtWidget();
		verticalLtUpdateCustomerInfoView = new UpdateCustomerInfoView().getVerticalLtWidget();
		centerLayoutContainer = new SystemAdminLoginView().getCenterLayoutContainer();
		creatSystemAdminLayoutCard = new SystemAdminCreatView().getCenterLayoutContainer();
		cardLayout.add(centerLayoutContainer);
		cardLayout.add(creatSystemAdminLayoutCard);
		cardLayout.add(borderLtQueryCustomerInfoView);
		cardLayout.add(verticalLtSaveCustomerInfoView);
		cardLayout.add(verticalLtUpdateCustomerInfoView);
		cardLayout.setHeight(700);
		TabItemConfig tabItemConfig = new TabItemConfig("用户查询管理");
		panel.add(cardLayout,tabItemConfig);
		RootPanel.get().add(panel);
		changeCssStyle();
	}

	public static void creatSystemAdmin(){cardLayout.setActiveWidget(creatSystemAdminLayoutCard);}
	public static void loginSystemAdmin() {cardLayout.setActiveWidget(centerLayoutContainer);}
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
//			DOM.getElementById(model.getElementId()).getFirstChildElement();
			try {
				DOM.getElementById(model.getElementId()).getFirstChildElement().setClassName(model.getCssName());
			}catch (Exception e){
			}
		}

	}
}
