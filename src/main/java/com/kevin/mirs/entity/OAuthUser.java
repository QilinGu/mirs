package com.kevin.mirs.entity;


public class OAuthUser {

    private Integer id;


    private User user;

    private String oAuthType;
    private String oAuthId;
    public String getoAuthType() {
        return oAuthType;
    }
    public void setoAuthType(String oAuthType) {
        this.oAuthType = oAuthType;
    }
    public String getoAuthId() {
        return oAuthId;
    }
    public void setoAuthId(String oAuthId) {
        this.oAuthId = oAuthId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
