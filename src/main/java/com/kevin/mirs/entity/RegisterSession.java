package com.kevin.mirs.entity;


import java.util.Date;

public class RegisterSession {

    private Integer id;
    private Date createTime;
    private String email;
    private Byte state;
    private String clientIp;
    private Date expireTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "RegisterSession{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                ", state=" + state +
                ", clientIp='" + clientIp + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }
}
