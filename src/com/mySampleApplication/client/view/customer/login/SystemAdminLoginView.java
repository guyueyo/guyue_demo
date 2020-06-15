package com.mySampleApplication.client.view.customer.login;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.Style;
import com.google.gwt.logging.client.DefaultLevel;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mySampleApplication.client.MySampleApplication;
import com.mySampleApplication.client.MySampleApplicationService;
import com.mySampleApplication.client.dto.SystemAdminInfoQuery;
import com.mySampleApplication.client.dto.SystemAdminInfoQueryDTO;
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

    private VBoxLayoutContainer vBoxLayoutContainer = new VBoxLayoutContainer();
    private CenterLayoutContainer centerLayoutContainer = new CenterLayoutContainer();


    public CenterLayoutContainer getCenterLayoutContainer() {

        ContentPanel loginPanel = new ContentPanel();
        loginPanel.setHeading("登录界面");
        final TextField usernameTextField = new TextField();
        usernameTextField.setWidth(200);
        final FieldLabel usernameCondition = new FieldLabel(usernameTextField, "请输入您的账号");
        usernameCondition.setLabelWidth(120);

        final PasswordField passwordTextField = new PasswordField();
        passwordTextField.setWidth(200);

        final FieldLabel passwordFieldLabel = new FieldLabel(passwordTextField, "请输入您的密码");
        passwordFieldLabel.setLabelWidth(120);
        TextButton buttonLogin = new TextButton("登录");
        buttonLogin.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                SystemAdminInfoQuery systemAdminInfoQuery = new SystemAdminInfoQuery();
                String username = usernameTextField.getValue();
                String password = passwordTextField.getValue();
                if(username == null || username.isEmpty()){Info.display("警告","请输入用户名");return;}
                if(password == null || password.isEmpty()){Info.display("警告","请输入密码");return;}
                systemAdminInfoQuery.setUsername(username);
                systemAdminInfoQuery.setPassword(password);
                MySampleApplicationService.App.getInstance().readSystemAdminInfo(systemAdminInfoQuery,new SystemAdminLoginAsync());
            }
        });
        TextButton buttonCreat = new TextButton("注册");
        buttonLogin.setSize("100","30");
        buttonCreat.setSize("100","30");
        buttonCreat.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                MySampleApplication.creatSystemAdmin();
            }
        });
        vBoxLayoutContainer.add(usernameCondition, new BoxLayoutContainer.BoxLayoutData(new Margins(50,0,0,0)));
        vBoxLayoutContainer.add(passwordFieldLabel);
        vBoxLayoutContainer.add(buttonLogin,new BoxLayoutContainer.BoxLayoutData(new Margins(20,0,0,100)));
        vBoxLayoutContainer.add(buttonCreat,new BoxLayoutContainer.BoxLayoutData(new Margins(20,0,0,100)));
        vBoxLayoutContainer.setWidth(500);
        loginPanel.add(vBoxLayoutContainer);
        centerLayoutContainer.add(loginPanel);


        return centerLayoutContainer;
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

            final TextButton quitButton = new TextButton("退出");
            quitButton.setSize("150","32");
            TabItemConfig config = MySampleApplication.panel.getConfig(MySampleApplication.cardLayout);
            config.setText("当前用户<"+result.getUsername()+">:");
            quitButton.addSelectHandler(new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
//                    MySampleApplication.loginSystemAdmin();
                    MySampleApplication.panel.setActiveWidget(MySampleApplication.cardLayout);
                    MySampleApplication.panel.remove(quitButton);
                    MySampleApplication.loginSystemAdmin();
//                    MySampleApplication.panel.set
                }
            });


            MySampleApplication.panel.add(quitButton,config);

//            MySampleApplication.panel.addButton(quitButton);
        }
    }
}
