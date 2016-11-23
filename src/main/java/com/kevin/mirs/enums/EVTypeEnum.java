package com.kevin.mirs.enums;

/**
 * 邮件验证状态枚举
 */
public enum EVTypeEnum {
    REG('1', "注册"),
    RESET('2', "找回密码"),
    UNUSUAL_LOGIN('3', "异地登陆")
    ;


    private Character type;
    private String description;

    EVTypeEnum(Character type, String description) {
        this.type = type;
        this.description = description;
    }

    public Character getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
