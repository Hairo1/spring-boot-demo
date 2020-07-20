package com.hairo.springbootmybatis_enum.code.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

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
     * 华为
     */
    HuaWei("华为"),

    /**
     * 其他
     */
    QiTa("其他"),

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

    private String label;

    @JsonValue
    @Override
    public String toString() {
        return label;
    }


    @JsonCreator
    public static Vendor formLabel(String value) {
        return Arrays.stream(Vendor.values())
                .filter(e -> e.getLabel().equals(value))
                .findFirst()
                .orElse(Vendor.Unknown);
    }
}
