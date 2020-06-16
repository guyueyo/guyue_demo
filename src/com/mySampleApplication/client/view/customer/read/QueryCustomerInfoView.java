package com.mySampleApplication.client.view.customer.read;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.mySampleApplication.client.MySampleApplication;
import com.mySampleApplication.client.MySampleApplicationService;
import com.mySampleApplication.client.dto.CustomerInfoQueryDTO;
import com.mySampleApplication.client.model.CustomerInfo;
import com.mySampleApplication.client.dto.CustomerInfoQuery;
import com.mySampleApplication.client.dto.PageInfoDTO;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.state.client.BorderLayoutStateHandler;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.event.BeforeSelectEvent;
import com.sencha.gxt.widget.core.client.event.BeforeShowEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.ArrayList;
import java.util.List;


public class QueryCustomerInfoView {

	private BorderLayoutContainer borderLtWidget;
	private static Label lbTotalNum = new Label();
	private BorderLayoutStateHandler borderLtStateHandler;
	private static SimpleComboBox<Integer> sbbPageTotalNum = new SimpleComboBox<Integer>(new StringLabelProvider<Integer>());

	// 查询条件
	private static final TextField tdCondition = new TextField();

	public static TextField tdRequest = new TextField();
	public BorderLayoutContainer getBorderLtWidget() {
		getPageTotalNum(MySampleApplication.pageInfoDTO.getTotalPage());
		if(borderLtWidget == null ){
			// center部分
			ContentPanel cpCenter = new ContentPanel();
			cpCenter.add(new QueryCustomerInfoCenterView().getVerticalLtCenter());
			cpCenter.setHeaderVisible(false);
			cpCenter.setBodyBorder(false);
			// north部分
			ContentPanel cpNorth = new ContentPanel();
			cpNorth.setHeading("查询条件");
			cpNorth.setBodyBorder(false);


			tdCondition.setWidth(200);
			FieldLabel flbCondition = new FieldLabel(tdCondition, "输入客户代码、助记符、名称");
			flbCondition.setLabelWidth(180);
			// 查询按钮
			TextButton btnRead = new TextButton("查询");
			btnRead.setId("查询");
			btnRead.addSelectHandler(new SelectEvent.SelectHandler() {
				@Override
				public void onSelect(SelectEvent event) {
					tdRequest = tdCondition;
					MySampleApplication.pageInfoDTO.setCurrentPage(1);
//					MySampleApplicationService.App.getInstance().listCustomerInfo(getRequest(tdCondition), MySampleApplication.pageInfoDTO, new CustomerQueryWithPageLimitAsyncCallBack());

//					MySampleApplicationService.App.getInstance().listCustomerInfo(getRequest(tdCondition),new QueryCustomerInfoView.CustomerQueryAsyncCallback());
					//own page limit
//					reload();
					QueryCustomerInfoCenterView.loader.load(0,QueryCustomerInfoCenterView.PAGE_SIZE);
				}
			});


			btnRead.setWidth(60);
			HBoxLayoutContainer hboxLtNorth = new HBoxLayoutContainer();
			hboxLtNorth.add(flbCondition);



//			TextButton btnLastPage = new TextButton("上一页");
//			btnLastPage.setSize("80","30");
//			btnLastPage.addSelectHandler(new SelectEvent.SelectHandler() {
//				@Override
//				public void onSelect(SelectEvent event) {
//					if(MySampleApplication.pageInfoDTO.getCurrentPage()<=1){return;}
//					MySampleApplication.pageInfoDTO.setCurrentPage(MySampleApplication.pageInfoDTO.getCurrentPage()-1);
//					MySampleApplicationService.App.getInstance().listCustomerInfo(getRequest(tdCondition), MySampleApplication.pageInfoDTO, new CustomerQueryWithPageLimitAsyncCallBack());
//					reload();
//				}
//			});
//			TextButton btnNextPage = new TextButton("下一页");
//			btnNextPage.setSize("80","30");
//			btnNextPage.addSelectHandler(new SelectEvent.SelectHandler() {
//				@Override
//				public void onSelect(SelectEvent event) {
//					if(MySampleApplication.pageInfoDTO.getCurrentPage()>=MySampleApplication.pageInfoDTO.getTotalPage()){return;}
//					MySampleApplication.pageInfoDTO.setCurrentPage(MySampleApplication.pageInfoDTO.getCurrentPage()+1);
//					MySampleApplicationService.App.getInstance().listCustomerInfo(getRequest(tdCondition), MySampleApplication.pageInfoDTO, new CustomerQueryWithPageLimitAsyncCallBack());
//					reload();
//				}
//			});
//
//			sbbPageTotalNum.setWidth(80);
//			sbbPageTotalNum.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
//			sbbPageTotalNum.addSelectionHandler(new SelectionHandler<Integer>() {
//				@Override
//				public void onSelection(SelectionEvent<Integer> event) {
//					Integer selectedItem = event.getSelectedItem();
//					MySampleApplication.pageInfoDTO.setCurrentPage(selectedItem);
//					MySampleApplicationService.App.getInstance().listCustomerInfo(getRequest(tdCondition), MySampleApplication.pageInfoDTO, new CustomerQueryWithPageLimitAsyncCallBack());
//					reload();
//				}
//			});
//			SimpleComboBox<Integer> sbbPageSize = new SimpleComboBox<Integer>(new StringLabelProvider<Integer>());
//			sbbPageSize.setWidth(80);
//			sbbPageSize.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
//			sbbPageSize.setEditable(false);
//			sbbPageSize.add(1);
//			sbbPageSize.add(3);
//			sbbPageSize.add(5);
//			sbbPageSize.add(10);
//			sbbPageSize.setValue(3);
//			sbbPageSize.addSelectionHandler(new SelectionHandler<Integer>() {
//				@Override
//				public void onSelection(SelectionEvent<Integer> event) {
//					Integer selectedItem = event.getSelectedItem();
//					MySampleApplication.pageInfoDTO.setPageSize(selectedItem);
//					if(MySampleApplication.pageInfoDTO.getTotalPage()<MySampleApplication.pageInfoDTO.getCurrentPage()){
//						MySampleApplication.pageInfoDTO.setCurrentPage(MySampleApplication.pageInfoDTO.getTotalPage());
//						MySampleApplicationService.App.getInstance().listCustomerInfo(getRequest(tdCondition), MySampleApplication.pageInfoDTO, new CustomerQueryWithPageLimitAsyncCallBack());
//					}else {
//						MySampleApplicationService.App.getInstance().listCustomerInfo(getRequest(tdCondition), MySampleApplication.pageInfoDTO, new CustomerQueryWithPageLimitAsyncCallBack());
//					}
//					lbTotalNum.setText("总计有"+MySampleApplication.pageInfoDTO.getTotalNum()+"条数据,"+MySampleApplication.pageInfoDTO.getTotalPage()+"页");
//					getPageTotalNum(MySampleApplication.pageInfoDTO.getTotalPage());
//				}
//			});
//			lbTotalNum.setText("总计有"+MySampleApplication.pageInfoDTO.getTotalNum()+"条数据");
//			Label lbPageSizeStart = new Label("每页显示：");
////			lbPageSizeStart.setHeight("30");
//			Label lbPageSizeEnd = new Label("条");
////			lbPageSizeEnd.setHeight("50");
			hboxLtNorth.add(btnRead,new BoxLayoutContainer.BoxLayoutData(new Margins(0,0,0,10)));
//			//上一页下一页控件
//			hboxLtNorth.add(btnLastPage,new BoxLayoutContainer.BoxLayoutData(new Margins(0,0,0,300)));
//			hboxLtNorth.add(btnNextPage,new BoxLayoutContainer.BoxLayoutData(new Margins(0,0,0,10)));
//
//			//页码控件
//			hboxLtNorth.add(sbbPageTotalNum,new BoxLayoutContainer.BoxLayoutData(new Margins(0,0,0,10)));
//			//每页条数控制
//			hboxLtNorth.add(lbPageSizeStart,new BoxLayoutContainer.BoxLayoutData(new Margins(0,0,0,50)));
//			hboxLtNorth.add(sbbPageSize,new BoxLayoutContainer.BoxLayoutData(new Margins(0,0,0,2)));
//			hboxLtNorth.add(lbPageSizeEnd,new BoxLayoutContainer.BoxLayoutData(new Margins(0,0,0,2)));
//			//总条数显示
//			hboxLtNorth.add(lbTotalNum,new BoxLayoutContainer.BoxLayoutData(new Margins(0,0,0,20)));

			hboxLtNorth.setPosition(20,10);
			cpNorth.add(hboxLtNorth);
			// west部分
			ContentPanel cpWest = new ContentPanel();
			cpWest.setHeading("客户类型");
			cpWest.setBodyBorder(false);





			BorderLayoutContainer.BorderLayoutData borderLtNorthData = new BorderLayoutContainer.BorderLayoutData(100);
			borderLtNorthData.setCollapsible(true);
			borderLtNorthData.setCollapseHeaderVisible(true);
			borderLtNorthData.setSplit(false);

			BorderLayoutContainer.BorderLayoutData borderLtWestData = new BorderLayoutContainer.BorderLayoutData(150);
			borderLtWestData.setCollapsible(true);
			borderLtWestData.setSplit(false);

			BorderLayoutContainer.BorderLayoutData borderLtCenterData = new BorderLayoutContainer.BorderLayoutData(100);

			borderLtWidget =  new BorderLayoutContainer();
			borderLtWidget.setNorthWidget(cpNorth, borderLtNorthData);
			borderLtWidget.setWestWidget(cpWest, borderLtWestData);
			borderLtWidget.setCenterWidget(cpCenter, borderLtCenterData);
			borderLtStateHandler = new BorderLayoutStateHandler(borderLtWidget, "blcId1");
			borderLtWidget.setStateful(true);
		}
		borderLtStateHandler.loadState();

		return borderLtWidget;
	}

