package com.kevin.mirs.entity;


import java.sql.Timestamp;

public class EmailVerify {

    private Integer id;
    private String email;
    private Timestamp createTime;
    private Timestamp expireTime;
    private Byte channel;
    private String verifyCode;
    private Byte verifyType;
    private String requestIp;
    private Byte state;
    private String parameter1;
    private String parameter2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    public Byte getChannel() {
        return channel;
    }

    public void setChannel(Byte channel) {
        this.channel = channel;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Byte getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(Byte verifyType) {
        this.verifyType = verifyType;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    @Override
    public String toString() {
        return "EmailVerify{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", expireTime=" + expireTime +
                ", channel=" + channel +
                ", verifyCode='" + verifyCode + '\'' +
                ", verifyType=" + verifyType +
                ", requestIp='" + requestIp + '\'' +
                ", state=" + state +
                ", parameter1='" + parameter1 + '\'' +
                ", parameter2='" + parameter2 + '\'' +
                '}';
    }
}
