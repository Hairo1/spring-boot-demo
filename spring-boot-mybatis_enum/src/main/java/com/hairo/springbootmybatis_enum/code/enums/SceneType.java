package com.hairo.springbootmybatis_enum.code.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 *
 * @author Hairo
 * @since 2020-03-26 16:50:42
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum SceneType implements Serializable {
    /**
     * 一般场景(除了高铁场景其它的所有都归为一版场景)
     */
    GeneralScene("一般场景"),

    /**
     * 根据5G工参“特殊场景类型”字段中，字段为“京港-武广”，“京港-广深港”，“杭福深-厦深”，“贵广客运专线”，“南广高速铁路”，“广佛肇城际”，
     * “广珠城际铁路”,“莞惠城轨”，“广佛环线”，“广清城轨”，“穗莞深城轨”，“茂湛”，“深茂”的目标小区为高铁小区，对应小区回填“高铁”
     */
    HsrScene("高铁场景");

    private String label;


    @Override
    public String toString() {
        return label;
    }

    public static SceneType formLabel(String value) {
        if ((Objects.isNull(value)) || ("".equals(value))) {
            return SceneType.GeneralScene;
        }
        switch (value) {
            case "高铁":
                return SceneType.HsrScene;
            case "高速铁路":
                return SceneType.HsrScene;
            case "深茂":
                return SceneType.HsrScene;
            case "茂湛":
                return SceneType.HsrScene;
            case "穗莞深城轨":
                return SceneType.HsrScene;
            case "广清城轨":
                return SceneType.HsrScene;
            case "广佛环线":
                return SceneType.HsrScene;
            case "莞惠城轨":
                return SceneType.HsrScene;
            case "广珠城际铁路":
                return SceneType.HsrScene;
            case "广佛肇城际":
                return SceneType.HsrScene;
            case "南广客运专线":
                return SceneType.HsrScene;
            case "贵广客运专线":
                return SceneType.HsrScene;
            case "杭福深-厦深":
                return SceneType.HsrScene;
            case "京港-广深港":
                return SceneType.HsrScene;
            case "京港-武广":
                return SceneType.HsrScene;
            default:
                return SceneType.GeneralScene;
        }
    }
}
