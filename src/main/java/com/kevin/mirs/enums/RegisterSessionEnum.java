package com.kevin.mirs.enums;


public enum RegisterSessionEnum {
    REG_ING('1', "正在注册"),
    REG_EXPIRED('2', "注册超时"),
    REG_FAILED('3', "注册失败"),
    REG_SUCCESS('4', "注册成功")
    ;


    private Character status;
    private String description;

    RegisterSessionEnum(Character status, String description) {
        this.status = status;
        this.description = description;
    }

    public Character getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

}
