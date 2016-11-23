package com.kevin.mirs.enums;


/**
 * 注册状态枚举
 */
public enum RSStatusEnum {
    ING('1', "正在注册"),
    EXPIRED('2', "注册超时"),
    FAILED('3', "注册失败"),
    SUCCESS('4', "注册成功")
    ;


    private Character status;
    private String description;

    RSStatusEnum(Character status, String description) {
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
