package com.kevin.mirs.vo;


public class RegisterUser {

    private String username;
    private String email;
    private String passward;
    private String verification;

    public RegisterUser() {
    }

    public RegisterUser(String username, String email, String passward, String verification) {
        this.username = username;
        this.email = email;
        this.passward = passward;
        this.verification = verification;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassward() {
        return passward;
    }

    public String getVerification() {
        return verification;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", passward='" + passward + '\'' +
                ", verification='" + verification + '\'' +
                '}';
    }
}
