package com.kevin.mirs.enums;

/**
 * 邮件验证状态枚举
 */
public enum EVStatusEnum {
    ING('1', "正在验证"),
    EXPIRED('2', "验证超时"),
    FAILED('3', "验证失败"),
    SUCCESS('4', "验证成功")
    ;


    private Character status;
    private String description;

    EVStatusEnum(Character status, String description) {
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
