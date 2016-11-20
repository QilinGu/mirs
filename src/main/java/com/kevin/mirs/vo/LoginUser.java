package com.kevin.mirs.vo;


public class LoginUser {

    private String username;
    private String password;
    private String captcha;

    // FIXME: 2016/11/20 奇怪，不加上默认构造器就出错
    public LoginUser() {
    }

    public LoginUser(String username, String password, String captcha) {
        this.username = username;
        this.password = password;
        this.captcha = captcha;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", captcha='" + captcha + '\'' +
                '}';
    }
}
