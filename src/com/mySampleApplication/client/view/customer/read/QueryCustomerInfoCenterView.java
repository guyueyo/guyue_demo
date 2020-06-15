package com.mySampleApplication.client.view.customer.read;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mySampleApplication.client.MySampleApplication;
import com.mySampleApplication.client.MySampleApplicationService;
import com.mySampleApplication.client.dto.CustomerInfoDelete;
import com.mySampleApplication.client.dto.CustomerInfoQuery;
import com.mySampleApplication.client.model.CustomerInfo;
import com.mySampleApplication.client.model.CustomerInfoProperties;
import com.mySampleApplication.client.model.style.CssStyleChange;
import com.mySampleApplication.client.view.customer.update.UpdateCustomerInfoView;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.state.client.GridStateHandler;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.Info;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


public class QueryCustomerInfoCenterView {
	private static final CustomerInfoProperties props = GWT.create(CustomerInfoProperties.class);
	static ListStore<CustomerInfo> store = new ListStore<CustomerInfo>(props.key());
	private VerticalLayoutContainer verticalLtCenter;
	private GridStateHandler<CustomerInfo> gridStateHandler;

	public VerticalLayoutContainer getVerticalLtCenter() {

		if (verticalLtCenter == null) {
			//复选框选择模型
			CheckBoxSelectionModel<CustomerInfo> chkSelectionModel = new CheckBoxSelectionModel<CustomerInfo>();

			ColumnConfig<CustomerInfo, String> columnCustomerCode = new ColumnConfig<CustomerInfo, String>(props.customerCode(), 50, "客户代码");
			ColumnConfig<CustomerInfo, String> columnCustomerName = new ColumnConfig<CustomerInfo, String>(props.customerName(), 50, "客户名称");
			ColumnConfig<CustomerInfo, String> columnMnemonicCode = new ColumnConfig<CustomerInfo, String>(props.mnemonicCode(), 50, "助记码");
			ColumnConfig<CustomerInfo, String> columnCustomerType = new ColumnConfig<CustomerInfo, String>(props.customerType(), 50, "客户类型");
			ColumnConfig<CustomerInfo, String> columnPhone = new ColumnConfig<CustomerInfo, String>(props.phone(), 50, "电话");
			ColumnConfig<CustomerInfo, String> columnFax = new ColumnConfig<CustomerInfo, String>(props.fax(), 50, "传真");
			ColumnConfig<CustomerInfo, String> columnEmail = new ColumnConfig<CustomerInfo, String>(props.email(), 50, "电子邮箱");
			ColumnConfig<CustomerInfo, Boolean> columnEnableTag = new ColumnConfig<CustomerInfo, Boolean>(props.enableTag(), 50, "启用标记");

			List<ColumnConfig> columnList = new ArrayList<ColumnConfig>();
			columnList.add(chkSelectionModel.getColumn());
			columnList.add(columnCustomerCode);
			columnList.add(columnCustomerName);
			columnList.add(columnMnemonicCode);
			columnList.add(columnCustomerType);
			columnList.add(columnPhone);
			columnList.add(columnFax);
			columnList.add(columnEmail);
			columnList.add(columnEnableTag);

			final Grid<CustomerInfo> gridCustomerInfo = new Grid<CustomerInfo>(store, new ColumnModel(columnList));
			//设置选择模型
			gridCustomerInfo.setSelectionModel(chkSelectionModel);
			gridCustomerInfo.setAllowTextSelection(false);
			gridCustomerInfo.getView().setStripeRows(true);
			gridCustomerInfo.getView().setColumnLines(true);
			gridCustomerInfo.setBorders(false);
			gridCustomerInfo.setColumnReordering(true);
			gridCustomerInfo.setStateful(true);
			gridCustomerInfo.setStateId("gridStateExample");
			verticalLtCenter = new VerticalLayoutContainer();
			// 新增按钮
			TextButton btnSave = new TextButton("新增");
			btnSave.setSize("80","30");
			String btnSaveId = "customer_save_btn";
			btnSave.setId(btnSaveId);
			MySampleApplication.cssList.add(new CssStyleChange("success_btn",btnSaveId));
			btnSave.addSelectHandler(new SelectEvent.SelectHandler() {
				@Override
				public void onSelect(SelectEvent event) {
					MySampleApplication.save();
				}
			});
			//删除按钮
			TextButton btnDelete = new TextButton("删除");
			btnDelete.setSize("80", "30");
			String btnDeleteId = "customer_delete_btn";
			btnDelete.setId(btnDeleteId);
			MySampleApplication.cssList.add(new CssStyleChange("failed_btn",btnDeleteId));
			btnDelete.addSelectHandler(
					new SelectEvent.SelectHandler() {
				@Override
				public void onSelect(SelectEvent event) {
					CustomerInfoDelete request = new CustomerInfoDelete();
					List<CustomerInfo> models = gridCustomerInfo.getSelectionModel().getSelectedItems();
					if(models.size() == 0){
						Info.display("提示", "请选择删除的记录");
					} else {
						List<Integer> ids = new ArrayList<>();
						for (CustomerInfo customerInfo : models){
							ids.add(customerInfo.getId());
							Info.display("序号", ""+store.indexOf(customerInfo));
//							store.remove(store.indexOf(customerInfo));
						}
						request.setIds(ids);
						MySampleApplicationService.App.getInstance().deleteCustomerInfo(request,new CustomerDeleteAsyncCallback());
						{
							CustomerInfoQuery customerInfoQuery = new CustomerInfoQuery();
							MySampleApplication.pageInfoDTO.setTotalNum(MySampleApplication.pageInfoDTO.getTotalNum()-1);
							MySampleApplicationService.App.getInstance().listCustomerInfo(customerInfoQuery, MySampleApplication.pageInfoDTO,new QueryCustomerInfoView.CustomerQueryWithPageLimitAsyncCallBack());
						}
//						MySampleApplication.back();
					}
				}
			});
			//修改按钮
			TextButton btnUpdate = new TextButton("修改");
			String btnUpdateId = "customer_update_btn";
			btnUpdate.setId(btnUpdateId);
			MySampleApplication.cssList.add(new CssStyleChange("warn_btn",btnUpdateId));
			btnUpdate.setSize("80","30");
			btnUpdate.addSelectHandler(new SelectEvent.SelectHandler() {
				@Override
				public void onSelect(SelectEvent event) {
					List<CustomerInfo> models = gridCustomerInfo.getSelectionModel().getSelectedItems();
					if(models.size() != 1){
						Info.display("提示", "请选择一条需要修改的记录");
					} else {
						CustomerInfo customerInfo = new CustomerInfo();
						customerInfo.setPhone(models.get(0).getPhone());
						customerInfo.setId(models.get(0).getId());
						customerInfo.setBirth(models.get(0).getBirth());
						customerInfo.setAddress(models.get(0).getAddress());
						customerInfo.setSettlementMethod(models.get(0).getSettlementMethod());
						customerInfo.setSettlementDate(models.get(0).getSettlementDate());
						customerInfo.setRemark(models.get(0).getRemark());
						customerInfo.setPostCode(models.get(0).getPostCode());
						customerInfo.setMonthlyDate(models.get(0).getMonthlyDate());
						customerInfo.setCompany(models.get(0).getCompany());
						customerInfo.setBankAcount(models.get(0).getBankAcount());
						customerInfo.setBank(models.get(0).getBank());
						customerInfo.setMnemonicCode(models.get(0).getMnemonicCode());
						customerInfo.setCustomerCode(models.get(0).getCustomerCode());
						customerInfo.setCustomerName(models.get(0).getCustomerName());
						customerInfo.setCustomerType(models.get(0).getCustomerType());
						customerInfo.setEmail(models.get(0).getEmail());
						customerInfo.setEnableTag(models.get(0).getEnableTag());
						customerInfo.setFax(models.get(0).getFax());
						UpdateCustomerInfoView.setCustomerInfo(customerInfo);
						MySampleApplication.update();
					}
				}
			});

			HBoxLayoutContainer hboxLtBtn = new HBoxLayoutContainer();
			hboxLtBtn.setHeight(45);
			hboxLtBtn.add(btnSave, new BoxLayoutContainer.BoxLayoutData(new Margins(5,0,0,20)));
			hboxLtBtn.add(btnUpdate, new BoxLayoutContainer.BoxLayoutData(new Margins(5,0,0,20)));
			hboxLtBtn.add(btnDelete, new BoxLayoutContainer.BoxLayoutData(new Margins(5,0,0,20)));
			verticalLtCenter.add(hboxLtBtn);
			verticalLtCenter.add(gridCustomerInfo, new VerticalLayoutContainer.VerticalLayoutData(1, 1));

			gridStateHandler = new GridStateHandler<CustomerInfo>(gridCustomerInfo);

		}
		gridStateHandler.loadState();
		return verticalLtCenter;
	}




	private static class CustomerDeleteAsyncCallback implements AsyncCallback<String> {

		public CustomerDeleteAsyncCallback() {
		}

		@Override
		public void onFailure(Throwable caught) {
			Info.display("删除失败", caught.getMessage());
		}

		@Override
		public void onSuccess(String result) {

			Info.display("删除成功", result);
		}

	}
}
