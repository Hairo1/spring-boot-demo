package com.hairo.springbootmybatis_enum.code.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Architecture 制式枚举
 *
 * @author Hairo
 * @since 2020-03-26 16:50:42
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Architecture implements Serializable {

    /**
     * NSA
     */
    NSA("NSA"),

    /**
     * SA
     */
    SA("SA"),

    /**
     * SA
     */
    Unknown("未知制式");

    private String label;

    @JsonValue
    @Override
    public String toString() {
        return label;
    }

    @JsonCreator
    public static Architecture formLabel(String value) {
        return Arrays.stream(Architecture.values())
                .filter(e -> e.getLabel().equals(value) )
                .findFirst()
                .orElse(Architecture.Unknown);
    }
}
