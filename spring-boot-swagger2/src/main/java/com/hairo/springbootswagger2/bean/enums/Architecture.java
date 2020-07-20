package com.hairo.springbootswagger2.bean.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.io.Serializable;
import java.util.Arrays;

/**
 * AreaType 制式枚举
 *
 * @author Hairo
 * @since 2020-03-26 16:50:42
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Architecture implements Serializable {
    /**
     * 未知制式
     */
    Unknown("未知制式"),

    /**
     * NSA
     */
    NSA("输出锚点4-5邻区，5-5邻区"),

    /**
     * NSA 5-5
     */
    NSA_5_5("NSA-5-5"),

    /**
     * NSA-4-5-FDD1800锚点
     */
    NSA_4_5_FDD1800("NSA-4-5-FDD1800锚点"),

    /**
     * NSA-4-5-F锚点
     */
    NSA_4_5_F("NSA-4-5-F锚点"),

    /**
     * NSA-4-5(包含NSA-4-5-FDD1800锚点和NSA-4-5-F锚点)
     */
    NSA_4_5("NSA-4-5"),

    /**
     * SA
     */
    SA("输出锚点5-4邻区，5-5邻区"),

    /**
     * SA 5-5
     */
    SA_5_5("SA-5-5"),

    /**
     * SA 5-4
     */
    SA_5_4("SA-5-4");


    private String label;

    private Architecture (String label){
        this.label = label;
    }


    /**
     * 通过Label返回Architecture对象。
     *
     * @param value label
     * @return Architecture对象
     */
    public static Architecture fromLabel(String value) {
        return Arrays.stream(Architecture.values())
                .filter(e -> e.label.equals(value))
                .findFirst()
                .orElse(Architecture.Unknown);
    }

}
