package com.lbhz.core.bean.auto;

public class UserBean {
    private String userName;

    private String password;

    public UserBean(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserBean() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}