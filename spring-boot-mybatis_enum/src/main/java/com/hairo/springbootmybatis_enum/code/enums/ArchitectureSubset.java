package com.hairo.springbootmybatis_enum.code.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Architecture 制式子集枚举
 *
 * @author Hairo
 * @since 2020-03-26 16:50:42
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ArchitectureSubset implements Serializable {

    /**
     * 未知制式 Unknown
     */
    Unknown("未知制式"),

    /**
     * NSA 5-5
     */
    NSA_5_5("NSA-5-5"),

    /**
     * NSA-4-5-FDD1800锚点
     */
    NSA_4_5_FDD1800("NSA-4-5-FDD1800"),

    /**
     * NSA-4-5-F锚点
     */
    NSA_4_5_F("NSA-4-5-F"),

    /**
     * NSA-4-5
     */
    NSA_4_5("NSA-4-5"),

    /**
     * SA 5-5
     */
    SA_5_5("SA-5-5"),

    /**
     * SA 5-4
     */
    SA_5_4("SA-5-4");


    private String label;

    /**
     * 通过Label返回Architecture对象。
     *
     * @param label label
     * @return Architecture对象
     */
    @SuppressWarnings("unused")
    @JsonCreator
    public static ArchitectureSubset fromLabel(String label) {
        return valueOf(Arrays.stream(ArchitectureSubset.values())
                .filter(e -> e.getLabel().equals(label))
                .findFirst()
                .orElse(ArchitectureSubset.Unknown).name());
    }
    @JsonValue
    @Override
    public String toString() {
        return label;
    }


}