	private static void getPageTotalNum(int pageTotalNum){
		sbbPageTotalNum.getStore().clear();
		if(pageTotalNum>=1){
			for (int i = 1;i<=pageTotalNum;i++){
				sbbPageTotalNum.add(i);
			}
			sbbPageTotalNum.setValue(MySampleApplication.pageInfoDTO.getCurrentPage());
		}
	}

	private static void reload(){
		lbTotalNum.setText("总计有"+MySampleApplication.pageInfoDTO.getTotalNum()+"条数据,"+MySampleApplication.pageInfoDTO.getTotalPage()+"页");
		getPageTotalNum(MySampleApplication.pageInfoDTO.getTotalPage());
	}


	public CustomerInfoQuery getRequest(TextField tdCondition) {
		CustomerInfoQuery request = new CustomerInfoQuery();
		if (tdCondition.getValue() != null && !tdCondition.getValue().isEmpty()){
			request.setCustomerCode(tdCondition.getValue());
			request.setMnemonicCode(tdCondition.getValue());
			request.setCustomerName(tdCondition.getValue());
		}
		return request;
	}


	public static class CustomerQueryWithPageLimitAsyncCallBack implements  AsyncCallback<PageInfoDTO<CustomerInfoQueryDTO>>{
		@Override
		public void onFailure(Throwable caught) {
			Info.display("查询失败",caught.getMessage());
		}

