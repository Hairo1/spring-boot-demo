package com.hairo.springbootswagger2.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Hairo
 * @since 2020-03-26 16:50:42
 * 厂家
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Vendor  implements Serializable {

    /**
     * 其他
     */
    QiTa("其他"),

    /**
     * 华为
     */
    HuaWei("华为"),

    /**
     * 中兴
     */
    ZhongXing("中兴"),

    /**
     * 大唐
     */
    DaTang("大唐"),

    /**
     * 诺西
     */
    NuoXi("诺西"),

    /**
     * 移动
     */
    YiDong("移动"),

    /**
     * 广东通宇
     */
    GuangDongTongYu("广东通宇"),

    /**
     * 诺基亚
     */
    NuoJiYa("诺基亚"),

    /**
     * 未知
     */
    Unknown("未知"),

    /**
     * 爱立信
     */
    AiLiXin("爱立信");

    private String vendorType;
}
