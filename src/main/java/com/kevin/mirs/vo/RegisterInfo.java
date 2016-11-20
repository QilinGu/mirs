package com.kevin.mirs.vo;


import java.sql.Timestamp;

public class RegisterInfo {

    private String username;
    private String email;
    private String token;
    private Timestamp registerTime;
    private String registerIp;

    public RegisterInfo(String username, String email, String token, Timestamp registerTime, String registerIp) {
        this.username = username;
        this.email = email;
        this.token = token;
        this.registerTime = registerTime;
        this.registerIp = registerIp;
    }

    @Override
    public String toString() {
        return "RegisterInfo{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", registerTime=" + registerTime +
                ", registerIp='" + registerIp + '\'' +
                '}';
    }
}
