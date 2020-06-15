package com.mySampleApplication.server.model;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "system_admin_account")
public class SystemAdminInfo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private int id ;

    @Column(name = "username",nullable = false)
    private String username ;

    @Column(name = "password",nullable = false)
    private String password ;

    @Column(name = "email",nullable = true)
    private String email ;

    @Column(name = "safe_question")
    private String safeQuestion ;

    @Column(name = "safe_answer")
    private String safeAnswer ;

    public SystemAdminInfo() {
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
        return "SystemAdminInfo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", safeQuestion='" + safeQuestion + '\'' +
                '}';
    }
}
