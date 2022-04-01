package com.pys.mybatis.enums;

public enum SexEnum {
    M("男"),
    W( "女"),
    N( "未知"),
    ;

    final String desc;

    SexEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}