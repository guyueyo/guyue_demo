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
    private CenterLayoutContainer centerLayoutContainer = new CenterLayoutContainer();

    public CenterLayoutContainer getCenterLayoutContainer(){
        final ContentPanel contentPanel = new ContentPanel();
        contentPanel.setHeading("注册界面");
        FlexTable table = new FlexTable();
        table.getElement().getStyle().setProperty("margin", "20px");
        table.setCellSpacing(15);
        table.setCellPadding(0);

        final TextField usernameTextField = new TextField();
        usernameTextField.setWidth(200);
        final FieldLabel usernameFieldLabel = new FieldLabel(usernameTextField, "请输入您的账号");
        usernameFieldLabel.setLabelWidth(140);

        final TextField passwordTextField = new TextField();
        passwordTextField.setWidth(200);
        final FieldLabel passwordFieldLabel = new FieldLabel(passwordTextField, "请输入您的密码");
        passwordFieldLabel.setLabelWidth(140);

        final TextField rePasswordTextField = new TextField();
        rePasswordTextField.setWidth(200);
        final FieldLabel rePasswordFieldLabel = new FieldLabel(rePasswordTextField, "请确认您的密码");
        rePasswordFieldLabel.setLabelWidth(140);

        final TextField emailTextField = new TextField();
        emailTextField.setWidth(200);
        final FieldLabel emailFieldLabel = new FieldLabel(emailTextField, "请输入您的电子邮箱");
        emailFieldLabel.setLabelWidth(140);

        final TextField safeQuestionTextField = new TextField();
        safeQuestionTextField.setWidth(200);
        final FieldLabel safeQuestionFieldLabel = new FieldLabel(safeQuestionTextField, "请输入您安全问题");
        safeQuestionFieldLabel.setLabelWidth(140);

        final TextField safeAnswerTextField = new TextField();
        safeAnswerTextField.setWidth(200);
        final FieldLabel safeAnswerFieldLabel = new FieldLabel(safeAnswerTextField, "请输入您安全答案");
        safeAnswerFieldLabel.setLabelWidth(140);

        TextButton creatBtn = new TextButton("注册");
        creatBtn.setSize("120","32");
        creatBtn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                String username = usernameTextField.getValue();
                String password = passwordTextField.getValue();
                String rePassword = rePasswordTextField.getValue();
                String email = emailTextField.getValue();
                String safeQuestion = safeQuestionTextField.getValue();
                String safeAnswer = safeAnswerTextField.getValue();
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

        TextButton backBtn = new TextButton("返回");
        backBtn.setSize("120","32");
        backBtn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                MySampleApplication.loginSystemAdmin();
            }
        });
        table.setWidget(0,0,usernameFieldLabel);
        table.setWidget(1,0,passwordFieldLabel);
        table.setWidget(2,0,rePasswordFieldLabel);
        table.setWidget(3,0,emailFieldLabel);
        table.setWidget(4,0,safeQuestionFieldLabel);
        table.setWidget(5,0,safeAnswerFieldLabel);
        table.setWidget(6,0,creatBtn);
        table.setWidget(6,1,backBtn);

//        contentPanel.add(usernameFieldLabel);
        contentPanel.add(table);
        centerLayoutContainer.add(contentPanel);

        return centerLayoutContainer;
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
//            return;
        }

        @Override
        public void onSuccess(SystemAdminInfoQueryDTO result) {
            if (result.getUsername() == null) {
//                Info.display("成功", "当前用户名可用!");
            creatSystemAdminUser(systemAdminInfoSave);
            return;
            }
            Info.display("失败","当前用户名已被占用!");
        }
    }
}
