package com.hairo.springbootswagger2.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Hairo
 * @since 2020-03-26 16:50:42
 * 平均站间距区间类型
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum CellSpaceRange implements Serializable {

    /**
     * 平均站间距区间最小的 如 0-500
     */
    Minimum("Minimum"),

    /**
     * 平均站间距区间少的 如 500-800
     */
    Small("Small"),

    /**
     * 平均站间距区间微大的 如 800-1200
     */
    SlightlyBigger("SlightlyBigger"),

    /**
     * 平均站间距区间最大的 如 1200-5000
     */
    Maximum("Maximum"),

    /**
     * 未知平均站间距区间
     */
    Unknown("Unknown");

    private String intervalVal;
}
