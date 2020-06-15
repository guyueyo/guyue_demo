package com.mySampleApplication.client.dto;

import java.io.Serializable;

/**
 *
 * message SystemAdmin查询封装类
 * creatBy guyue
 * creatTime 2020/6
 */

public class SystemAdminInfoQuery implements Serializable {
    private String username ;

    private String password ;

    public SystemAdminInfoQuery() {
    }

    public SystemAdminInfoQuery(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SystemAdminInfoQuery{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
