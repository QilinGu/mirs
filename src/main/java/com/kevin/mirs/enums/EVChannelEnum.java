package com.kevin.mirs.enums;

/**
 * 邮件验证状态枚举
 */
public enum EVChannelEnum {
    WEB('1', "网页版")
    ;


    private Character channel;
    private String description;

    EVChannelEnum(Character channel, String description) {
        this.channel = channel;
        this.description = description;
    }

    public Character getChannel() {
        return channel;
    }

    public String getDescription() {
        return description;
    }
}
