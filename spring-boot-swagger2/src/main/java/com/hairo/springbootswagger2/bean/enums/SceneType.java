package com.hairo.springbootswagger2.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * AreaType 场景枚举
 *
 * @author Hairo
 * @since 2020-03-26 16:50:42
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum SceneType implements Serializable {
    /**
     * 一般场景
     */
    GeneralScene("一般场景"),

    /**
     * 高铁场景
     */
    HsrScene("高铁场景");

    private String sceneEnum;
}
