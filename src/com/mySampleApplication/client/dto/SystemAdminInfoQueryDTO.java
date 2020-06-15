package com.mySampleApplication.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 *
 * message SystemAdmin查询返回封装类
 * creatBy guyue
 * creatTime 2020/6
 */


public class SystemAdminInfoQueryDTO implements IsSerializable {

    private int id ;

    private String username ;

    private String password ;

    private String email ;

    private String safeQuestion ;

    private String safeAnswer ;

    public SystemAdminInfoQueryDTO() {
    }

    public SystemAdminInfoQueryDTO(int id, String username, String password, String email, String safeQuestion, String safeAnswer) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.safeQuestion = safeQuestion;
        this.safeAnswer = safeAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSafeQuestion() {
        return safeQuestion;
    }

    public void setSafeQuestion(String safeQuestion) {
        this.safeQuestion = safeQuestion;
    }

    public String getSafeAnswer() {
        return safeAnswer;
    }

    public void setSafeAnswer(String safeAnswer) {
        this.safeAnswer = safeAnswer;
    }

    @Override
    public String toString() {
        return "SystemAdminInfoQueryDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", safeQuestion='" + safeQuestion + '\'' +
                ", safeAnswer='" + safeAnswer + '\'' +
                '}';
    }
}
