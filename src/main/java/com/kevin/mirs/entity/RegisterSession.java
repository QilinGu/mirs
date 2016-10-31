package com.kevin.mirs.entity;


import java.sql.Timestamp;

public class RegisterSession {

    private Integer id;
    private Timestamp createTime;
    private String email;
    private Character status;
    private String clientIp;
    private Timestamp expireTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "RegisterSession{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", clientIp='" + clientIp + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }
}
