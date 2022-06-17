package com.zijin.educationaladministration.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Autor: 丁小丁
 * @Desc: 系统登录
 */
@Entity
@Table(name="account")
public class Account {
    @Id
    private String account;
    private String password;
    private String role;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
