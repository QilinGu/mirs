package com.kevin.mirs.vo;


public class RegisterUser {

    private String username;
    private String email;
    private String password;
    private String verification;

    public RegisterUser() {
    }

    public RegisterUser(String username, String email, String password, String verification) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.verification = verification;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getVerification() {
        return verification;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verification='" + verification + '\'' +
                '}';
    }
}
