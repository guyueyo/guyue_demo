package com.mySampleApplication.client.view.customer.creat;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.mySampleApplication.client.MySampleApplication;
import com.mySampleApplication.client.MySampleApplicationService;
//import com.mySampleApplication.client.dto.CustomerInfoQuery;
import com.mySampleApplication.client.dto.SystemAdminInfoQuery;
import com.mySampleApplication.client.dto.SystemAdminInfoQueryDTO;
import com.mySampleApplication.client.dto.SystemAdminInfoSave;
import com.sencha.gxt.widget.core.client.ContentPanel;
//import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

public class SystemAdminCreatView {
    private static SystemAdminInfoSave systemAdminInfoSave = new SystemAdminInfoSave();
//    private VBoxLayoutContainer vBoxLayoutContainer = new VBoxLayoutContainer();
    private CenterLayoutContainer centerLtWidget = new CenterLayoutContainer();

    public CenterLayoutContainer getCenterLtWidget(){
        final ContentPanel contentPanel = new ContentPanel();
        contentPanel.setHeading("注册界面");
        FlexTable table = new FlexTable();
        table.getElement().getStyle().setProperty("margin", "20px");
        table.setCellSpacing(15);
        table.setCellPadding(0);

        final TextField tdUsername = new TextField();
        tdUsername.setWidth(200);
        final FieldLabel flbUsername = new FieldLabel(tdUsername, "请输入您的账号");
        flbUsername.setLabelWidth(140);

        final TextField tdPassword = new TextField();
        tdPassword.setWidth(200);
        final FieldLabel flbPassword = new FieldLabel(tdPassword, "请输入您的密码");
        flbPassword.setLabelWidth(140);

        final TextField tdRePassword = new TextField();
        tdRePassword.setWidth(200);
        final FieldLabel flbRePassword = new FieldLabel(tdRePassword, "请确认您的密码");
        flbRePassword.setLabelWidth(140);

        final TextField tdEmail = new TextField();
        tdEmail.setWidth(200);
        final FieldLabel flbEmail = new FieldLabel(tdEmail, "请输入您的电子邮箱");
        flbEmail.setLabelWidth(140);

        final TextField tdSafeQuestion = new TextField();
        tdSafeQuestion.setWidth(200);
        final FieldLabel flbSafeQuestion = new FieldLabel(tdSafeQuestion, "请输入您安全问题");
        flbSafeQuestion.setLabelWidth(140);

        final TextField tdSafeAnswer = new TextField();
        tdSafeAnswer.setWidth(200);
        final FieldLabel flbSafeAnswer = new FieldLabel(tdSafeAnswer, "请输入您安全答案");
        flbSafeAnswer.setLabelWidth(140);

        TextButton btnCreat = new TextButton("注册");
        btnCreat.setSize("120","32");
        btnCreat.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                String username = tdUsername.getValue();
                String password = tdPassword.getValue();
                String rePassword = tdRePassword.getValue();
                String email = tdEmail.getValue();
                String safeQuestion = tdSafeQuestion.getValue();
                String safeAnswer = tdSafeAnswer.getValue();
                if(username==null||username.isEmpty()){
                    Info.display("警告","请输入账号!");
                    return;
                };
                if(password==null||password.isEmpty()){
                    Info.display("警告","请输入密码!");
                    return;
                }
                if(rePassword==null||rePassword.isEmpty()){
                    Info.display("警告","请确认密码!");
                    return;
                }
                if(!password.equals(rePassword)){
                    Info.display("警告","两次密码不一致!");
                    return;
                }
                if(email==null||email.isEmpty()){
                    Info.display("警告","请输入邮箱!");
                    return;
                }
                if(safeQuestion==null||safeQuestion.isEmpty()){
                    Info.display("警告","请输入安全问题!");
                    return;
                }
                if(safeAnswer==null||safeAnswer.isEmpty()){
                    Info.display("警告","请输入安全答案!");
                    return;
                }
                SystemAdminInfoQuery systemAdminInfoQuery = new SystemAdminInfoQuery();
                systemAdminInfoQuery.setUsername(username);
                systemAdminInfoSave.setUsername(username);
                systemAdminInfoSave.setPassword(password);
                systemAdminInfoSave.setEmail(email);
                systemAdminInfoSave.setSafeQuestion(safeQuestion);
                systemAdminInfoSave.setSafeAnswer(safeAnswer);
                MySampleApplicationService.App.getInstance().readSystemAdminInfo(systemAdminInfoQuery,new SystemAdminQueryAsync());
            }
        });

        TextButton btnBack = new TextButton("返回");
        btnBack.setSize("120","32");
        btnBack.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                MySampleApplication.loginSystemAdmin();
            }
        });
        table.setWidget(0,0,flbUsername);
        table.setWidget(1,0,flbPassword);
        table.setWidget(2,0,flbRePassword);
        table.setWidget(3,0,flbEmail);
        table.setWidget(4,0,flbSafeQuestion);
        table.setWidget(5,0,flbSafeAnswer);
        table.setWidget(6,0,btnCreat);
        table.setWidget(6,1,btnBack);

//        contentPanel.add(usernameFieldLabel);
        contentPanel.add(table);
        centerLtWidget.add(contentPanel);

        return centerLtWidget;
    }
    private static void creatSystemAdminUser(SystemAdminInfoSave systemAdminInfoSave){
        MySampleApplicationService.App.getInstance().saveSystemAdminInfo(systemAdminInfoSave,new SystemAdminSaveAsync());
    }
    private static class SystemAdminSaveAsync implements AsyncCallback<Boolean> {

        @Override
        public void onFailure(Throwable caught) {
            Info.display("失败", "服务器繁忙请稍后再试!");
        }

        @Override
        public void onSuccess(Boolean result) {
            if(result){
                Info.display("成功", "创建成功!");
                MySampleApplication.loginSystemAdmin();
                return;
            }
            Info.display("失败","发生未知错误请稍后重试!");
        }
    }


    private static class SystemAdminQueryAsync implements AsyncCallback<SystemAdminInfoQueryDTO> {
        @Override
        public void onFailure(Throwable caught) {
            Info.display("失败", "服务器繁忙请稍后再试!");
        }

        @Override
        public void onSuccess(SystemAdminInfoQueryDTO result) {
            if (result.getUsername() == null) {
            creatSystemAdminUser(systemAdminInfoSave);
            return;
            }
            Info.display("失败","当前用户名已被占用!");
        }
    }
}
