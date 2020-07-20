package com.hairo.springbootswagger2.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Hairo
 * @since 2020-03-26 16:50:42
 * 地市
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum City implements Serializable {
    /**
     * 地市名称全拼首字母简写
     */
    GZ("广州"),
    SZ("深圳"),
    HZ("惠州"),
    ST("汕头"),
    FS("佛山"),
    SG("韶关"),
    ZJ("湛江"),
    ZQ("肇庆"),
    JM("江门"),
    MM("茂名"),
    MZ("梅州"),
    ZH("珠海"),
    SW("汕尾"),
    HY("河源"),
    YJ("阳江"),
    QY("清远"),
    DG("东莞"),
    ZS("中山"),
    CZ("潮州"),
    JY("揭阳"),
    YF("云浮"),
    /**
     * 未知城市
     */
    Unknown("未知城市");

    private String city;

}