		@Override
		public void onSuccess(PageInfoDTO<CustomerInfoQueryDTO> result) {
			QueryCustomerInfoCenterView.store.clear();
			if(result==null)return;
			MySampleApplication.pageInfoDTO = result;
			reload();
			List<CustomerInfo> customerInfoList = new ArrayList<>();
			if(result.getList() != null && !result.getList().isEmpty()){
				for (CustomerInfoQueryDTO rsp : result.getList()){
					CustomerInfo customerInfo = new CustomerInfo();
					customerInfo.setAddress(rsp.getAddress());
					customerInfo.setPhone(rsp.getPhone());
					customerInfo.setId(rsp.getId());
					customerInfo.setCustomerCode(rsp.getCustomerCode());
					customerInfo.setCustomerName(rsp.getCustomerName());
					customerInfo.setCustomerType(rsp.getCustomerType());
					customerInfo.setEmail(rsp.getEmail());
					customerInfo.setEnableTag(rsp.getEnableTag());
					customerInfo.setFax(rsp.getFax());
					customerInfo.setBirth(rsp.getBirth());
					customerInfo.setMnemonicCode(rsp.getMnemonicCode());
					customerInfo.setBank(rsp.getBank());
					customerInfo.setBankAcount(rsp.getBankAcount());
					customerInfo.setCompany(rsp.getCompany());
					customerInfo.setMonthlyDate(rsp.getMonthlyDate());
					customerInfo.setPostCode(rsp.getPostCode());
					customerInfo.setRemark(rsp.getRemark());
					customerInfo.setSettlementDate(rsp.getSettlementDate());
					customerInfo.setSettlementMethod(rsp.getSettlementMethod());
					customerInfoList.add(customerInfo);
				}
			}
			QueryCustomerInfoCenterView.store.addAll(customerInfoList);
		}
	}





	public static class CustomerQueryAsyncCallback implements AsyncCallback<List<CustomerInfoQueryDTO>> {

		@Override
		public void onFailure(Throwable caught) {
			Info.display("查询失败", caught.getMessage());
		}

		@Override
		public void onSuccess(List<CustomerInfoQueryDTO> result) {
			QueryCustomerInfoCenterView.store.clear();
			List<CustomerInfo> customerInfoList = new ArrayList<>();
			if(result != null && !result.isEmpty()){
				for (CustomerInfoQueryDTO rsp : result){
					CustomerInfo customerInfo = new CustomerInfo();
					customerInfo.setAddress(rsp.getAddress());
					customerInfo.setPhone(rsp.getPhone());
					customerInfo.setId(rsp.getId());
					customerInfo.setCustomerCode(rsp.getCustomerCode());
					customerInfo.setCustomerName(rsp.getCustomerName());
					customerInfo.setCustomerType(rsp.getCustomerType());
					customerInfo.setEmail(rsp.getEmail());
					customerInfo.setEnableTag(rsp.getEnableTag());
					customerInfo.setFax(rsp.getFax());
					customerInfo.setBirth(rsp.getBirth());
					customerInfo.setMnemonicCode(rsp.getMnemonicCode());
					customerInfo.setBank(rsp.getBank());
					customerInfo.setBankAcount(rsp.getBankAcount());
					customerInfo.setCompany(rsp.getCompany());
					customerInfo.setMonthlyDate(rsp.getMonthlyDate());
					customerInfo.setPostCode(rsp.getPostCode());
					customerInfo.setRemark(rsp.getRemark());
					customerInfo.setSettlementDate(rsp.getSettlementDate());
					customerInfo.setSettlementMethod(rsp.getSettlementMethod());
					customerInfoList.add(customerInfo);
				}
			}
			QueryCustomerInfoCenterView.store.addAll(customerInfoList);
			//Info.display("查询成功", result == null ? "查询无数据" : result.toString());
		}
	}
}
