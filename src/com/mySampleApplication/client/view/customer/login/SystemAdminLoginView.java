package com.mySampleApplication.client.view.customer.login;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.Style;
import com.google.gwt.logging.client.DefaultLevel;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.mySampleApplication.client.MySampleApplication;
import com.mySampleApplication.client.MySampleApplicationService;
import com.mySampleApplication.client.dto.SystemAdminInfoQuery;
import com.mySampleApplication.client.dto.SystemAdminInfoQueryDTO;
import com.mySampleApplication.client.model.style.CssStyleChange;
import com.mySampleApplication.client.util.Utils;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.theme.triton.custom.client.button.TritonButtonCellAppearance;
import com.sencha.gxt.theme.triton.custom.client.button.TritonButtonCellToolBarAppearance;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;



public class SystemAdminLoginView {

    private VBoxLayoutContainer vBoxLtWidget = new VBoxLayoutContainer();
    private CenterLayoutContainer centerLtWidget = new CenterLayoutContainer();

    private final TextField tdUsername = new TextField();
    private final PasswordField tdPassword = new PasswordField();


    public CenterLayoutContainer getCenterLtWidget() {
//        centerLayoutContainer.addAddHandler(new KeyboardListener().onKeyPress(){on})
        centerLtWidget.setId("login");
        ContentPanel panelLogin = new ContentPanel();
        panelLogin.setHeading("登录界面");

        tdUsername.setWidth(200);
        final FieldLabel flbUsername = new FieldLabel(tdUsername, "请输入您的账号");
        flbUsername.setLabelWidth(120);
        
        tdPassword.setWidth(200);

        final FieldLabel flbPassword = new FieldLabel(tdPassword, "请输入您的密码");
        flbPassword.setLabelWidth(120);
        final TextButton btnLogin = new TextButton("登录");
        btnLogin.setId("btnLogin");
        MySampleApplication.cssList.add(new CssStyleChange("success_btn","btnLogin"));
        btnLogin.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                loginSystem();
            }
        });
//        com-sencha-gxt-theme-triton-custom-client-button-TritonButtonCellToolBarAppearance-TritonButtonCellStyle-button
        TextButton btnCreat = new TextButton("注册");
        btnLogin.setSize("100","30");
        btnCreat.setSize("100","30");
        String btnCreatId = "btnSystemAdminCreat";
        btnCreat.setId(btnCreatId);
        MySampleApplication.cssList.add(new CssStyleChange("warn_btn",btnCreatId));
        btnCreat.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                MySampleApplication.creatSystemAdmin();
            }
        });
        vBoxLtWidget.add(flbUsername, new BoxLayoutContainer.BoxLayoutData(new Margins(50,0,0,0)));
        vBoxLtWidget.add(flbPassword);
        vBoxLtWidget.add(btnLogin,new BoxLayoutContainer.BoxLayoutData(new Margins(20,0,0,100)));
        vBoxLtWidget.add(btnCreat,new BoxLayoutContainer.BoxLayoutData(new Margins(20,0,0,100)));
        vBoxLtWidget.setWidth(500);
        panelLogin.add(vBoxLtWidget);
        centerLtWidget.add(panelLogin);
        return centerLtWidget;
    }

    private void loginSystem (){
        SystemAdminInfoQuery systemAdminInfoQuery = new SystemAdminInfoQuery();
        String username = tdUsername.getValue();
        String password = tdPassword.getValue();
        if(username == null || username.isEmpty()){Info.display("警告","请输入用户名");return;}
        if(password == null || password.isEmpty()){Info.display("警告","请输入密码");return;}
        systemAdminInfoQuery.setUsername(username);
        systemAdminInfoQuery.setPassword(password);
        MySampleApplicationService.App.getInstance().readSystemAdminInfo(systemAdminInfoQuery,new SystemAdminLoginAsync());
    }


    private static class SystemAdminLoginAsync implements AsyncCallback<SystemAdminInfoQueryDTO>{
        @Override
        public void onFailure(Throwable caught) {
            Info.display("失败","请检查您的账号或密码!");
        }

        @Override
        public void onSuccess(SystemAdminInfoQueryDTO result) {

            if (result.getUsername() == null){
                Info.display("失败","请检查您的账号或密码!");
                return;
            }
            MySampleApplication.back();
            Info.display("登录成功","尊敬的<"+result.getUsername()+">用户,欢迎您回来!");

            final TextButton btnQuit = new TextButton("退出");
            btnQuit.setSize("150","32");
            TabItemConfig config = MySampleApplication.tPanel.getConfig(MySampleApplication.cardLayout);
            config.setText("当前用户<"+result.getUsername()+">:");
            btnQuit.addSelectHandler(new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    MySampleApplication.tPanel.setActiveWidget(MySampleApplication.cardLayout);
                    MySampleApplication.tPanel.remove(btnQuit);
                    MySampleApplication.loginSystemAdmin();
                }
            });


            MySampleApplication.tPanel.add(btnQuit,config);

//            MySampleApplication.panel.addButton(btnQuit);
        }
    }
}
