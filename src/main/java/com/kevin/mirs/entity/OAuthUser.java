package com.kevin.mirs.entity;


public class OAuthUser {

    private Integer id;
    private User user;
    private String oAuthType;
    private String oAuthId;
    private String oAuthAccessToken;
    private Integer oAuthAccessExpires;
    private String oAuthScope;

    public OAuthUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String getoAuthAccessToken() {
        return oAuthAccessToken;
    }

    public void setoAuthAccessToken(String oAuthAccessToken) {
        this.oAuthAccessToken = oAuthAccessToken;
    }

    public Integer getoAuthAccessExpires() {
        return oAuthAccessExpires;
    }

    public void setoAuthAccessExpires(Integer oAuthAccessExpires) {
        this.oAuthAccessExpires = oAuthAccessExpires;
    }

    public String getoAuthScope() {
        return oAuthScope;
    }

    public void setoAuthScope(String oAuthScope) {
        this.oAuthScope = oAuthScope;
    }

    @Override
    public String toString() {
        return "OAuthUser{" +
                "id=" + id +
                ", user=" + user +
                ", oAuthType='" + oAuthType + '\'' +
                ", oAuthId='" + oAuthId + '\'' +
                ", oAuthAccessToken='" + oAuthAccessToken + '\'' +
                ", oAuthAccessExpires=" + oAuthAccessExpires +
                ", oAuthScope='" + oAuthScope + '\'' +
                '}';
    }
}
