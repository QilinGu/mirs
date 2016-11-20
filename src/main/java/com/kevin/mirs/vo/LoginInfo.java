package com.kevin.mirs.vo;


public class LoginInfo {

    private String username;
    private String token;

    public LoginInfo(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
